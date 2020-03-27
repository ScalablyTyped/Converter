import { Either, URI } from './Either';
import { HKT } from './HKT';

interface Foo<T, U> {}
export interface EitherT<F> extends Foo<F, URI> {
    readonly chain: <L, A, B>(f: (a: A) => HKT<F, Either<L, B>>, fa: HKT<F, Either<L, A>>) => HKT<F, Either<L, B>>;
}
