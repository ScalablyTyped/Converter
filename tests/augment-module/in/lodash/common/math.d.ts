import _ = require("../index");
declare module "../index" {
    // add

    interface LoDashStatic {
        /**
         * Adds two numbers.
         *
         * @param augend The first number to add.
         * @param addend The second number to add.
         * @return Returns the sum.
         */
        add(
            augend: number,
            addend: number
        ): number;
    }
}