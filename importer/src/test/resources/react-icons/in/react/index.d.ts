
/// <reference path="global.d.ts" />

// tslint:disable-next-line:export-just-namespace

export = React;
export as namespace React;

declare namespace React {
    interface Component<P = {}, S = {}> {
    }

    type Key = string | number;
    type ReactNode = string | number | boolean | null | undefined;

    interface ReactElement<P> {
        type: string | ComponentClass<P>;
        props: P;
        key: Key | null;
    }

    type ComponentState = {};

    interface ComponentClass<P = {}> {
        new(props: P, context?: any): Component<P, ComponentState>;

        defaultProps?: Partial<P>;
        displayName?: string;
    }

    interface Attributes {
        key?: Key;
    }

    interface ClassAttributes<T> extends Attributes {
        ref?: Ref<T>;
    }

    type Ref<T> = string | { bivarianceHack(instance: T | null): any }["bivarianceHack"];

    interface DOMAttributes<T> {
        children?: ReactNode;
        dangerouslySetInnerHTML?: {
            __html: string;
        };
    }

    interface HTMLAttributes<T> extends DOMAttributes<T> {
        defaultChecked?: boolean;
    }

    interface AllHTMLAttributes<T> extends HTMLAttributes<T> {
        accept?: string;
        acceptCharset?: string;
    }

    interface HTMLAttributes<T> extends DOMAttributes<T> {
        defaultChecked?: boolean;
    }

    interface SVGProps<T> extends ClassAttributes<T> {
    }

    interface SVGAttributes<T> extends DOMAttributes<T> {
        // Attributes which also defined in HTMLAttributes
        // See comment in SVGDOMPropertyConfig.js
        className?: string;
        color?: string;
        height?: number | string;
    }

    type DOMFactory<P extends DOMAttributes<T>, T extends Element> =
        (props?: ClassAttributes<T> & P | null, ...children: ReactNode[]) => DOMElement<P, T>;

    // string fallback for custom web-components
    interface DOMElement<P extends HTMLAttributes<T> | SVGAttributes<T>, T extends Element> extends ReactElement<P> {
        type: string;
        ref: Ref<T>;
    }
    interface SVGFactory extends DOMFactory<SVGAttributes<SVGElement>, SVGElement> {
        (props?: ClassAttributes<SVGElement> & SVGAttributes<SVGElement> | null, ...children: ReactNode[]): ReactSVGElement;
    }
    interface ReactSVG {
        animate: SVGFactory;
        circle: SVGFactory;
        clipPath: SVGFactory;
    }
    // ReactSVG for ReactSVGElement
    interface ReactSVGElement extends DOMElement<SVGAttributes<SVGElement>, SVGElement> {
        type: keyof ReactSVG;
    }
    type SFC<P = {}> = StatelessComponent<P>;
    type ComponentType<P = {}> = ComponentClass<P> | StatelessComponent<P>;

    interface StatelessComponent<P = {}> {
        (props: P & { children?: ReactNode }, context?: any): ReactElement<any> | null;

        defaultProps?: Partial<P>;
        displayName?: string;
    }


}
