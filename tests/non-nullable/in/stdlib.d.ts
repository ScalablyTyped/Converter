/// <reference no-default-lib="true"/>

interface Array<T>{}
/** Exclude null and undefined from T (as defined since TypeScript 4.8) */
type NonNullable<T> = T & {};
