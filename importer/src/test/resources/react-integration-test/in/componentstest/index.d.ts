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
