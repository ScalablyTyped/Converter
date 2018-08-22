import * as AWS from '../clients/all';
export abstract class ConfigurationServicePlaceholders {
  dynamodb?: AWS.DynamoDB.Types.ClientConfiguration;
}
export interface ConfigurationServiceApiVersions {
  dynamodb?: AWS.DynamoDB.Types.apiVersion;
}
