import curry = require("./fp/curry");

export = _;

declare const _: _.LoDashFp;
declare namespace _ {
    interface LoDashFp {
         curry: typeof curry;
    }
}

// Backward compatibility with --target es5
declare global {
    // tslint:disable-next-line:no-empty-interface
    interface Set<T> { }
    // tslint:disable-next-line:no-empty-interface
    interface Map<K, V> { }
    // tslint:disable-next-line:no-empty-interface
    interface WeakSet<T> { }
    // tslint:disable-next-line:no-empty-interface
    interface WeakMap<K extends object, V> { }
}
