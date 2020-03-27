// tslint:disable-next-line:export-just-namespace
export = React;
export as namespace React;

declare namespace React {
    type Ref<T> = string
    type RefObject<T> = any
    type ReactNode = any;

    interface ComponentType<P> {}
    interface ComponentClass<P> {}

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

    interface HTMLProps<T> extends AllHTMLAttributes<T> {
        onChange: "foo"
        defaultValue: "foo"
        type: "foo"
        value: "foo"
    }

    interface SVGAttributes<T> extends DOMAttributes<T> {
    }
}
