export = React;
export as namespace React;

declare namespace React {

    export class Component<P = {}, S = {}> {
        constructor(p: P)
    }
    interface Props<T> {
        key?: string;
    }


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
}
