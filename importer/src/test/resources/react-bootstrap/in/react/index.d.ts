export = React;
export as namespace React;

declare namespace React {
    type ReactNode = string | number | boolean | null | undefined;
    type Key = string | number;

    interface Attributes {
        key?: Key;
    }

    type Ref<T> = string | { bivarianceHack(instance: T | null): any }["bivarianceHack"];

    interface ClassAttributes<T> extends Attributes {
        ref?: Ref<T>;
    }

    export class Component<P = {}, S = {}> {
        constructor(p: P)
    }
    interface Props<T> {
        key?: string;
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

    interface HTMLProps<T> extends AllHTMLAttributes<T>, ClassAttributes<T> {
        onChange: "foo"
        defaultValue: "foo"
        type: "foo"
        value: "foo"
    }
}
