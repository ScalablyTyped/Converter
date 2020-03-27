export interface HKT<URI, A> {
    readonly _URI: URI;
    readonly _A: A;
}
export interface URI2HKT<A> {
}
export declare type URIS = (URI2HKT<any> & {
    never: HKT<never, never>;
})[keyof URI2HKT<any> | 'never']['_URI'];

export declare type Type<URI extends URIS, A> = URI2HKT<A>[URI];
