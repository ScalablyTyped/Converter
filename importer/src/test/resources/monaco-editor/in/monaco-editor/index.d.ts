
declare namespace monaco {

    export type Thenable<T> = PromiseLike<T>;

    export class Promise<T = any, TProgress = any> {
        constructor(
            executor: (
                resolve: (value: T | PromiseLike<T>) => void,
                reject: (reason: any) => void,
                progress: (progress: TProgress) => void) => void,
            oncancel?: () => void);
        public static any<T>(promises: (T | PromiseLike<T>)[]): Promise<{ key: string; value: Promise<T>; }>;
}

}