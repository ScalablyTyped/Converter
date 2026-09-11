export interface Source {}
export interface Transform {}
export interface Destination {}

// rest element in the middle of a tuple
export declare function pipeline(...streams: [Source, ...Array<Transform>, Destination]): void;

// rest element at the end of a tuple
export declare const trailing: [string, ...number[]];

// rest element in a member of an object type, with a sibling member named `array`
export declare const iter: {
    array(source: Source): Array<string>;
    compose(...streams: [Source, ...Array<Transform>, Destination]): Destination;
};
