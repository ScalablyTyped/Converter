/**
 * <p>Represents the data for an attribute.</p>
 *          <p>Each attribute value is described as a name-value pair. The name is the data type, and
 *             the value is the data itself.</p>
 *          <p>For more information, see <a href="https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes">Data Types</a> in the <i>Amazon DynamoDB Developer
 *             Guide</i>.</p>
 * @public
 */
export type AttributeValue = AttributeValue.BMember | AttributeValue.BOOLMember | AttributeValue.BSMember | AttributeValue.LMember | AttributeValue.MMember | AttributeValue.NMember | AttributeValue.NSMember | AttributeValue.NULLMember | AttributeValue.SMember | AttributeValue.SSMember | AttributeValue.$UnknownMember;
/**
 * @public
 */
export declare namespace AttributeValue {
    /**
     * <p>An attribute of type String. For example:</p>
     *          <p>
     *             <code>"S": "Hello"</code>
     *          </p>
     * @public
     */
    interface SMember {
        S: string;
        N?: never;
        B?: never;
        SS?: never;
        NS?: never;
        BS?: never;
        M?: never;
        L?: never;
        NULL?: never;
        BOOL?: never;
        $unknown?: never;
    }
    /**
     * <p>An attribute of type Number. For example:</p>
     *          <p>
     *             <code>"N": "123.45"</code>
     *          </p>
     *          <p>Numbers are sent across the network to DynamoDB as strings, to maximize compatibility
     *             across languages and libraries. However, DynamoDB treats them as number type attributes
     *             for mathematical operations.</p>
     * @public
     */
    interface NMember {
        S?: never;
        N: string;
        B?: never;
        SS?: never;
        NS?: never;
        BS?: never;
        M?: never;
        L?: never;
        NULL?: never;
        BOOL?: never;
        $unknown?: never;
    }
    /**
     * <p>An attribute of type Binary. For example:</p>
     *          <p>
     *             <code>"B": "dGhpcyB0ZXh0IGlzIGJhc2U2NC1lbmNvZGVk"</code>
     *          </p>
     * @public
     */
    interface BMember {
        S?: never;
        N?: never;
        B: Uint8Array;
        SS?: never;
        NS?: never;
        BS?: never;
        M?: never;
        L?: never;
        NULL?: never;
        BOOL?: never;
        $unknown?: never;
    }
    /**
     * <p>An attribute of type String Set. For example:</p>
     *          <p>
     *             <code>"SS": ["Giraffe", "Hippo" ,"Zebra"]</code>
     *          </p>
     * @public
     */
    interface SSMember {
        S?: never;
        N?: never;
        B?: never;
        SS: string[];
        NS?: never;
        BS?: never;
        M?: never;
        L?: never;
        NULL?: never;
        BOOL?: never;
        $unknown?: never;
    }
    /**
     * <p>An attribute of type Number Set. For example:</p>
     *          <p>
     *             <code>"NS": ["42.2", "-19", "7.5", "3.14"]</code>
     *          </p>
     *          <p>Numbers are sent across the network to DynamoDB as strings, to maximize compatibility
     *             across languages and libraries. However, DynamoDB treats them as number type attributes
     *             for mathematical operations.</p>
     * @public
     */
    interface NSMember {
        S?: never;
        N?: never;
        B?: never;
        SS?: never;
        NS: string[];
        BS?: never;
        M?: never;
        L?: never;
        NULL?: never;
        BOOL?: never;
        $unknown?: never;
    }
    /**
     * <p>An attribute of type Binary Set. For example:</p>
     *          <p>
     *             <code>"BS": ["U3Vubnk=", "UmFpbnk=", "U25vd3k="]</code>
     *          </p>
     * @public
     */
    interface BSMember {
        S?: never;
        N?: never;
        B?: never;
        SS?: never;
        NS?: never;
        BS: Uint8Array[];
        M?: never;
        L?: never;
        NULL?: never;
        BOOL?: never;
        $unknown?: never;
    }
    /**
     * <p>An attribute of type Map. For example:</p>
     *          <p>
     *             <code>"M": \{"Name": \{"S": "Joe"\}, "Age": \{"N": "35"\}\}</code>
     *          </p>
     * @public
     */
    interface MMember {
        S?: never;
        N?: never;
        B?: never;
        SS?: never;
        NS?: never;
        BS?: never;
        M: Record<string, AttributeValue>;
        L?: never;
        NULL?: never;
        BOOL?: never;
        $unknown?: never;
    }
    /**
     * <p>An attribute of type List. For example:</p>
     *          <p>
     *             <code>"L": [ \{"S": "Cookies"\} , \{"S": "Coffee"\}, \{"N": "3.14159"\}]</code>
     *          </p>
     * @public
     */
    interface LMember {
        S?: never;
        N?: never;
        B?: never;
        SS?: never;
        NS?: never;
        BS?: never;
        M?: never;
        L: AttributeValue[];
        NULL?: never;
        BOOL?: never;
        $unknown?: never;
    }
    /**
     * <p>An attribute of type Null. For example:</p>
     *          <p>
     *             <code>"NULL": true</code>
     *          </p>
     * @public
     */
    interface NULLMember {
        S?: never;
        N?: never;
        B?: never;
        SS?: never;
        NS?: never;
        BS?: never;
        M?: never;
        L?: never;
        NULL: boolean;
        BOOL?: never;
        $unknown?: never;
    }
    /**
     * <p>An attribute of type Boolean. For example:</p>
     *          <p>
     *             <code>"BOOL": true</code>
     *          </p>
     * @public
     */
    interface BOOLMember {
        S?: never;
        N?: never;
        B?: never;
        SS?: never;
        NS?: never;
        BS?: never;
        M?: never;
        L?: never;
        NULL?: never;
        BOOL: boolean;
        $unknown?: never;
    }
    /**
     * @public
     */
    interface $UnknownMember {
        S?: never;
        N?: never;
        B?: never;
        SS?: never;
        NS?: never;
        BS?: never;
        M?: never;
        L?: never;
        NULL?: never;
        BOOL?: never;
        $unknown: [string, any];
    }
    interface Visitor<T> {
        S: (value: string) => T;
        N: (value: string) => T;
        B: (value: Uint8Array) => T;
        SS: (value: string[]) => T;
        NS: (value: string[]) => T;
        BS: (value: Uint8Array[]) => T;
        M: (value: Record<string, AttributeValue>) => T;
        L: (value: AttributeValue[]) => T;
        NULL: (value: boolean) => T;
        BOOL: (value: boolean) => T;
        _: (name: string, value: any) => T;
    }
    const visit: <T>(value: AttributeValue, visitor: Visitor<T>) => T;
}