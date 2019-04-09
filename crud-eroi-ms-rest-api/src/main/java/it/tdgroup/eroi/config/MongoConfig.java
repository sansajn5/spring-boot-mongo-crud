package it.tdgroup.eroi.config;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.jongo.Jongo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author p.b
 */

/**
 * Abilitare per la gestione jongo
 */

//@Configuration
//@EnableMongoRepositories(basePackages = "it.tdgroup.eroi.repository")
public class MongoConfig {

    /**
     * Log applicativo.
     */
    private static final Log LOG = LogFactory.getLog(MongoConfig.class);

  
   /*
    @Value("${mongo.database}")
    private String MONGO_DATABASE;

    @Value("${mongo.user}")
    private String MONGO_USER;

    @Value("${mongo.pwd}")
    private String MONGO_PWD;

    @Value("${mongo.host}")
    private String MONGO_HOST;

    @Value("${mongo.port}")
    private String MONGO_PORT;

    @Bean
    public Jongo jongo() throws Exception {
        MongoClient mongo = new MongoClient(
                new MongoClientURI("mongodb://" + MONGO_USER + ":" + MONGO_PWD + "@" + MONGO_HOST + "/" + MONGO_DATABASE)
        );

        DB db = mongo.getDB(MONGO_DATABASE);
        return new Jongo(db);
    }
   */
}

