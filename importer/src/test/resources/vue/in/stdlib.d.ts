/// <reference no-default-lib="true"/>

interface Array<T> {}
interface Node{}
interface Element extends Node {}
interface HTMLElement extends Element {}

interface ThisType<T> { }

type Record<K extends string, T> = {
    [P in K]: T;
};
type Readonly<T> = {
    readonly [P in keyof T]: T[P];
};

interface RegExp {}
declare const RegExp: RegExp;

interface PromiseLike<T> {}
interface Promise<T> {}
declare const Promise: Promise<any>;

interface Error {}
declare const Error: Error;

interface Function {}
declare const Function: Function;

interface Blob{}

interface Object {}