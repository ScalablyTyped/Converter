declare interface Promise<T> {}
interface PromiseLike<T> {}
interface Array<T> {}
type Record<K extends keyof any, T> = { [P in K]: T };

interface RegExp {}
interface Error {}
interface ReadonlyArray<T> {}
interface TemplateStringsArray extends ReadonlyArray<string> {
  readonly raw: readonly string[];
}
