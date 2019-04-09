package it.tdgroup.eroi.repository;

import it.tdgroup.eroi.domain.hero.collection.SuperHero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO layer for {@link SuperHero}
 *
 * @author sansajn
 */
@Repository
public interface SuperHeroRepository extends GenericRepository<SuperHero> {

    @Query("{'name': {$regex: ?0}, 'superHeroName': {$regex: ?1}, 'powers.name': {$regex: ?2}}")
    List<SuperHero> findAllByCriteria(String name, String superHero, String power);
}
