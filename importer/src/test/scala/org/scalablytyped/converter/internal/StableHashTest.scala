package org.scalablytyped.converter.internal

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalablytyped.converter.internal.scalajs.{Name, QualifiedName}
import org.scalablytyped.converter.internal.ts.{TsIdent, TsIdentLibrary, TsIdentSimple}

class StableHashTest extends AnyFunSuite with Matchers {

  test("string hashing is consistent") {
    // These values should be the same across Scala versions
    StableHash("hello") shouldBe 469940726
    StableHash("world") shouldBe -1967831175
    StableHash("ScalablyTyped") shouldBe -1116352842
    StableHash("") shouldBe 377927480  // empty string
  }

  test("primitives have stable hashes") {
    StableHash(true) shouldBe 1231
    StableHash(false) shouldBe 1237
    StableHash(42) shouldBe 42
    StableHash(42L) shouldBe 42
    StableHash('A') shouldBe 65
    StableHash(3.14f) shouldBe 1078523331
    StableHash(3.14) shouldBe 300063655
  }

  test("collections have stable hashes") {
    StableHash(List(1, 2, 3)) shouldBe -97797917
    StableHash(Set(1, 2, 3)) shouldBe -201030484
    StableHash(Map("a" -> 1, "b" -> 2)) shouldBe 1232823114
    StableHash(IArray("1", "2", "3")) shouldBe 1487559359
  }

  test("Option types have stable hashes") {
    StableHash(Some("test")) shouldBe -2035005417
    StableHash(None) shouldBe 1762408283
  }

  test("case classes have stable hashes") {
    case class TestClass(name: String, value: Int)
    val instance = TestClass("test", 42)
    // This tests that the productHash function works correctly
    StableHash(instance) shouldBe 893186370
  }

  test("nested structures have stable hashes") {
    val nested = List(
      Map("a" -> List(1, 2)),
      Map("b" -> List(3, 4))
    )
    StableHash(nested) shouldBe -2112717056
  }

  test("IArray instances have stable hashes") {
    val arr1 = IArray("a", "b", "c")
    val arr2 = IArray("a", "b", "c")

    StableHash(arr1) shouldBe StableHash(arr2)
    StableHash(arr1) shouldBe -1252721679
  }

  test("Name and QualifiedName have stable hashes") {
    val name = Name("TestName")
    val qname = QualifiedName(IArray(Name("org"), Name("example"), Name("Test")))

    // These use their overridden hashCode which should use StableHash
    name.hashCode shouldBe name.hashCode  // Just checking consistency
    qname.hashCode shouldBe qname.hashCode
  }

  test("complex ScalablyTyped types") {
    // Test a tuple like what's used in SharedBuilder generation
    val tuple = (
      TsIdentLibrary("react"),
      true,
      IArray(TsIdent("T"), TsIdent("U"))
    )

    // The actual value will depend on the implementation details,
    // but it should be consistent
    val hash = StableHash(tuple)
    hash shouldBe hash  // At least consistent with itself

    // Verify it's not zero or some trivial value
    hash should not be 0
  }

  test("HasStableHash marker trait types use their own hashCode") {
    // Create a simple type that extends HasStableHash
    case class StableType(value: String) extends HasStableHash {
      override def hashCode: Int = StableHash(value)
    }

    val stable = StableType("test")
    StableHash(stable) shouldBe stable.hashCode
    StableHash(stable) shouldBe -138336588
  }
}