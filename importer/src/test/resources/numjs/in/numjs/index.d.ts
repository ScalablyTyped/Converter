export as namespace nj;
import * as BaseNdArray from 'ndarray';

export type NdType<T> = BaseNdArray.DataType | BaseNdArray.Data<T>;

export interface NdArray<T = number> extends BaseNdArray<T> {
    ndim: number;
    T: NdArray<T>;

    slice(...args: number[]): NdArray<T>;
}