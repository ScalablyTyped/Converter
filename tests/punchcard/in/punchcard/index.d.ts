interface Shape {}
interface TypeShape<A, B> {}

type ExtractTypes<F extends Fields> = Extract<F[keyof F], TypeShape<any, any>>

export declare type Fields = Readonly<{
    [member: string]: Shape;
}>;

export type Collect<F extends Fields> = {
    [fqn in ExtractTypes<F>['FQN']]: {
        type: Extract<ExtractTypes<F>, TypeShape<any, fqn>>;
        fields: Extract<ExtractTypes<F>, TypeShape<any, fqn>>['Members'];
        resolvers: {};
    };
};
