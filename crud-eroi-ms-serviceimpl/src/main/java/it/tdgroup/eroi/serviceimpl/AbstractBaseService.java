package it.tdgroup.eroi.serviceimpl;

import it.tdgroup.eroi.domain.hero.AbstractEntity;
import it.tdgroup.eroi.exception.EntityDosntExists;
import it.tdgroup.eroi.exception.MapperException;
import it.tdgroup.eroi.exception.ServiceException;
import it.tdgroup.eroi.mapper.MapperComponent;
import it.tdgroup.eroi.service.BaseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import it.tdgroup.eroi.repository.GenericRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

/**
 * Generic implementation of {@link it.tdgroup.eroi.serviceimpl.BaseService
 * }
 * @param <T> Database document
 * @param <E> DTO object
 *
 * @author sansajn
 */
@Transactional
public abstract class AbstractBaseService<T extends AbstractEntity, E> implements BaseService<E> {

    private final GenericRepository repository;

    private final MapperComponent mapperComponent;

    private static final Log LOG = LogFactory.getLog(AbstractBaseService.class);

    @Autowired
    public AbstractBaseService(GenericRepository repository, MapperComponent mapperComponent) {
        this.repository = repository;
        this.mapperComponent = mapperComponent;
    }

    /**
     * Implementation of getAll {@link it.tdgroup.eroi.serviceimpl.BaseService}
     *
     * @return
     * @throws MapperException
     */
    @Override
    public List<E> getAll() throws MapperException {
            return this.mapperComponent.convertEntityToDto(this.repository.findAll());
    }

    /**
     *
     * @param offset
     * @param limit
     *
     * @return List<E>
     *
     * @throws ServiceException
     * @throws MapperException
     */
    @Override
    public List<E> getAll(int offset, int limit) throws ServiceException, MapperException {
        // TODO -> not required for test
        return null;
    }

    /**
     * Implementation of getOne {@link it.tdgroup.eroi.serviceimpl.BaseService}
     *
     * @param id
     *
     * @return E
     *
     * @throws EntityDosntExists
     * @throws MapperException
     */
    @Override
    public E getOne(String id) throws EntityDosntExists, MapperException {
        Optional<T> entity = this.repository.findOneById(id);
        if(!entity.isPresent())
            throw new EntityDosntExists(null, id);

        return (E) this.mapperComponent.convertEntityToDto(this.repository.findOneById(id).get());
    }

    /**
     * Implementation of delete {@link it.tdgroup.eroi.serviceimpl.BaseService}
     *
     * @param id
     *
     * @throws EntityDosntExists
     */
    @Override
    public void delete(String id) throws EntityDosntExists {
        Optional<T> entity = this.repository.findOneById(id);
        if(!entity.isPresent())
            throw new EntityDosntExists(null, id);

        this.repository.delete(entity.get());
    }
}
