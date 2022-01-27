declare const prisma: unique symbol;
export type PrismaPromise<A> = Promise<A> & { [prisma]: true };
export class Prisma__ColumnClient<T> implements PrismaPromise<T> {
  [prisma]: true;
  readonly [Symbol.toStringTag]: "PrismaClientPromise";

  then<TResult1 = T, TResult2 = never>(
    onfulfilled?:
      | ((value: T) => TResult1 | PromiseLike<TResult1>)
      | undefined
      | null,
    onrejected?:
      | ((reason: any) => TResult2 | PromiseLike<TResult2>)
      | undefined
      | null
  ): Promise<TResult1 | TResult2>;

  catch<TResult = never>(
    onrejected?:
      | ((reason: any) => TResult | PromiseLike<TResult>)
      | undefined
      | null
  ): Promise<T | TResult>;

  finally(onfinally?: (() => void) | undefined | null): Promise<T>;
}
