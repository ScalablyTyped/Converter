package org.scalablytyped.converter.internal

import java.lang.Integer.{rotateLeft => rotl}
import scala.IterableOnce

/** Marker trait for types that implement stable hashing in their hashCode method.
  *
  * Contract:
  * - Types extending this trait guarantee their hashCode is stable across Scala versions
  * - They may use StableHash internally to hash tuples of their important fields
  * - StableHash will trust their hashCode and use it directly (no recursion into the object)
  *
  * Usage pattern:
  * {{{
  * class MyScope(val outer: Scope, val name: String) extends HasStableHash {
  *   override def hashCode: Int = StableHash((outer, name))
  * }
  * }}}
  */
trait HasStableHash

/** Provides stable hashing that doesn't change between Scala versions.
  *
  * Purpose:
  * - Scala's default hashCode for Products (case classes) is not stable across Scala 2.12, 2.13, and 3
  * - This causes problems when generating file names based on hash values
  * - StableHash provides consistent hashing across all Scala versions
  *
  * Implementation:
  * - Uses an inlined implementation of MurmurHash3 algorithm (same as Scala's default)
  * - The algorithm is copied directly to avoid version-specific changes
  * - Collections (Set, Map) are sorted before hashing to ensure order independence
  * - Sorting uses hash values first, then toString as a tiebreaker for stability
  *
  * Type handling:
  * - Primitives: Direct hash computation using Java standards
  * - Strings: MurmurHash3 string hashing with stable seed
  * - Collections: Sorted then hashed to ensure order independence
  * - HasStableHash types: Their hashCode is trusted and used directly
  * - Singleton objects: Hashed by their class name (stable identity)
  * - Products (case classes): Recursive hashing of all fields
  * - Paths: os.Path and java.nio.file.Path hashed by segments (avoids expensive toString)
  * - Special types: Comments, IArray have custom handling
  *
  * Contract with HasStableHash:
  * - If a type extends HasStableHash, StableHash trusts its hashCode
  * - This avoids infinite recursion and allows custom stable implementations
  * - Types should extend HasStableHash if they implement their own stable hash
  * - Types should NOT extend HasStableHash if they call StableHash(this)
  *
  * Usage:
  * {{{
  * // For types that need stable hashing
  * override lazy val hashCode: Int = StableHash(this)
  *
  * // For custom stable hashing
  * class MyType extends HasStableHash {
  *   override def hashCode: Int = StableHash((field1, field2))
  * }
  * }}}
  */
object StableHash {
  // MurmurHash3 constants - using stringHash for consistency
  final val productSeed = 0xcafebabe
  lazy val seqSeed      = stringHash("Seq")
  lazy val mapSeed      = stringHash("Map")
  lazy val setSeed      = stringHash("Set")

  /** Mix in a block of data into an intermediate hash value. */
  private def mix(hash: Int, data: Int): Int = {
    var h = mixLast(hash, data)
    h = rotl(h, 13)
    h * 5 + 0xe6546b64
  }

  /** May optionally be used as the last mixing step. */
  private def mixLast(hash: Int, data: Int): Int = {
    var k = data
    k *= 0xcc9e2d51
    k = rotl(k, 15)
    k *= 0x1b873593
    hash ^ k
  }

  /** Finalize a hash to incorporate the length and make sure all bits avalanche. */
  private def finalizeHash(hash: Int, length: Int): Int = {
    var h = hash ^ length
    h ^= h >>> 16
    h *= 0x85ebca6b
    h ^= h >>> 13
    h *= 0xc2b2ae35
    h ^= h >>> 16
    h
  }

  /** Generate a stable hash for any value by recursively computing hashes. */
  def apply(value: Any): Int = computeHash(value)

  private def computeHash(value: Any): Int = {
    value match {
      // Primitives and basic types
      case null => 0
      case s: String => stringHash(s)
      case b: Boolean => if (b) 1231 else 1237 // Standard Java boolean hash values
      case b: Byte => b.toInt
      case s: Short => s.toInt
      case i: Int => i
      case l: Long => (l ^ (l >>> 32)).toInt
      case f: Float => java.lang.Float.floatToIntBits(f)
      case d: Double =>
        val bits = java.lang.Double.doubleToLongBits(d)
        (bits ^ (bits >>> 32)).toInt
      case c: Char => c.toInt

      // Types that already implement stable hashing - use their hashCode
      case h: HasStableHash =>
        h.hashCode

      // os.Path - hash based on path segments
      case p: os.Path =>
        pathHash(p.wrapped)

      // os.RelPath - hash based on ups and segments
      case p: os.RelPath =>
        relPathHash(p)

      // java.nio.file.Path - hash based on path segments
      case p: java.nio.file.Path =>
        pathHash(p)

      // IArray (our custom immutable array)
      case arr: IArray[_] =>
        arrayHash(arr)

      // Collections
      case arr: Array[_] =>
        var h = 0x3c074a61 // arraySeed
        var i = 0
        while (i < arr.length) {
          h = mix(h, computeHash(arr(i)))
          i += 1
        }
        finalizeHash(h, arr.length)

      case list: List[_] =>
        var n     = 0
        var h     = seqSeed
        var elems = list
        while (elems.nonEmpty) {
          h = mix(h, computeHash(elems.head))
          n += 1
          elems = elems.tail
        }
        finalizeHash(h, n)

      case seq: Seq[_] =>
        orderedHash(seq, seqSeed)

      case set: Set[_] =>
        // Sort for stable ordering
        val withHashes = set.toSeq.map(elem => (elem, computeHash(elem)))

        val comparator = new Ordering[(Any, Int)] {
          def compare(a: (Any, Int), b: (Any, Int)): Int = {
            val hashCmp = Integer.compare(a._2, b._2)
            if (hashCmp != 0) hashCmp
            else a._1.toString.compareTo(b._1.toString) // Only compute toString if hashes are equal
          }
        }

        val sorted = withHashes.sorted(comparator)

        var h = setSeed
        var n = 0
        sorted.foreach {
          case (_, elemHash) =>
            h = mix(h, elemHash)
            n += 1
        }
        finalizeHash(h, n)

      case map: Map[_, _] =>
        // Sort for stable ordering
        val withHashes = map.toSeq.map { case (k, v) => (k, v, computeHash(k), computeHash(v)) }

        val comparator = new Ordering[(Any, Any, Int, Int)] {
          def compare(a: (Any, Any, Int, Int), b: (Any, Any, Int, Int)): Int = {
            val keyHashCmp = Integer.compare(a._3, b._3)
            if (keyHashCmp != 0) return keyHashCmp

            val valHashCmp = Integer.compare(a._4, b._4)
            if (valHashCmp != 0) return valHashCmp

            val keyStringCmp = a._1.toString.compareTo(b._1.toString)
            if (keyStringCmp != 0) return keyStringCmp

            a._2.toString.compareTo(b._2.toString)
          }
        }

        val sorted = withHashes.sorted(comparator)

        var h = mapSeed
        var n = 0
        sorted.foreach {
          case (_, _, kh, vh) =>
            h = mix(h, kh)
            h = mix(h, vh)
            n += 1
        }
        finalizeHash(h, n)

      case Some(x) =>
        var h = stringHash("Some")
        h = mix(h, computeHash(x))
        finalizeHash(h, 1)

      case None =>
        stringHash("None")

      // Products (case classes)
      case p: Product =>
        productHash(p)

      // Fallback - throw exception for unknown types
      case other =>
        throw new IllegalArgumentException(
          s"StableHash: Unsupported type ${other.getClass.getName}. " +
            s"Value: ${other.toString.take(100)}",
        )
    }
  }

  private def stringHash(str: String): Int = {
    var h = 0xf7ca7fd2 // stringSeed
    var i = 0
    while (i + 1 < str.length) {
      val data = (str.charAt(i) << 16) + str.charAt(i + 1)
      h = mix(h, data)
      i += 2
    }
    if (i < str.length) h = mixLast(h, str.charAt(i).toInt)
    finalizeHash(h, str.length)
  }

  private def productHash(x: Product): Int = {
    val arr = x.productArity
    if (arr == 0) {
      stringHash(x.productPrefix)
    } else {
      var h = productSeed
      var i = 0
      while (i < arr) {
        h = mix(h, computeHash(x.productElement(i)))
        i += 1
      }
      finalizeHash(h, arr)
    }
  }

  private def arrayHash(arr: IArray[_]): Int = {
    var h = 0x3c074a61 // arraySeed
    var i = 0
    while (i < arr.length) {
      h = mix(h, computeHash(arr(i)))
      i += 1
    }
    finalizeHash(h, arr.length)
  }

  private def pathHash(path: java.nio.file.Path): Int = {
    var h = stringHash("Path") // seed
    var n = 0

    // Hash root if present
    val root = path.getRoot
    if (root != null) {
      h = mix(h, stringHash(root.toString))
      n += 1
    }

    // Hash each path segment
    val iter = path.iterator()
    while (iter.hasNext) {
      h = mix(h, stringHash(iter.next().toString))
      n += 1
    }

    finalizeHash(h, n)
  }

  private def relPathHash(relPath: os.RelPath): Int = {
    var h = stringHash("RelPath") // seed
    var n = 0

    // Hash ups (parent directory traversals)
    h = mix(h, relPath.ups)
    n += 1

    // Hash each path segment
    relPath.segments.foreach { segment =>
      h = mix(h, stringHash(segment))
      n += 1
    }

    finalizeHash(h, n)
  }

  private def orderedHash(xs: IterableOnceIterableOnce[Any], seed: Int): Int =
    if (xs.isEmpty) {
      finalizeHash(seed, 0)
    } else {
      var n = 0
      var h = seed
      xs.foreach { x =>
        h = mix(h, computeHash(x))
        n += 1
      }
      finalizeHash(h, n)
    }
}
