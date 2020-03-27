interface Error {
    stack?: string;
}

interface SymbolConstructor {
    readonly iterator: symbol;
    readonly asyncIterator: symbol;
}

declare var Symbol: SymbolConstructor;
declare var process: NodeJS.Process;

declare namespace NodeJS {

    export interface ErrnoException extends Error {
        errno?: number;
        code?: string;
        path?: string;
        syscall?: string;
        stack?: string;
    }

    export class EventEmitter {
        emit(event: string | symbol, ...args: any[]): boolean;
    }

    export interface ReadableStream extends EventEmitter {
        readable: boolean;
    }

    export interface WritableStream extends EventEmitter {
        writable: boolean;
    }

    export interface ReadWriteStream extends ReadableStream, WritableStream {
    }

    export interface Process extends EventEmitter {
        bar: "foo";
    }
}


declare module "fs" {
    import * as stream from "stream";

    export class ReadStream extends stream.Readable {
    }

    export class WriteStream extends stream.Writable {
    }

}

declare module "stream" {

    namespace internal {
        export class Stream {}

        export class Readable extends Stream implements NodeJS.ReadableStream {
            readable: boolean;

            emit(event: string | symbol, ...args: any[]): boolean;

            read(size?: number): string;
        }


        export class Writable extends Stream implements NodeJS.WritableStream {
            writable: boolean;

            emit(event: string | symbol, ...args: any[]): boolean;

            end(str: string, encoding?: string, cb?: Function): void;
        }

        // Note: Duplex extends both Readable and Writable.
        export class Duplex extends Readable implements Writable {
            writable: boolean;

            end(str: string, encoding?: string, cb?: Function): void;
            end(cb?: Function): void;
            end(chunk: any, cb?: Function): void;
            end(chunk: any, encoding?: string, cb?: Function): void;
        }
    }

    export = internal;
}
