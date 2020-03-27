declare namespace insight {
    interface IOptions {
        trackingCode:string;
    }

    interface IConfigstore {
        path:string;
        all:any;
        get(key:string):any;
        set(key:string, val:any):void;
        del(key:string):void;
    }

}

import IOptions = insight.IOptions;
import IConfigstore = insight.IConfigstore;

declare class Insight {
    config:IConfigstore;

    optOut:boolean;
    clientId:string;

    constructor(options:IOptions);

    track(...args:string[]):void;
}

export = Insight;
