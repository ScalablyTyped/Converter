
declare module 'fullcalendar/Mixin' {
    export class Default {
        static mixInto(destClass: any): void;
        static mixOver(destClass: any): void;
    }
    export default Default;
}
declare module 'fullcalendar/EmitterMixin' {
    import Mixin from 'fullcalendar/Mixin';
    export interface EmitterInterface {
        on(types: any, handler: any): any;
    }
    export class Default extends Mixin implements EmitterInterface {
        on(types: any, handler: any): this;
    }
    export default Default;
}
declare module 'fullcalendar/EventPeriod' {
	import { EmitterInterface } from 'fullcalendar/EmitterMixin';
	export class Default {
	    on: EmitterInterface['on'];
	    requestsByUid: any;
	    pendingCnt: number;
	    freezeDepth: number;
	    eventInstanceGroupsById: any;
	    constructor(start: any, end: any, timezone: any);
	    isWithinRange(start: any, end: any): boolean;
	    thaw(): void;
	}
	export default Default;
}