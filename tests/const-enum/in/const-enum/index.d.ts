declare const enum Foo {
    A = 1,
    B = 22,
    C = "C"
}

export declare const foo: (x: Foo.A | Foo.C) => number;
export declare const bar: (x: Foo) => Foo.B;

export declare const enum Foo2 {
    A,
    B = 22,
    C = A + 1
}

export declare const foo2: (x: Foo2) => number;

export {Foo2 as Foo3}
