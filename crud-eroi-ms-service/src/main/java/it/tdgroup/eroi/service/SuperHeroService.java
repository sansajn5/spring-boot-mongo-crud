package it.tdgroup.eroi.service;

import it.tdgroup.eroi.dto.CreateSuperHeroDTO;
import it.tdgroup.eroi.dto.SuperHeroDTO;
import it.tdgroup.eroi.exception.MapperException;
import it.tdgroup.eroi.exception.ServiceException;

import java.util.List;

/**
 * {@link it.tdgroup.eroi.domain.hero.collection.SuperHero} service interface
 *
 * @author sansajn
 */
public interface SuperHeroService extends BaseService<SuperHeroDTO> {

    /**
     * Create super hero.
     *
     * @param createSuperHeroDTO
     */
     void createSuperHero(CreateSuperHeroDTO createSuperHeroDTO) throws ServiceException;

    /**
     * Update super hero.
     *
     * @param superHeroDTO
     * @throws ServiceException
     * @throws MapperException
     */
     void updateSuperHero(SuperHeroDTO superHeroDTO, String id) throws ServiceException, MapperException;

    /**
     * Get all document based on search criteria
     * @param args
     * @return
     * @throws MapperException
     */
     List<SuperHeroDTO> getAll(String ...args) throws MapperException;

}
