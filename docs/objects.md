---
id: objects
title: Working with objects
---

Javascript is remarkably flexible. When we integrate with arbitrary Javascript code in Scala.js, we need a very flexible
 encoding to tag along. The encoding chosen for ScalablyTyped is the result of years of experimentation, and has 
 a much more dynamic feeling than what you may be used to.

Let's start with an example of a type definition we want to use:

```scala
@js.native
trait Point extends StObject {

 var x: Double = js.native

 var y: Double = js.native
}
object Point {

 @scala.inline
 def apply(x: Double, y: Double): Point = {
  val __obj = js.Dynamic.literal(x = x.asInstanceOf[js.Any], y = y.asInstanceOf[js.Any])
  __obj.asInstanceOf[Point]
 }

 @scala.inline
 implicit class PointMutableBuilder[Self <: Point] (val x: Self) extends AnyVal {

  @scala.inline
  def setX(value: Double): Self = StObject.set(x, "x", value.asInstanceOf[js.Any])

  @scala.inline
  def setY(value: Double): Self = StObject.set(x, "y", value.asInstanceOf[js.Any])
 }
}
```

We notice several things:
- it's a `@js.native` trait, so we cannot `new` it ourselves. This can be [`changed`](conversion-options.md#stenablescalajsdefined), but it's not recommended.
- it has two required members (`x` and `y`). Optional members would typically be wrapped in `js.UndefOr`
- it has an `object` with syntax to help us work with it
- the entire syntax is built on mutability. It's Javascript, after all. more on that further down

### Basic usage

```scala
// At construction time we need to supply all required parameters
val p = Point(x = 1,y = 2)

// we can mutate what we have
// this is equivalent to typescript `p.x = 3
val p2 = p.setX(3) 

// or we can duplicate and then mutate.
// this is equivalent to typescript `const p2 = {...p, x: 3}
val p3 = p.duplicate.setX(3) 

// we can combine with other javascript objects. 
// this is equivalent to javascript `const p3 = {...p, {}}`
val p4: Point with TickOptions = p.combineWith(TickOptions())

// fallback, if the type definitions are wrong or for any other reason you can break the contract
val p5: p.duplicate.set("x", "foo")

// you can also set any other property
val p6: p.duplicate.set("x2", "foo")
```

### Optional/nullable members

```scala
@js.native
trait Nullability extends StObject {
 // number
 var a: scala.Double = js.native
 // number | undefined 
 var b: js.UndefOr[scala.Double] = js.native
 // number | null
 var c: scala.Double | Null = js.native
 // number | null | undefined
 var d: js.UndefOr[scala.Double | Null] = js.native
}
object Nullability {

 @scala.inline
 def apply(a: scala.Double): Nullability = {
  val c = null.asInstanceOf[scala.Double]
  val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any], c = c.asInstanceOf[js.Any])
  __obj.asInstanceOf[Nullability]
 }

 @scala.inline
 implicit class NullabilityMutableBuilder[Self <: Nullability] (val x: Self) extends AnyVal {

  @scala.inline
  def setA(value: scala.Double): Self = StObject.set(x, "a", value.asInstanceOf[js.Any])

  @scala.inline
  def setB(value: scala.Double): Self = StObject.set(x, "b", value.asInstanceOf[js.Any])

  @scala.inline
  def setBUndefined: Self = StObject.set(x, "b", js.undefined)

  @scala.inline
  def setC(value: scala.Double): Self = StObject.set(x, "c", value.asInstanceOf[js.Any])

  @scala.inline
  def setCNull: Self = StObject.set(x, "c", null)

  @scala.inline
  def setD(value: scala.Double): Self = StObject.set(x, "d", value.asInstanceOf[js.Any])

  @scala.inline
  def setDNull: Self = StObject.set(x, "d", null)

  @scala.inline
  def setDUndefined: Self = StObject.set(x, "d", js.undefined)
 }
}
```

We can see that:
- we need to supply `a`
- `apply` sets `c` to `null`, because it cannot be `undefined`.
- `d` can also be null, but since it can be `undefined` it's left at that. 
- there are various setters for `b`, `c` and `d`. This is primarily because of type inference. For instance if `setC` was defined as `def setC(value: js.UndefOr[Double]): Self` you can't call it like `.setC(1)`, because it would require two conversions by the compiler when it'll only do one.

To fully construct the object you'll typically call various setters on it:
```scala
Nullability(a = 1)
  .setB(2)
  .setC(3)
  .setDNull
```

#### What if I have optional types as input?
```scalac
val n = Nullability(1)
val bOpt: js.UndefOr[Double] = 1

val n2: Nullability = ???
```

The API is admittedly not great for this right now.
```scala
// if you don't know that `b` is empty in the object you receive
bOpt.fold(n.duplicate.setBUndefined)(b => n.duplicate.setB(b))
// if you're constructing an object and you know `b` is empty
bOpt.foreach(n.setB)

```

### Overloads for complicated types

Here is a trait with a member which can be either a function or a string. this is typically hopeless for type inference.
With the mutable builder encoding we're free to generate as many overloads as we want:

```scala
@js.native
trait Complex extends StObject {
  
  var a: (js.Function1[/* n */ scala.Double, Unit]) | String = js.native
}
object Complex {
  
  @scala.inline
  def apply(a: (js.Function1[/* n */ scala.Double, Unit]) | String): Complex = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any])
    __obj.asInstanceOf[Complex]
  }
  
  @scala.inline
  implicit class ComplexMutableBuilder[Self <: Complex] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setA(value: (js.Function1[/* n */ scala.Double, Unit]) | String): Self = StObject.set(x, "a", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAFunction1(value: /* n */ scala.Double => Unit): Self = StObject.set(x, "a", js.Any.fromFunction1(value))
  }
}
// usage
Complex().setAFunction1(n => println(n))
```

Note that `setAFunction1` takes a scala function and converts it to a javascript function in the body. 
This is actually an extensible mechanism, through [flavours](./flavour.md), so if you use the scalajs-react flavour it would look like this:
```scala
def setAFunction1(value: /* n */ scala.Double => Callback): Self = StObject.set(x, "a", js.Any.fromFunction1((t0: /* n */ scala.Double) => value(t0).runNow()))
```

There is no `setAString` method because the converter knows that the implicit conversion from `String` to `(js.Function1[/* n */ scala.Double, Unit]) | String` will succeed.

### Inheritance and type parameters
```scala
@js.native
trait Parent[T] extends StObject {
  
  var t: T = js.native
}
object Parent {
  
  @scala.inline
  def apply[T](t: T): Parent[T] = {
    val __obj = js.Dynamic.literal(t = t.asInstanceOf[js.Any])
    __obj.asInstanceOf[Parent[T]]
  }
  
  @scala.inline
  implicit class ParentMutableBuilder[Self <: Parent[_], T] (val x: Self with Parent[T]) extends AnyVal {
    
    @scala.inline
    def setT(value: T): Self = StObject.set(x, "t", value.asInstanceOf[js.Any])
  }
}

@js.native
trait Child[T1, T2] extends Parent[T1] {

 var t2: js.UndefOr[T2] = js.native
}
object Child {

 @scala.inline
 def apply[T1, T2](t: T1): Child[T1, T2] = {
  val __obj = js.Dynamic.literal(t = t.asInstanceOf[js.Any])
  __obj.asInstanceOf[Child[T1, T2]]
 }

 @scala.inline
 implicit class ChildMutableBuilder[Self <: Child[_, _], T1, T2] (val x: Self with (Child[T1, T2])) extends AnyVal {

  @scala.inline
  def setT2(value: T2): Self = StObject.set(x, "t2", value.asInstanceOf[js.Any])

  @scala.inline
  def setT2Undefined: Self = StObject.set(x, "t2", js.undefined)
 }
}

```

The important takeaway is that type parameters work, and you can use the setters from all parents on your object:
```scala
  val c = Child[Int, String](1)
  val c2 = c.setT2("foo")
  val c3: Child[Int, String] = c.setT(1)
```
This is where the `Self` type parameter and the intersection type comes into play. It's necessary to use parent setters without losing type information.


### Literal types

Given this typescript definition:
```typescript
interface Branch<T> {
 type: "Branch"
 left: T
 right: T
}

interface Leaf<T>  {
 type: "Leaf"
 value: T
}

type Tree<T> = Branch<T> | Leaf<T>
```

This is what we end up with for `Branch`. As you can see the `type` member is set to the only value it can have.

```scala
@js.native
trait Branch[T] extends Tree[T] {

 var left: T = js.native

 var right: T = js.native

 var `type`: typings.documentation.documentationStrings.Branch = js.native
}
object Branch {

 @scala.inline
 def apply[T](left: T, right: T): Branch[T] = {
  val `type` = "Branch"
  val __obj = js.Dynamic.literal(left = left.asInstanceOf[js.Any], right = right.asInstanceOf[js.Any])
  __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
  __obj.asInstanceOf[Branch[T]]
 }

 @scala.inline
 implicit class BranchMutableBuilder[Self <: Branch[_], T] (val x: Self with Branch[T]) extends AnyVal {

  @scala.inline
  def setLeft(value: T): Self = StObject.set(x, "left", value.asInstanceOf[js.Any])

  @scala.inline
  def setRight(value: T): Self = StObject.set(x, "right", value.asInstanceOf[js.Any])

  @scala.inline
  def setType(value: typings.documentation.documentationStrings.Branch): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
 }
}
```

Usage: 
```scala
Branch(Leaf(1), Leaf(1))
```

The constructor methods are also exposed through `Tree`, which makes them even easier to find in your IDE: 
```scala
Tree.Branch(Tree.Leaf(1), Tree.Leaf(1))
```
