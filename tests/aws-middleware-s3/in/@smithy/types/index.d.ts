export interface ClientProtocol {
    serializeRequest(): Promise<any>;
}
