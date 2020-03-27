// Type definitions for Cldr.js 0.4.4
// Project: https://github.com/rxaviers/cldrjs
// Definitions by: Raman But-Husaim <https://github.com/RamanBut-Husaim>, Grégoire Castre <https://github.com/gcastre>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped

export = self;
export as namespace Cldr;

declare var self: self.CldrFactory;

declare namespace self {
    interface Attributes {
        language: any;

    }

    /**
     * @name CldrStatic
     * @memberof cldr
     * @kind interface
     *
     * @description
     * The cldr class definition.
     */
    interface CldrStatic {
        get(path: string) : any;

    }

    interface CldrFactory {
        load(json: any, ...otherJson: any[]): void;
    }

    interface CldrStatic {
        on(event:string, listener:(path:string, value:any) => void): void;
        once(event:string, listener:(path:string, value:any) => void): void;
        off(event:string, listener:(path:string, value:any) => void): void;
    }

    interface CldrFactory {
        on(event:string, listener:(path:string, value:any) => void): void;
        once(event:string, listener:(path:string, value:any) => void): void;
        off(event:string, listener:(path:string, value:any) => void): void;
    }

}
