import * as React from 'react';

export const Component: React.ComponentType<Props>;

export type Props = A | B;
export interface A {
    aMember: number;
    aCallback: () => number;
}
export interface B {
    bMember: string;
    bCallback?: () => string
}

export interface CardGridProps {
    prefixCls?: string;
    style?: React.CSSProperties;
    className?: string;
    hoverable?: boolean;
}
export const Grid: React.FC<CardGridProps>;

export interface CardProps extends Omit<Pick<React.HTMLAttributes<HTMLDivElement>, "title" | "onClick">, 'title'> {
    prefixCls?: string;
}

interface CardInterface extends React.FC<CardProps> {
    Grid2: typeof Grid;
}
export const Card: CardInterface;


export const ObjectNames: React.FC<{
    ne?(other: object): boolean;
    equals?: boolean;
    finalize(other: object): boolean;
}>;


export const VeryExotic: React.MemoExoticComponent<React.ForwardRefExoticComponent<React.RefAttributes<HTMLDivElement>>>;

export interface Events {
    onClick: (event: React.SyntheticEvent<any>) => void;
}

/* https://github.com/ScalablyTyped/Converter/issues/767, same shape as @mui/material */
export interface OverridableTypeMap {
    props: {};
    defaultComponent: React.ElementType;
}

export interface CommonProps {
    className?: string;
    style?: React.CSSProperties;
}

export type BaseProps<M extends OverridableTypeMap> = M['props'] & CommonProps;

/* the props of the root element come from `ComponentPropsWithRef`, minus the ones the component declares itself */
export type DefaultComponentProps<M extends OverridableTypeMap> =
    BaseProps<M> & Omit<React.ComponentPropsWithRef<M['defaultComponent']>, keyof BaseProps<M>>;

export interface OverridableComponent<M extends OverridableTypeMap> {
    <C extends React.ElementType>(props: { component: C } & BaseProps<M>): JSX.Element | null;
    (props: DefaultComponentProps<M>): JSX.Element | null;
}

export interface ButtonBaseOwnProps {
    disableRipple?: boolean;
}

/* https://github.com/ScalablyTyped/Converter/issues/769, props behind nested indexed accesses */
export type ExtendButtonBaseTypeMap<M extends OverridableTypeMap> = {
    props: M['props'] & ButtonBaseOwnProps;
    defaultComponent: M['defaultComponent'];
};

export type ExtendButtonBase<M extends OverridableTypeMap> =
    ((props: { href: string } & DefaultComponentProps<ExtendButtonBaseTypeMap<M>>) => JSX.Element) &
    OverridableComponent<ExtendButtonBaseTypeMap<M>>;

export interface FooProps {
    label?: string;
    disabled?: boolean;
}

export interface FooTypeMap {
    props: FooProps;
    defaultComponent: 'a';
}

/* like MUI Box/TableRow */
export const Plain: OverridableComponent<FooTypeMap>;
/* like MUI Button/IconButton */
export const ViaAlias: ExtendButtonBase<FooTypeMap>;
/* the same type as `ViaAlias`, with the alias expanded by hand */
export const Inline: ((props: { href: string } & FooProps) => JSX.Element) & OverridableComponent<FooTypeMap>;

/* like MUI SwipeableDrawer */
export const ViaConstructor: React.JSXElementConstructor<FooProps>;
