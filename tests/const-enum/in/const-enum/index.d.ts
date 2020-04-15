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


export const enum PreOrderHookFlags {
    /** The index of the next pre-order hook to be called in the hooks array, on the first 16
     bits */
    IndexOfTheNextPreOrderHookMaskMask = 65535,
    /**
     * The number of init hooks that have already been called, on the last 16 bits
     */
    NumberOfInitHooksCalledIncrementer = 65536,
    NumberOfInitHooksCalledShift = 16,
    NumberOfInitHooksCalledMask = 4294901760
}

