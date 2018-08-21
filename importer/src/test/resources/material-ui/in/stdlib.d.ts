/// <reference no-default-lib="true"/>

interface Array<T> {}
interface Node{}
interface Element extends Node {}
interface HTMLElement extends Element {}
declare interface Function {}

declare type Partial<T> = T;