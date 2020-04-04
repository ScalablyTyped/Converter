declare module "original" {
    export class RuntimeAnimation {}
}
declare module "babylonjs/index" {
    export * from "original";
}
declare module "middle" {
    export * from "babylonjs/index";
}
declare module "babylonjs" {
    export * from "middle";
}
