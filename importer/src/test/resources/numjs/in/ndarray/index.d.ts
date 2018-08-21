declare function ndarray<T = number>(
    data: ndarray.Data<T>, shape?: number[], stride?: number[], offset?: number
): ndarray<T>;

interface ndarray<T = number> {
    data: ndarray.Data<T>;
    T: ndarray<T>;
}

declare namespace ndarray {
    type Data<T> = T[] ;
    type DataType = string;
}

export = ndarray;
