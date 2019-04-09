package it.tdgroup.eroi.service;

import it.tdgroup.eroi.dto.UserDTO;
import it.tdgroup.eroi.exception.MapperException;
import it.tdgroup.eroi.exception.ServiceException;

public interface UserService {

    String create(UserDTO userDTO) throws ServiceException;

    UserDTO read(String id) throws ServiceException, MapperException;

    void update(String id, UserDTO userDTO) throws ServiceException;

    void delete(String id) throws ServiceException;

}

