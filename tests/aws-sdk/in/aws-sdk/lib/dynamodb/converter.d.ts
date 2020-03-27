import DynamoDB = require('../../clients/dynamodb');

export class Converter {
    static input(
        data: any,
        options?: Converter.ConverterOptions
    ): DynamoDB.AttributeValue;

}

export namespace Converter {
    export type ConverterOptions = DynamoDB.DocumentClient.ConverterOptions;
}
