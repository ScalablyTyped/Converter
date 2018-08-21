/// <reference no-default-lib="true"/>

interface SomethingHasToBeHereApparently {}

type Pick<T, K extends keyof T> = {
    [P in K]: T[P];
};
