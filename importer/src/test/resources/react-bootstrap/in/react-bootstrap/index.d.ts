// Type definitions for react-bootstrap 0.32
// Project: https://github.com/react-bootstrap/react-bootstrap
// Definitions by: Walker Burgin <https://github.com/walkerburgin>,
//                 Vincent Siao <https://github.com/vsiao>,
//                 Danilo Barros <https://github.com/danilojrr>,
//                 Batbold Gansukh <https://github.com/Batbold-Gansukh>,
//                 Raymond May Jr. <https://github.com/octatone>,
//                 Cheng Sieu Ly <https://github.com/chengsieuly>,
//                 Mercedes Retolaza <https://github.com/mretolaza>,
//                 Kat Busch <https://github.com/katbusch>,
//                 Vito Samson <https://github.com/vitosamson>,
//                 Karol Janyst <https://github.com/LKay>
//                 Aaron Beall <https://github.com/aaronbeall>
//                 Johann Rakotoharisoa <https://github.com/jrakotoharisoa>
//                 Andrew Makarov <https://github.com/r3nya>
//                 Duong Tran <https://github.com/t49tran>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped
// TypeScript Version: 2.8

export type Omit<T, K extends keyof T> = Pick<T, ({ [P in keyof T]: P } & { [P in K]: never } & { [x: string]: never, [x: number]: never })[keyof T]>;

export type Sizes = 'xs' | 'xsmall' | 'sm' | 'small' | 'medium' | 'lg' | 'large';

export * from './lib';
