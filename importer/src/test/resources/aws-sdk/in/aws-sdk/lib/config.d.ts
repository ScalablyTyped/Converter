
import {ConfigurationServicePlaceholders, ConfigurationServiceApiVersions} from './config_service_placeholders';

export class Config  {
    /**
     * Creates a new configuration object.
     * This is the object that passes option data along to service requests, including credentials, security, region information, and some service specific settings.
     */
    constructor(options?: ConfigurationServicePlaceholders & APIVersions);
    /**
     * Loads configuration data from a JSON file into this config object.
     * Loading configuration willr eset all existing configuration on the object.
     * This feature is not supported in the browser environment of the SDK.
     *
     * @param {string} path - the path relative to your process's current working directory to load configuration from.
     */
    loadFromPath(path: string): Config & ConfigurationServicePlaceholders & APIVersions;
}

export interface APIVersions {
    /**
     * A string in YYYY-MM-DD format that represents the latest possible API version that can be used in all services (unless overridden by apiVersions). Specify \'latest\' to use the latest possible version.
     */
    apiVersion?: "latest"|string;
    /**
     * A map of service identifiers (the lowercase service class name) with the API version to use when instantiating a service. Specify 'latest' for each individual that can use the latest available version.
     */
    apiVersions?: ConfigurationServiceApiVersions;
}
