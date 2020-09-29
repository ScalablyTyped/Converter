export = React;
export as namespace React;

declare namespace React {
    interface ReactElement {}
    interface ElementType {}

    type ReactNode = string | number | boolean | null | undefined;

    interface DOMAttributes<T> {
            children?: ReactNode;
            onClick?: number | ((x: string) => void);
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

declare global {
    namespace JSX {
        interface Element extends React.ReactElement<any, any> { }
    }
}