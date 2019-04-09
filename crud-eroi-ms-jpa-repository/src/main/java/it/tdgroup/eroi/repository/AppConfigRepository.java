package it.tdgroup.eroi.repository;

import it.tdgroup.eroi.domain.AppConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppConfigRepository extends MongoRepository<AppConfig, String> {

    @Query("{'nome':?0}")
    AppConfig findAppConfig(String nomeConfig);

    @Query("{'nome':?0}")
    void deleteConfig(String nomeConfig);
}

