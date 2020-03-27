// Type definitions for p2.js v0.6.0
// Project: https://github.com/schteppe/p2.js/

declare module p2 {

    export class AABB {

        constructor(options?: {
            upperBound?: number[];
            lowerBound?: number[];
        });

        copy(aabb: AABB): void;

    }
}

