import _ = require("../index");
// tslint:disable-next-line:strict-export-declare-modifiers
type GlobalPartial<T> = Partial<T>;

declare module "../index" {
    type PartialObject<T> = GlobalPartial<T>;
    type Many<T> = T | T[];
    interface LoDashStatic {
    }

    type List<T> = ArrayLike<T>;
    type PropertyName = string | number | symbol;
    type PropertyPath = Many<PropertyName>;

}