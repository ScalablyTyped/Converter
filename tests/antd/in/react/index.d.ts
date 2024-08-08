export = React;
export as namespace React;

declare namespace React {
    type ReactNode = string | number | boolean | null | undefined;

    interface RefObject<T> {
        readonly current: T | null;
    }

    // Bivariance hack for consistent unsoundness with RefObject
    type RefCallback<T> = { bivarianceHack(instance: T | null): void }["bivarianceHack"];
    type Ref<T> = RefCallback<T> | RefObject<T> | null;


    type Key = string | number;

    /**
     * @internal You shouldn't need to use this type since you never see these attributes
     * inside your component or have to validate them.
     */
    interface Attributes {
        key?: Key | null | undefined;
    }

    interface RefAttributes<T> extends Attributes {
        /**
         * Allows getting a ref to the component instance.
         * Once the component unmounts, React will set `ref.current` to `null` (or call the ref with `null` if you passed a callback ref).
         * @see https://react.dev/learn/referencing-values-with-refs#refs-and-the-dom
         */
        ref?: Ref<T> | undefined;
    }

    interface ExoticComponent<P = {}> {
        /**
         * **NOTE**: Exotic components are not callable.
         */
        (props: P): ReactNode;

        readonly $$typeof: symbol;
    }

    interface NamedExoticComponent<P = {}> extends ExoticComponent<P> {
        displayName?: string | undefined;
    }

    interface ForwardRefExoticComponent<P> extends NamedExoticComponent<P> {
        defaultProps?: Partial<P> | undefined;
        propTypes?: {} | undefined;
    }

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

    interface ButtonHTMLAttributes<T> extends HTMLAttributes<T> {
        disabled?: boolean | undefined;
        form?: string | undefined;
        formAction?:
            | string
            | undefined;
        formEncType?: string | undefined;
        formMethod?: string | undefined;
        formNoValidate?: boolean | undefined;
        formTarget?: string | undefined;
        name?: string | undefined;
        type?: 'submit' | 'reset' | 'button' | undefined;
        value?: string | Array<string> | number | undefined;
    }

    interface AnchorHTMLAttributes<T> extends HTMLAttributes<T> {
        download?: any;
        href?: string | undefined;
        hrefLang?: string | undefined;
        media?: string | undefined;
        ping?: string | undefined;
        target?: string | undefined;
        type?: string | undefined;
        referrerPolicy?: string | undefined;
    }
}
