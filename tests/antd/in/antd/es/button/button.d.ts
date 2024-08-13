import React from 'react';
export interface BaseButtonProps {
    type?: string;
    icon?: React.ReactNode;
    shape?: string;
    size?: number;
    disabled?: boolean;
    loading?: boolean | {
        delay?: number;
    };
    prefixCls?: string;
    className?: string;
    rootClassName?: string;
    ghost?: boolean;
    danger?: boolean;
    block?: boolean;
    children?: React.ReactNode;
    [key: `data-${string}`]: string;
    classNames?: {
        icon: string;
    };
    styles?: {
        icon: any;
    };
}
type MergedHTMLAttributes = Omit<React.HTMLAttributes<HTMLElement> & React.ButtonHTMLAttributes<HTMLElement> & React.AnchorHTMLAttributes<HTMLElement>, 'type'>;
export interface ButtonProps extends BaseButtonProps, MergedHTMLAttributes {
    href?: string;
    htmlType?: string;
}
type CompoundedComponent = React.ForwardRefExoticComponent<ButtonProps & React.RefAttributes<HTMLElement>>;
declare const Button: CompoundedComponent;
export default Button;
