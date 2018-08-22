/// <reference no-default-lib="true"/>

interface Error{}
interface Array<T>{}
interface HTMLElement{}
type Pick<T, K extends keyof T> = {
    [P in K]: T[P];
};
