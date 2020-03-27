// Type definitions for Angular JS 1.6
// Project: http://angularjs.org
// Definitions by: Diego Vilar <https://github.com/diegovilar>
//                 Georgii Dolzhykov <https://github.com/thorn0>
//                 Caleb St-Denis <https://github.com/calebstdenis>
//                 Leonard Thieu <https://github.com/leonard-thieu>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped
// TypeScript Version: 2.3

/// <reference path="jqlite.d.ts" />

declare var angular: angular.IAngularStatic;

// Support for painless dependency injection
declare global {
    interface Function {
        $inject?: ReadonlyArray<string>;
    }
}

export as namespace angular;
export as namespace ng;

// Support AMD require
export = angular;

import ng = angular;

///////////////////////////////////////////////////////////////////////////////
// ng module (angular.js)
///////////////////////////////////////////////////////////////////////////////
declare namespace angular {
    type Injectable<T extends Function> = T | Array<string | T>;

    // All service providers extend this interface
    interface IServiceProvider {
        $get: any;
    }

    ///////////////////////////////////////////////////////////////////////////
    // AngularStatic
    // see http://docs.angularjs.org/api
    ///////////////////////////////////////////////////////////////////////////
    interface IAngularStatic {
        /**
         * Wraps a raw DOM element or HTML string as a jQuery element.
         *
         * If jQuery is available, angular.element is an alias for the jQuery function. If jQuery is not available, angular.element delegates to Angular's built-in subset of jQuery, called "jQuery lite" or "jqLite."
         */
        element: JQueryStatic;
        equals(value1: any, value2: any): boolean;
        extend(destination: any, ...sources: any[]): any;

        /**
         * If window.name contains prefix NG_DEFER_BOOTSTRAP! when angular.bootstrap is called, the bootstrap process will be paused until angular.resumeBootstrap() is called.
         * @param extraModules An optional array of modules that should be added to the original list of modules that the app was about to be bootstrapped with.
         */
        resumeBootstrap?(extraModules?: string[]): ng.auto.IInjectorService;
    }

    namespace auto {
        ///////////////////////////////////////////////////////////////////////
        // InjectorService
        // see http://docs.angularjs.org/api/AUTO.$injector
        ///////////////////////////////////////////////////////////////////////
        interface IInjectorService {
            annotate(fn: Function, strictDi?: boolean): string[];
            annotate(inlineAnnotatedFunction: any[]): string[];
            get<T>(name: string, caller?: string): T;
            has(name: string): boolean;
            instantiate<T>(typeConstructor: {new(...args: any[]): T}, locals?: any): T;
            invoke<T = any>(func: Injectable<Function | ((...args: any[]) => T)>, context?: any, locals?: any): T;
            strictDi: boolean;
        }
    }
}
