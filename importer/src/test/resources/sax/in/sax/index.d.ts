// Type definitions for sax-js 1.x
// Project: https://github.com/isaacs/sax-js
// Definitions by: Asana <https://asana.com>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped
/// <reference types="node" />


export declare var EVENTS: string[];

interface SAXOptions {
    trim?: boolean;
    normalize?: boolean;
    lowercase?: boolean;
    xmlns?: boolean;
    noscript?: boolean;
    position?: boolean;
}

export interface QualifiedName {
    name: string;
    prefix: string;
    local: string;
    uri: string;
}

export interface QualifiedAttribute extends QualifiedName {
    value: string;
}

interface BaseTag {
    name: string;
    isSelfClosing: boolean;
}

// Interface used when the xmlns option is set
export interface QualifiedTag extends QualifiedName, BaseTag {
    ns: { [key: string]: string };
    attributes: { [key: string]: QualifiedAttribute };
}

export interface Tag extends BaseTag {
    attributes: { [key: string]: string };
}

export declare function parser(strict: boolean, opt: SAXOptions): SAXParser;
export declare class SAXParser {
    constructor(strict: boolean, opt: SAXOptions);
    write(s: string): SAXParser;
}

import stream = require("stream");
export declare function createStream(strict: boolean, opt: SAXOptions): SAXStream;
export declare class SAXStream extends stream.Duplex {
    constructor(strict: boolean, opt: SAXOptions);
    private _parser: SAXParser;
}
