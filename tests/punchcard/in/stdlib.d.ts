/// <reference no-default-lib="true"/>
interface Array<T> {}
type Extract<T, U> = T extends U ? T : never;

type Readonly<T> = {
    readonly [P in keyof T]: T[P];
};

