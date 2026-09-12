import * as React from 'react';
import { FooProps } from './index';

export type TextFieldVariants = 'outlined' | 'filled' | 'standard';

export interface OutlinedTextFieldProps extends FooProps {
    variant: 'outlined';
}
export interface FilledTextFieldProps extends FooProps {
    variant: 'filled';
}
export interface StandardTextFieldProps extends FooProps {
    variant?: 'standard';
}

export type TextFieldProps<Variant extends TextFieldVariants = TextFieldVariants> = Variant extends 'filled'
    ? FilledTextFieldProps
    : Variant extends 'standard'
    ? StandardTextFieldProps
    : OutlinedTextFieldProps;

/* like MUI TextField: a generic function component as the default export of a submodule */
export default function TextField<Variant extends TextFieldVariants>(
    props: {
        variant?: Variant | undefined;
    } & Omit<TextFieldProps, 'variant'>,
): JSX.Element;
