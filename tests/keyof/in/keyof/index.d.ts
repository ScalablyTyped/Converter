interface A {
    a: number
    b: number
    c: number
}

declare class B {
    foo: (p: keyof A) => string;
    foo2: <T>(p: keyof T) => string;
}

declare namespace C {
    const bar: (p: keyof Pick<A, "c" | "b">) => string;
}
