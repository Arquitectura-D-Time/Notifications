package com.architectured.notifications.config;

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("mongo",3004);
    }

    @Override
    protected String getDatabaseName() {
        return "notificationsEnseniamelaDB";
    }
}
