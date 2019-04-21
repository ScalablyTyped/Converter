interface C {
    c?: number
}

interface B {
    b: string;
}

interface A extends B {
    a: number;
}

type TA = A | B | keyof C

interface Example {
    expandKeyOf<K extends keyof A>(key: K, foo: A[K]): number
    expandUnion<T extends C | B>(bc: T): T
    expandBoth<T extends C | B | object, K extends keyof A>(bc: T, key: K, foo: A[K]): T
    expandAlias<T extends TA>(bc: T)
}
