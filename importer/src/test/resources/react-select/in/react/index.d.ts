export = React;
export as namespace React;

declare namespace React {
    export class Component<P = {}, S = {}> {
        constructor(p: P)
    }
    interface Props<T> {
        key?: string;
    }

}
