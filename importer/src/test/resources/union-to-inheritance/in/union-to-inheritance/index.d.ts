type A = "a1" | "a2" | string
type B = "b1" | "b2" | number | A
type C = 1 | 2 | HTMLInputElement | Array<B> | B

interface Foo<U> {
    value: U
}

interface Foo2<U, V> {
    u: U
    v: V
}

interface Either<L, R> {
    value: R
}

type Illegal1 = "foo" | "bar" | Foo<string>
type Illegal2 = "foo" | "bar" | Foo<A>
type Illegal3<T> = "foo" | "bar" | Foo2<T, T>
type Legal1<T> = "foo" | "bar" | Foo<T>
type Legal2<P, T> = "foo" | "bar" | Foo<P> | Foo2<T, P>
type Legal3<T1, T2, T3> = "foo" | "bar" | Foo<T3> | Either<T2, T3> | Foo2<T1, T3>

type Test<T1, T2, T3> = "foo" | "bar" | TwoFoo<T3, T1> | Either<T2, T3> | Foo2<T1, T3>
type Test2<O1, O2> = Test<O1, O1, O2> | Either<O2, O1> | Legal1<O2>
