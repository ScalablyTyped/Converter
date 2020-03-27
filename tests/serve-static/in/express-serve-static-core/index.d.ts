declare global {
    namespace Express {
        // These open interfaces may be extended in an application-specific manner via declaration merging.
        // See for example method-override.d.ts (https://github.com/DefinitelyTyped/DefinitelyTyped/blob/master/types/method-override/index.d.ts)
        interface Request { }
        interface Response { }
        interface Application { }
    }
}


export interface NextFunction {
    // tslint:disable-next-line callable-types (In ts2.1 it thinks the type alias has no call signatures)
    (err?: any): void;
}

export interface RequestHandler {
    // tslint:disable-next-line callable-types (This is extended from and can't extend from a type alias in ts<2.2
    (req: Request, res: Response, next: NextFunction): any;
}

export interface Handler extends RequestHandler { }


export interface Request extends Express.Request {
    url: string;
}

export interface Response extends Express.Response {
    location(url: string): Response;
}
