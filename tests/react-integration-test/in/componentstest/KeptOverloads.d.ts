import * as React from 'react';
import { FooProps } from './index';

/* like @mui/material's `OverridableComponent` in some builds: the parameters erase differently, so `CombineOverloads`
 * keeps both overloads, and the props of the one with `component` have to be picked up from the kept overload */
export interface KeptOverloadsProps extends FooProps {
    kept?: boolean;
}

export interface KeptOverloadsComponent {
    <C extends React.ElementType>(props: { component: C } & FooProps): JSX.Element | null;
    (props: KeptOverloadsProps): JSX.Element | null;
}

export const KeptOverloads: KeptOverloadsComponent;
