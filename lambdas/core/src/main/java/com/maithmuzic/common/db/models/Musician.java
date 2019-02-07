package com.maithmuzic.common.db.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Musicians")
public class Musician extends Artist {
}
