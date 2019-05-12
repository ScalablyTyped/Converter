//
// NOTE TO MAINTAINERS AND CONTRIBUTORS : pay attention to only include symbols that are
// publicly exported in the minified version of ko, without that you can give the false
// impression that some functions will be available in production builds.
//
interface KnockoutUtils {
    //////////////////////////////////
    // utils.domData.js
    //////////////////////////////////

    domData: {
        get (node: Element, key: string): any;

        set (node: Element, key: string, value: any): void;

        getAll(node: Element, createIfNotFound: boolean): any;

        clear(node: Element): boolean;
    };

    //////////////////////////////////
    // utils.domNodeDisposal.js
    //////////////////////////////////

    domNodeDisposal: {
        addDisposeCallback(node: Element, callback: Function): void;

        removeDisposeCallback(node: Element, callback: Function): void;

        cleanNode(node: Node): Element;

        removeNode(node: Node): void;
    };

    addOrRemoveItem<T>(array: T[] | KnockoutObservable<T>, value: T, included: T): void;

    arrayFilter<T>(array: T[], predicate: (item: T) => boolean): T[];

    arrayFirst<T>(array: T[], predicate: (item: T) => boolean, predicateOwner?: any): T;

    arrayForEach<T>(array: T[], action: (item: T, index: number) => void): void;

    arrayGetDistinctValues<T>(array: T[]): T[];

    arrayIndexOf<T>(array: T[], item: T): number;

    arrayMap<T, U>(array: T[], mapping: (item: T) => U): U[];

    arrayPushAll<T>(array: T[] | KnockoutObservableArray<T>, valuesToPush: T[]): T[];

    arrayRemoveItem(array: any[], itemToRemove: any): void;

    compareArrays<T>(a: T[], b: T[]): Array<KnockoutArrayChange<T>>;

    extend(target: Object, source: Object): Object;

    fieldsIncludedWithJsonPost: any[];

    getFormFields(form: any, fieldName: string): any[];

    objectForEach(obj: any, action: (key: any, value: any) => void): void;

    parseHtmlFragment(html: string): any[];

    parseJson(jsonString: string): any;

    postJson(urlOrForm: any, data: any, options: any): void;

    peekObservable<T>(value: KnockoutObservable<T>): T;

    range(min: any, max: any): any;

    registerEventHandler(element: any, eventType: any, handler: Function): void;

    setHtml(node: Element, html: () => string): void;

    setHtml(node: Element, html: string): void;

    setTextContent(element: any, textContent: string | KnockoutObservable<string>): void;

    stringifyJson(data: any, replacer?: Function, space?: string): string;

    toggleDomNodeCssClass(node: any, className: string, shouldHaveClass: boolean): void;

    triggerEvent(element: any, eventType: any): void;

    unwrapObservable<T>(value: KnockoutObservable<T> | T): T;

    // NOT PART OF THE MINIFIED API SURFACE (ONLY IN knockout-{version}.debug.js) https://github.com/SteveSanderson/knockout/issues/670
    // forceRefresh(node: any): void;
    // ieVersion: number;
    // isIe6: boolean;
    // isIe7: boolean;
    // jQueryHtmlParse(html: string): any[];
    // makeArray(arrayLikeObject: any): any[];
    // moveCleanedNodesToContainerElement(nodes: any[]): HTMLElement;
    // replaceDomNodes(nodeToReplaceOrNodeArray: any, newNodesArray: any[]): void;
    // setDomNodeChildren(domNode: any, childNodes: any[]): void;
    // setElementName(element: any, name: string): void;
    // setOptionNodeSelectionState(optionNode: any, isSelected: boolean): void;
    // simpleHtmlParse(html: string): any[];
    // stringStartsWith(str: string, startsWith: string): boolean;
    // stringTokenize(str: string, delimiter: string): string[];
    // stringTrim(str: string): string;
    // tagNameLower(element: any): string;
}