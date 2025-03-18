/**
 * This interface describes all the DOM dependent calls that Pixi makes throughout its codebase.
 * Implementations of this interface can be used to make sure Pixi will work in any environment,
 * such as browser, Web Workers, and Node.js.
 * @memberof environment
 */
export interface Adapter {
    /** Returns a WebGL rendering context. */
    getWebGLRenderingContext: () => typeof WebGLRenderingContext;
}