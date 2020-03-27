
// tslint:disable-next-line:export-just-namespace
export = React;
export as namespace React;

declare namespace React {
    interface Component<P = {}, S = {}> {}

    type ComponentState = {};
    type ReactNode = string | number | boolean | null | undefined;
    type SFC<P = {}> = StatelessComponent<P>;
    type Key = string | number;
    type ComponentType<P = {}> = ComponentClass<P> | StatelessComponent<P>;

    interface ReactElement<P> {
        type: string | ComponentClass<P> | SFC<P>;
        props: P;
        key: Key | null;
    }

    interface StatelessComponent<P = {}> {
        (props: P & { children?: ReactNode }, context?: any): ReactElement<any> | null;

        defaultProps?: Partial<P>;
        displayName?: string;
    }
    interface ComponentClass<P = {}> {
        new(props: P, context?: any): Component<P, ComponentState>;

        defaultProps?: Partial<P>;
        displayName?: string;
    }

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

    interface HTMLProps<T> extends AllHTMLAttributes<T>{
        onChange: "foo"
        defaultValue: "foo"
        type: "foo"
        value: "foo"
    }

    interface SVGAttributes<T> extends DOMAttributes<T> {
    }

}
