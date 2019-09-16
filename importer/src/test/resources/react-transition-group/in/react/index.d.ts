
/// <reference path="global.d.ts" />

type NativeAnimationEvent = AnimationEvent;

// tslint:disable-next-line:export-just-namespace
export = React;
export as namespace React;

declare namespace React {
    interface Component<P = {}, S = {}> {
    }

    type ReactType<P = any> = string | ComponentType<P>;
    type ComponentType<P = {}> = ComponentClass<P> | StatelessComponent<P>;
    type Key = string | number;
    type ReactNode = string | number | boolean | null | undefined;
    type SFC<P = {}> = StatelessComponent<P>;

    interface StatelessComponent<P = {}> {
        (props: P & { children?: ReactNode }, context?: any): ReactElement<any> | null;

        defaultProps?: Partial<P>;
        displayName?: string;
    }

    interface ReactElement<P> {
        type: string | ComponentClass<P> | SFC<P>;
        props: P;
        key: Key | null;
    }

    type ComponentState = {};

    interface ComponentClass<P = {}> {
        new(props: P, context?: any): Component<P, ComponentState>;

        defaultProps?: Partial<P>;
        displayName?: string;
    }

    // interface SyntheticEvent<T> {
    //     currentTarget: EventTarget & T;
    // }

    // interface AnimationEvent<T> extends SyntheticEvent<T> {
    //     nativeEvent: NativeAnimationEvent;
    // }

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

    interface HTMLProps<T> extends AllHTMLAttributes<T>, ClassAttributes<T> {
    }

    interface SVGAttributes<T> extends DOMAttributes<T> {
    }

    type DetailedHTMLProps<E extends HTMLAttributes<T>, T> = ClassAttributes<T> & E;

    interface SVGProps<T> extends ClassAttributes<T> {
    }

}
declare global {
    namespace JSX {
        // tslint:disable-next-line:no-empty-interface
        interface Element extends React.ReactElement<any> { }
        interface ElementClass extends React.Component<any> {
            render(): React.ReactNode;
        }
        interface ElementAttributesProperty { props: {}; }
        interface ElementChildrenAttribute { children: {}; }

        // tslint:disable-next-line:no-empty-interface
        interface IntrinsicAttributes extends React.Attributes { }
        // tslint:disable-next-line:no-empty-interface
        interface IntrinsicClassAttributes<T> extends React.ClassAttributes<T> { }

        interface IntrinsicElements {
            // HTML
            abbr: React.DetailedHTMLProps<React.HTMLAttributes<HTMLElement>, HTMLElement>;
            animate: React.SVGProps<SVGElement>; // TODO: It is SVGAnimateElement but is not in TypeScript's lib.dom.d.ts for now.
        }
    }
}
