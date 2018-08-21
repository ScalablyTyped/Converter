import { Component, ReactType, ReactElement } from "react";

declare namespace TransitionGroup {
    interface IntrinsicTransitionGroupProps<T extends keyof JSX.IntrinsicElements = "abbr"> {
        component?: T;
    }

    interface ComponentTransitionGroupProps<T extends ReactType>  {
        component: T;
    }

    type TransitionGroupProps<T extends keyof JSX.IntrinsicElements = "abbr", V extends ReactType = any> =
        (IntrinsicTransitionGroupProps<T> & JSX.IntrinsicElements[T]) | (ComponentTransitionGroupProps<V>) & {
        childFactory?(child: ReactElement<any>): ReactElement<any>;
    };
}

declare class TransitionGroup extends Component<TransitionGroup.TransitionGroupProps> {}

export = TransitionGroup;
