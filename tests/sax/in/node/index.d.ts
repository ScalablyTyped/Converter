// Type definitions for Node.js 9.6.x
// Project: http://nodejs.org/
// Definitions by: Microsoft TypeScript <http://typescriptlang.org>
//                 DefinitelyTyped <https://github.com/DefinitelyTyped/DefinitelyTyped>
//                 Parambir Singh <https://github.com/parambirs>
//                 Christian Vaagland Tellnes <https://github.com/tellnes>
//                 Wilco Bakker <https://github.com/WilcoBakker>
//                 Nicolas Voigt <https://github.com/octo-sniffle>
//                 Chigozirim C. <https://github.com/smac89>
//                 Flarna <https://github.com/Flarna>
//                 Mariusz Wiktorczyk <https://github.com/mwiktorczyk>
//                 wwwy3y3 <https://github.com/wwwy3y3>
//                 Deividas Bakanas <https://github.com/DeividasBakanas>
//                 Kelvin Jin <https://github.com/kjin>
//                 Alvis HT Tang <https://github.com/alvis>
//                 Oliver Joseph Ash <https://github.com/OliverJAsh>
//                 Sebastian Silbermann <https://github.com/eps1lon>
//                 Hannes Magnusson <https://github.com/Hannes-Magnusson-CK>
//                 Alberto Schiabel <https://github.com/jkomyno>
//                 Klaus Meinhardt <https://github.com/ajafff>
//                 Huw <https://github.com/hoo29>
//                 Nicolas Even <https://github.com/n-e>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped

/** inspector module types */


interface Error {
    stack?: string;
}

/************************************************
*                                               *
*                   GLOBAL                      *
*                                               *
************************************************/
declare var global: NodeJS.Global;

declare var SlowBuffer: {
    new(str: string, encoding?: string): Buffer;
    new(size: number): Buffer;
    new(size: Uint8Array): Buffer;
    new(array: any[]): Buffer;
    prototype: Buffer;
    isBuffer(obj: any): boolean;
    byteLength(string: string, encoding?: string): number;
    concat(list: Buffer[], totalLength?: number): Buffer;
};

interface Buffer extends NodeBuffer { }

/**
 * Raw data is stored in instances of the Buffer class.
 * A Buffer is similar to an array of integers but corresponds to a raw memory allocation outside the V8 heap.  A Buffer cannot be resized.
 * Valid string encodings: 'ascii'|'utf8'|'utf16le'|'ucs2'(alias of 'utf16le')|'base64'|'binary'(deprecated)|'hex'
 */
declare var Buffer: {
    /**
     * Allocates a new buffer containing the given {str}.
     *
     * @param str String to store in buffer.
     * @param encoding encoding to use, optional.  Default is 'utf8'
     */
    new(str: string, encoding?: string): Buffer;
    /**
     * Allocates a new buffer of {size} octets.
     *
     * @param size count of octets to allocate.
     */
    new(size: number): Buffer;
    /**
     * Allocates a new buffer containing the given {array} of octets.
     *
     * @param array The octets to store.
     */
    new(array: Uint8Array): Buffer;
    /**
     * Produces a Buffer backed by the same allocated memory as
     * the given {ArrayBuffer}.
     *
     *
     * @param arrayBuffer The ArrayBuffer with which to share memory.
     */
    new(arrayBuffer: ArrayBuffer): Buffer;
    /**
     * Allocates a new buffer containing the given {array} of octets.
     *
     * @param array The octets to store.
     */
    new(array: any[]): Buffer;
    /**
     * Copies the passed {buffer} data onto a new {Buffer} instance.
     *
     * @param buffer The buffer to copy.
     */
    new(buffer: Buffer): Buffer;
    prototype: Buffer;
    /**
     * Allocates a new Buffer using an {array} of octets.
     */
    from(array: any[]): Buffer;
};

/************************************************
*                                               *
*               GLOBAL INTERFACES               *
*                                               *
************************************************/
declare namespace NodeJS {

    export class EventEmitter {
        on(event: string | symbol, listener: (...args: any[]) => void): this;
    }

    export interface ReadableStream extends EventEmitter {
        read(size?: number): string | Buffer;
    }

    export interface WritableStream extends EventEmitter {
        writable: boolean;
        end(str: string, encoding?: string, cb?: Function): void;
    }

    export interface Global {
        Array: typeof Array;
        global: Global;
    }

}

interface NodeBuffer extends Uint8Array {
    write(string: string, offset?: number, length?: number, encoding?: string): number;
}

/************************************************
*                                               *
*                   MODULES                     *
*                                               *
************************************************/
declare module "buffer" {
    export var INSPECT_MAX_BYTES: number;
    var BuffType: typeof Buffer;
    var SlowBuffType: typeof SlowBuffer;
    export { BuffType as Buffer, SlowBuffType as SlowBuffer };
}


declare module "events" {
    class internal extends NodeJS.EventEmitter { }

    namespace internal {
        export class EventEmitter extends internal {
            static listenerCount(emitter: EventEmitter, event: string | symbol): number; // deprecated

            on(event: string | symbol, listener: (...args: any[]) => void): this;
        }
    }

    export = internal;
}


declare module "stream" {
    import * as events from "events";

    class internal extends events.EventEmitter {
        pipe<T extends NodeJS.WritableStream>(destination: T, options?: { end?: boolean; }): T;
    }

    namespace internal {
        export class Stream extends internal { }

        export interface ReadableOptions {
            highWaterMark?: number;
            encoding?: string;
            objectMode?: boolean;
            read?: (this: Readable, size?: number) => any;
            destroy?: (error?: Error) => any;
        }

        export class Readable extends Stream implements NodeJS.ReadableStream {
            read(size?: number): any;
            on(event: string, listener: (...args: any[]) => void): this;
            on(event: "close", listener: () => void): this;
        }

        export interface WritableOptions {
            final?: (callback: (error?: Error) => void) => void;
        }

        export class Writable extends Stream implements NodeJS.WritableStream {
            writable: boolean;
            constructor(opts?: WritableOptions);
            end(cb?: Function): void;
            end(chunk: any, cb?: Function): void;
            end(chunk: any, encoding?: string, cb?: Function): void;

            on(event: string, listener: (...args: any[]) => void): this;
            on(event: "close", listener: () => void): this;

        }

        export interface DuplexOptions extends ReadableOptions, WritableOptions {
            allowHalfOpen?: boolean;
        }

        // Note: Duplex extends both Readable and Writable.
        export class Duplex extends Readable implements Writable {
            writable: boolean;
            constructor(opts?: DuplexOptions);
            end(cb?: Function): void;
            end(chunk: any, cb?: Function): void;
            end(chunk: any, encoding?: string, cb?: Function): void;
        }
    }

    export = internal;
}
