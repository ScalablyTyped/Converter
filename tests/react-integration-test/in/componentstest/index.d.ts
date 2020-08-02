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

