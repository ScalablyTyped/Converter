import { AwsRestXmlProtocol } from "@aws-sdk/core/protocols";

export declare class S3RestXmlProtocol extends AwsRestXmlProtocol {
    serializeRequest(): Promise<any>;
}
