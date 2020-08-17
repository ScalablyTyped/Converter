export interface TransportRequestPromise<T> extends Promise<T> {
  abort: () => void;
}