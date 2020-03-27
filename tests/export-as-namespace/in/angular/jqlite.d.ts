
interface JQLite extends JQuery {
    [index: number]: HTMLElement;
}

interface JQuery {
    /**
     * Adds the specified class(es) to each of the set of matched elements.
     *
     * @param className One or more space-separated classes to be added to the class attribute of each matched element.
     * @see {@link https://api.jquery.com/addClass/#addClass-className}
     */
    addClass(className: string): this;
    injector(): ng.auto.IInjectorService;
}

interface JQueryStatic {
    (element: string | Element | Document | JQuery | ArrayLike<Element> | (() => void)): JQLite;
}
