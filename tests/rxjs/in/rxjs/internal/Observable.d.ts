import {PartialObserver, Subscribable, Unsubscribable} from '../internal/types';
import {OperatorFunction} from "./types";
/**
 * A representation of any set of values over any amount of time. This is the most basic building block
 * of RxJS.
 *
 * @class Observable<T>
 */
export declare class Observable<T> implements Subscribable<T> {
    /** Internal implementation detail, do not use directly. */
    _isScalar: boolean;
    /** @deprecated This is an internal implementation detail, do not use. */
    source: Observable<any>;

    pipe(): Observable<T>;

    subscribe(observerOrNext?: PartialObserver<T> | ((value: T) => void), error?: (error: any) => void, complete?: () => void): Unsubscribable;


    foo: OperatorFunction<number, string>
}
