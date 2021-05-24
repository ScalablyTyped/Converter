import {BaseElement} from "mwc-base";

export interface RippleInterface {
    startPress: (e?: Event) => void;
    endPress: () => void;
    startFocus: () => void;
    endFocus: () => void;
    startHover: () => void;
    endHover: () => void;
}

export declare class RippleBase extends BaseElement implements RippleInterface {
    mdcRoot: HTMLElement;
    primary: boolean;
    accent: boolean;
    unbounded: boolean;
    disabled: boolean;
    activated: boolean;
    selected: boolean;
    protected hovering: boolean;
    protected bgFocused: boolean;
    protected fgActivation: boolean;
    protected fgDeactivation: boolean;
    protected fgScale: string;
    protected fgSize: string;
    protected translateStart: string;
    protected translateEnd: string;
    protected leftPos: string;
    protected topPos: string;

    get isActive(): boolean;

    startPress(ev?: Event): void;
}
