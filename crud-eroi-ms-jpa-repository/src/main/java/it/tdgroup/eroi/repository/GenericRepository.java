package it.tdgroup.eroi.repository;

import it.tdgroup.eroi.domain.hero.AbstractEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GenericRepository<T extends AbstractEntity> extends MongoRepository<T, String> {

    Optional<T> findOneById(String id);
}
