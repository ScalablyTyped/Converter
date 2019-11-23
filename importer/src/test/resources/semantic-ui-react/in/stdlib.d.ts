/// <reference no-default-lib="true"/>

declare interface Array<T> {}
declare interface Function {}
declare interface HTMLInputElement {}
declare interface HTMLButtonElement {}
declare interface HTMLFormElement {}

/**
 * Make all properties in T optional
 */
type Partial<T> = {
    [P in keyof T]?: T[P];
};

/**
 * Make all properties in T readonly
 */
type Readonly<T> = {
    readonly [P in keyof T]: T[P];
};

/**
 * From T pick a set of properties K
 */
type Pick<T, K extends keyof T> = {
    [P in K]: T[P];
};

/**
 * Construct a type with a set of properties K of type T
 */
type Record<K extends keyof any, T> = {
    [P in K]: T;
};
