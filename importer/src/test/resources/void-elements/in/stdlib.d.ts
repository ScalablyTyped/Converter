/// <reference no-default-lib="true"/>

interface Array<T>{}
type Partial<T> = {
    [P in keyof T]?: T[P];
};
type Record<K extends keyof any, T> = {
    [P in K]: T;
};
