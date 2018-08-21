// Type definitions for PIXI with Phaser Deviations.

declare module PIXI {

    export var WEBGL_RENDERER: number;
    export var CANVAS_RENDERER: number;
    export var VERSION: string;

    export enum blendModes {

        NORMAL,
        ADD,
    }

    export enum scaleModes {

        DEFAULT,
        LINEAR,
        NEAREST

    }
}
