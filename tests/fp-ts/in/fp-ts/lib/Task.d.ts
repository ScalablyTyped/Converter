import { Either } from './Either';

/** @function */
export declare const tryCatch: <L, A>(f: any, onrejected: (reason: {}) => L) => Either<L, A>;
