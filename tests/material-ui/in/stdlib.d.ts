/// <reference no-default-lib="true"/>

interface Array<T> {}
interface Node{}
interface Element extends Node {}
interface HTMLElement extends Element {}
interface HTMLAnchorElement extends Element {}
interface HTMLAreaElement extends Element {}
interface HTMLAudioElement extends Element {}
interface SVGCircleElement extends Element {}

declare interface Function {}

declare type Partial<T> = T;

interface HTMLElementTagNameMap {
    "a": HTMLAnchorElement;
    "abbr": HTMLElement;
    "address": HTMLElement;
    "area": HTMLAreaElement;
    "article": HTMLElement;
    "aside": HTMLElement;
    "audio": HTMLAudioElement;
}

interface SVGElementTagNameMap {
    "circle": SVGCircleElement;
}
