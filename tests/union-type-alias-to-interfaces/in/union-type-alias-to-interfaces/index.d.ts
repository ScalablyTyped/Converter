interface A {a: "a"}
interface B {b: "b"}
interface C {c: "c"}
interface D {d: "d"}

type AB = A | B
type AC = A | C
type ABC = AB | AC
type ABD = A & B | D

// const abd: ABD = {
//     a: "a",
//     b: "b",
//     d: "d"
// };
// const foo = 'b' in abd ? abd.a : abd.d;
//
