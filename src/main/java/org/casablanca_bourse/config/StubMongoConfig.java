package org.casablanca_bourse.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Minimal stub so anything @Autowired(name="mongoTemplate") can be created.
 * Uses a 1ms server selection timeout so if someone accidentally calls it,
 * it fails fast instead of hanging.
 */
@Configuration
public class StubMongoConfig {

  @Bean(name = "mongoTemplate")
  public MongoTemplate mongoTemplate() {
    MongoClientURI uri = new MongoClientURI(
        "mongodb://127.0.0.1:27017/?serverSelectionTimeoutMS=1&connectTimeoutMS=1&socketTimeoutMS=1");
    MongoClient client = new MongoClient(uri);
    return new MongoTemplate(client, "stubdb");
  }
}
