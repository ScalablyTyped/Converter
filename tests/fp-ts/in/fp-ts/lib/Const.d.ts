
declare module './HKT' {
    interface URI2HKT2<L, A> {
        Const: Const<L, A>;
    }
}
export declare const URI = "Const";
export declare type URI = typeof URI;
/**
 * @data
 * @constructor Const
 * @since 1.0.0
 */
export declare class Const<L, A> {
    readonly value: L;
    readonly _A: A;
    readonly _L: L;
    readonly _URI: URI;
    constructor(value: L);
    map<B>(f: (a: A) => B): Const<L, B>;
    contramap<B>(f: (b: B) => A): Const<L, B>;
    fold<B>(f: (l: L) => B): B;
    inspect(): string;
    toString(): string;
}
