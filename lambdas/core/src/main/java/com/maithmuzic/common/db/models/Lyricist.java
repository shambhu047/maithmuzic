package com.maithmuzic.common.db.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Lyricists")
public class Lyricist extends Artist {
}
