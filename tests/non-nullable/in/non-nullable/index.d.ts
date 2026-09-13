export interface RootSlotProps {
    className?: string;
}

export interface BadgeSlotProps {
    max?: number;
}

export interface BadgeOwnProps {
    slotProps?: {
        root?: RootSlotProps;
        badge?: BadgeSlotProps;
    };
}

/* like @mui/material, the props are an intersection, `{} & BadgeOwnProps` by default */
export interface BadgeTypeMap<AdditionalProps = {}> {
    props: AdditionalProps & BadgeOwnProps;
}

/* like @mui/material's `BadgeRootProps`, a lookup through `NonNullable` */
export type BadgeRootProps = NonNullable<BadgeTypeMap['props']['slotProps']>['root'];
export type BadgeBadgeProps = NonNullable<BadgeTypeMap['props']['slotProps']>['badge'];

export declare function root(props: BadgeRootProps): void;
export declare function badge(props: BadgeBadgeProps): void;

/* `NonNullable` of a union is the union without `null` and `undefined` */
export declare const name: NonNullable<string | null | undefined>;

/* of anything else it stays */
export declare const other: NonNullable<RootSlotProps>;
