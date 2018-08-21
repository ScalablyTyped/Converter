import DynamoDB = require('../../clients/dynamodb');

/**
 * The document client simplifies working with items in Amazon DynamoDB
 * by abstracting away the notion of attribute values. This abstraction
 * annotates native JavaScript types supplied as input parameters, as well
 * as converts annotated response data to native JavaScript types.
 */
export class DocumentClient {
    /**
     * Creates a DynamoDB document client with a set of configuration options.
     */
    constructor(options?: DocumentClient.DocumentClientOptions & DynamoDB.Types.ClientConfiguration)
}

export namespace DocumentClient {
    interface ConverterOptions {
        /**
         * An optional flag indicating that the document client should cast
         * empty strings, buffers, and sets to NULL shapes
         */
        convertEmptyValues?: boolean;

        /**
         * Whether to return numbers as a NumberValue object instead of
         * converting them to native JavaScript numbers. This allows for the
         * safe round-trip transport of numbers of arbitrary size.
         */
        wrapNumbers?: boolean;
    }

    export interface DocumentClientOptions extends ConverterOptions {
        /**
         * An optional map of parameters to bind to every request sent by this service object.
         */
        params?: {[key: string]: any}
        /**
         * An optional pre-configured instance of the AWS.DynamoDB service object to use for requests. The object may bound parameters used by the document client.
         */
        service?: DynamoDB
    }

}

export namespace DocumentClient {
  //<!--auto-generated start-->
  export type AttributeAction = "ADD"|"PUT"|"DELETE"|string;
  //<!--auto-generated end-->
}
