import {DynamoDBCustomizations} from '../lib/services/dynamodb';
import {DocumentClient as document_client} from '../lib/dynamodb/document_client';
import {Converter as converter} from '../lib/dynamodb/converter';


declare class DynamoDB extends DynamoDBCustomizations {
  constructor(options?: DynamoDB.Types.ClientConfiguration)

  }

declare namespace DynamoDB {
  export import DocumentClient = document_client;
  export import Converter = converter;
  export import Types = DynamoDB;
  export type ClientConfiguration = any
  export type AttributeValue = any;
  export type apiVersion = "latest";
}

export = DynamoDB;
