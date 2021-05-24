export class CSSResult {
    _styleSheet?: CSSStyleSheet | null;
    readonly cssText: string;
    constructor(cssText: string, safeToken: symbol)
}


export abstract class UpdatingElement extends HTMLElement {

}
export class LitElement extends UpdatingElement {
}
