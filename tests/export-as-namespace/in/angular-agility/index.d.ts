// Type definitions for AngularAgility
// Project: https://github.com/AngularAgility/AngularAgility
// Definitions by: Roland Zwaga <https://github.com/rolandzwaga>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped
// TypeScript Version: 2.3

/// <reference types="angular" />

declare namespace aa {
    export interface INotifyConfigProvider extends ng.IServiceProvider {
        notifyConfigs:any;
        defaultTargetContainerName:string;
        defaultNotifyConfig:string;
    }
}
