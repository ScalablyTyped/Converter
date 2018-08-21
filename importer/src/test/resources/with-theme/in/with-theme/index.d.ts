/// <reference types="react" />

/**
 * `T extends ConsistentWith<T, U>` means that where `T` has overlapping properties with
 * `U`, their value types do not conflict.
 *
 * @internal
 */
export type ConsistentWith<T, U> = Pick<U, keyof T & keyof U>;

export interface WithTheme {
    theme: string;
    innerRef?: React.Ref<any> | React.RefObject<any>;
}

declare const withTheme: () => <P extends ConsistentWith<P, WithTheme>>(
    component: React.ComponentType<P & WithTheme>,
) => React.ComponentClass<P>;

export default withTheme;