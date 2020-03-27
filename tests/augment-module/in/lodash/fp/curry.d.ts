// AUTO-GENERATED: do not modify this file directly.
// If you need to make changes, modify generate-fp.ts (if necessary), then open a terminal in types/lodash/scripts, and do:
// npm run fp

import _ = require("../index");

interface Curry {
    <T1, R>(func: (t1: T1) => R): _.CurriedFunction1<T1, R>;
    <T1, T2, R>(func: (t1: T1, t2: T2) => R): _.CurriedFunction2<T1, T2, R>;
}

declare const curry: Curry;
export = curry;
