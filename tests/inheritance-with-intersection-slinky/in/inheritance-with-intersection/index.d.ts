import * as React from "react";

export interface AProps {
  a?: string
}

export interface BProps {
  b?: string
}

export interface OverridableComponent {
  <C extends React.ElementType>(
    props: {
      /**
       * The component used for the root node.
       * Either a string to use a HTML element or a component.
       */
      component: C;
    }
  ): JSX.Element;
  (props: AProps): JSX.Element;
}

export type BaseProps<M extends OverridableTypeMap> =
  & M['props']
  & BProps


export interface OverridableTypeMap {
  props: {};
  defaultComponent: React.ElementType;
}

export type OverrideProps<
  M extends OverridableTypeMap,
  C extends React.ElementType
> = (
  & BaseProps<M>
  & AProps
);

export interface ExtendButtonBaseTypeMap<M extends OverridableTypeMap> {
  props: M['props'] ;
  defaultComponent: M['defaultComponent'];
}

export interface ButtonBaseTypeMap<P = {}, D extends React.ElementType = 'button'> {
  props: P & {
    centerRipple?: boolean;
  };
  defaultComponent: D;
}



export type ExtendBase<M extends OverridableTypeMap> = ((
  props: { href: string } & OverrideProps<ExtendButtonBaseTypeMap<M>, 'a'>
) => JSX.Element) &
  OverridableComponent;

export type ButtonTypeMap<
  P = {},
  D extends React.ElementType = 'button'
> = ExtendButtonBaseTypeMap<{
  props: P & {
    /**
     * If `true`, the button will be disabled.
     */
    disabled?: boolean;
}}>;


declare const Button: ExtendBase<ButtonTypeMap>;
