// Type definitions for ADAL.JS 1.0.8
// Project: https://github.com/AzureAD/azure-activedirectory-library-for-js
// Definitions by: mmaitre314 <https://github.com/mmaitre314>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped

declare namespace adal {
    interface RequestInfo {
        valid: boolean;
        parameters: any;
        stateMatch: boolean;
        stateResponse: string;
        requestType: string;
    }
    
    interface Logging {
        log: (message: string) => void;
        level: string;
    }

}
