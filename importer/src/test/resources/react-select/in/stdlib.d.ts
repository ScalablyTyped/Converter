/// <reference no-default-lib="true"/>

type Partial<T> = {
    [P in keyof T]?: T[P];
};
