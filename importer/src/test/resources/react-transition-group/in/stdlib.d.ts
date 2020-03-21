/// <reference no-default-lib="true"/>

declare interface Array<T> { }

declare type Partial<T> = T;

interface Event { }
interface AnimationEvent extends Event { }
interface EventTarget { }
interface Element { }
interface HTMLElement extends Element { }
interface HTMLAnchorElement extends HTMLElement { }
interface HTMLAreaElement extends HTMLElement { }
interface HTMLAudioElement extends HTMLElement { }
interface HTMLAudioElement extends HTMLElement { }
interface SVGElement extends Element { }
interface SVGCircleElement extends SVGElement { }

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
