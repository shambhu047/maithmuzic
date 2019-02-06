package com.maithmuzic.common.db;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

import java.util.List;

public class DAO {
    private static DAO instance;

    public final DynamoDBMapper mapper;

    public static DAO getInstance() {
        if (DAO.instance != null) {
            return instance;
        }

        return DAO.instance = new DAO(null, null);
    }

    private DAO(AmazonDynamoDB db, DynamoDBMapperConfig config) {
        mapper = new DynamoDBMapper(db, config);
    }
}
