// Type definitions for BigInt v5.5.3
// Project: https://github.com/Evgenus/BigInt
// Definitions by: Eugene Chernyshov <https://github.com/Evgenus>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped

// Development repository: https://github.com/Evgenus/bigint-typescript-definitions
// For answers, fixes and cutting edge version please see development repository.

declare namespace BigInt {
    export interface BigInt extends Array<number> {
    }

    export interface IRandom {
        (): number;
    }

    /**
     * Sets a random number generator.
     *
     * @param {IRandom} random function that returns random number.
     */
    export function setRandom(random: IRandom): void;

    /**
     * return (x+y) for bigInts x and y.
     *
     * @param {BigInt} x The BigInt augend.
     * @param {BigInt} y The BigInt addend.
     *
     * @return {BigInt} A sum as BigInt.
     */
    export function add(x: BigInt, y: BigInt): BigInt;

}
