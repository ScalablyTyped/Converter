// Type definitions for swiz
// Project: https://github.com/racker/node-swiz
// Definitions by: Jeff Goddard <https://github.com/jedigo>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped

// Imported from: https://github.com/soywiz/typescript-node-definitions/swiz.d.ts

declare module "swiz" {
    export class Swiz {
        constructor(defs: struct.IObj[], options?: ISwizOptions);

        serialize(mode: SERIALIZATION, version: number, obj: ISerializable, callback: (err: any, result: string) => void): void;

        serializeForPagination(mode: SERIALIZATION, array: any[], metadata: any, callback: (err: any, result: string) => void): void;

        deserialize(mode: SERIALIZATION, version: number, raw: string, callback: (err: any, result: any) => void): void;

        getFieldDefinition(stype: string, name: string): struct.IField;
    }

    namespace struct {
        export interface IField {
        }

        export interface IObj {
        }
    }

    export interface ISerializable {
        getSerializerType(): string;
    }

    export interface ISwizOptions {
        stripNulls?: boolean;
        stripSerializerType?: boolean;
        for?: string;
    }

    enum SERIALIZATION {
        _,
        notify,
        js,
        java,
        SERIALIZATION_JSON,
        SERIALIZATION_XML
    }
}

declare module "swiz-test-default" {
    import {SERIALIZATION} from "swiz";
    export default SERIALIZATION;
}

declare module "swiz-test-foo" {
    import { default as foo } from "swiz-test-default";
    export = foo;
}