package it.tdgroup.eroi.service;

import it.tdgroup.eroi.domain.hero.AbstractEntity;
import it.tdgroup.eroi.exception.EntityDosntExists;
import it.tdgroup.eroi.exception.MapperException;
import it.tdgroup.eroi.exception.ServiceException;

import java.util.List;

/**
 *
 * @param <T>
 */
public interface BaseService<T> {

    /**
     * Fetch all objects from database.
     *
     * @return List<T>
     */
    List<T> getAll() throws MapperException;

    /**
     * Fetch documents from database with offset and limit
     *
     * @param offset
     * @param limit
     *
     * @return List<T>
     */
    List<T> getAll(int offset, int limit) throws MapperException, ServiceException;

    /**
     * Fetch document by attribute id.
     *
     * @param id
     *
     * @return T
     */
    T getOne(String id) throws MapperException, ServiceException;

    /**
     * Delete document from database
     *
     * @param id
     * @throws ServiceException
     */
    void delete(String id) throws ServiceException;

}
