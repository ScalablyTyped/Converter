import {Ripple} from "mwc-ripple";
import {LitElement} from "lit-element";

export declare class ButtonBase extends LitElement {
    raised: boolean;
    unelevated: boolean;
    outlined: boolean;
    dense: boolean;
    disabled: boolean;
    trailingIcon: boolean;
    fullwidth: boolean;
    icon: string;
    label: string;
    expandContent: boolean;
    buttonElement: HTMLElement;
    ripple: Promise<Ripple | null>;
    protected handleRippleActivate(evt?: Event): void;
    protected handleRippleDeactivate(): void;
    protected handleRippleMouseEnter(): void;
    protected handleRippleMouseLeave(): void;
    protected handleRippleFocus(): void;
    protected handleRippleBlur(): void;
}

export declare class Button extends ButtonBase {
    static styles: import("lit-element").CSSResult;
}

declare global {
    interface HTMLElementTagNameMap {
        'mwc-button': Button;
    }
}
