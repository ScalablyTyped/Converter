import * as React from 'react';

export default class ReactSelectClass<TValue = OptionValues> extends React.Component<ReactSelectProps<TValue>> {
    focus(): void;
    setValue(value: Option<TValue>): void;
}

export interface Option<TValue = OptionValues> {
    /** Value for searching */
    value?: TValue;
    /**
     * In the event that a custom menuRenderer is provided, Option should be able
     * to accept arbitrary key-value pairs. See react-virtualized-select.
     */
    [property: string]: any;
}

export type OptionValues = string | number | boolean;

export interface ReactSelectProps<TValue = OptionValues> extends React.Props<ReactSelectClass<TValue>> {
    /**
     * text to display when `allowCreate` is true.
     * @default 'Add "{label}"?'
     */
    addLabelText?: string;
}

