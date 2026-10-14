import type { ClientProtocol } from "@smithy/types";

export declare abstract class HttpProtocol implements ClientProtocol {
    abstract serializeRequest(): Promise<any>;
}
