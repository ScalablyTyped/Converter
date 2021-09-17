interface Foo {
  name(p: any): void
}

interface FirebaseTest<T> extends Foo {

  name(p: any & T): void
  name(p: T & any): void

}