import {LitElement} from "lit-element";

export declare abstract class BaseElement extends LitElement {
    /**
     * Root element for MDC Foundation usage.
     *
     * Define in your component with the `@query` decorator
     */
    protected abstract mdcRoot: HTMLElement;
}
