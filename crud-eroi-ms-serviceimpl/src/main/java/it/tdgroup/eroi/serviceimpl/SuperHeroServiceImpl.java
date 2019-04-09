package it.tdgroup.eroi.serviceimpl;

import it.tdgroup.eroi.domain.hero.collection.SuperHero;
import it.tdgroup.eroi.domain.hero.embedded.SuperPower;
import it.tdgroup.eroi.dto.CreateSuperHeroDTO;
import it.tdgroup.eroi.dto.SuperHeroDTO;
import it.tdgroup.eroi.exception.EntityDosntExists;
import it.tdgroup.eroi.exception.MapperException;
import it.tdgroup.eroi.exception.ServiceException;
import it.tdgroup.eroi.exception.superhero.SuperHeroExists;
import it.tdgroup.eroi.mapperimpl.SuperHeroMapperImpl;
import it.tdgroup.eroi.repository.SuperHeroRepository;
import it.tdgroup.eroi.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * {@link it.tdgroup.eroi.domain.hero.collection.SuperHero} service
 *
 * @author sansajn
 */
@Service("superHeroService")
@Transactional
public class SuperHeroServiceImpl extends AbstractBaseService<SuperHero, SuperHeroDTO> implements SuperHeroService {

    private SuperHeroRepository superHeroRepository;

    private SuperHeroMapperImpl superHeroMapper;

    /**
     * Constructor
     *
     * @param superHeroRepository
     * @param superHeroMapper
     */
    @Autowired
    public SuperHeroServiceImpl(SuperHeroRepository superHeroRepository, SuperHeroMapperImpl superHeroMapper) {
        super(superHeroRepository, superHeroMapper);
        this.superHeroRepository = superHeroRepository;
        this.superHeroMapper = superHeroMapper;
    }

    /**
     * Create Entity
     *
     * @param createSuperHeroDTO
     *
     * @throws SuperHeroExists
     */
    @Override
    public void createSuperHero(CreateSuperHeroDTO createSuperHeroDTO) throws SuperHeroExists {
        // Didn't use mapper to entity each creation of entity could have some default values
        SuperHero superHero = new SuperHero();
        superHero.setName(createSuperHeroDTO.getName());
        superHero.setSurname(createSuperHeroDTO.getSurname());
        superHero.setSuperHeroName(createSuperHeroDTO.getSuperHeroName());
        superHero.setPowers(createSuperHeroDTO.getSuperPowers().stream().map(power -> {
            return new SuperPower(
                    power.getName(),
                    power.getDescription()
            );
        })
        .collect(Collectors.toList()));
        try {
            this.superHeroRepository.save(superHero);
        } catch (Exception ex) {
            throw new SuperHeroExists(ex);
        }
    }

    /**
     * Update SuperHero document.
     *
     * @param superHeroDTO
     * @param id
     * @throws ServiceException
     * @throws MapperException
     */
    public void updateSuperHero(SuperHeroDTO superHeroDTO, String id) throws ServiceException, MapperException {
        Optional<SuperHero> superHero = this.superHeroRepository.findOneById(id);
        if(!superHero.isPresent())
            throw new EntityDosntExists(null, id);

        SuperHero updatedObject = this.superHeroMapper.convertDtoToEntity(superHeroDTO);
        updatedObject.setId(id);

        try {
            this.superHeroRepository.save(updatedObject);
        } catch (Exception ex) {
            throw new SuperHeroExists(ex);
        }
    }

    /**
     * Get all SuperHero documents based on search criteria
     *
     * @param args
     * @return
     * @throws MapperException
     */
    public List<SuperHeroDTO> getAll(String ...args) throws MapperException {
        return this.superHeroMapper.convertEntityToDto(this.superHeroRepository.findAllByCriteria(args[0], args[1], args[2]));
    }

}
