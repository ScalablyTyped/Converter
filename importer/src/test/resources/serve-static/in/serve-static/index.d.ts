import * as express from "express-serve-static-core";
import * as m from "mime";

declare function serveStatic(root: string, options?: serveStatic.ServeStaticOptions): express.Handler;

declare namespace serveStatic {
    var mime: typeof m;
    interface ServeStaticOptions {

        setHeaders?: (res: express.Response, path: string, stat: any) => any;
    }
    function serveStatic(root: string, options?: ServeStaticOptions): express.Handler;
}

export = serveStatic;
