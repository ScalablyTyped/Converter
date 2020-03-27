/// <reference path="pixi.comments.d.ts" />
/// <reference path="p2.d.ts" />

// Type definitions for Phaser 2.6.2 - 26th August 2016
// Project: https://github.com/photonstorm/phaser

declare module "phaser" {
    export = Phaser;
}

declare class Phaser {
    static VERSION: string;
}

declare module Phaser {
    /**
     * An Animation instance contains a single animation and the controls to play it.
     *
     * It is created by the AnimationManager, consists of Animation.Frame objects and belongs to a single Game Object such as a Sprite.
     */
    class Animation {}
}

