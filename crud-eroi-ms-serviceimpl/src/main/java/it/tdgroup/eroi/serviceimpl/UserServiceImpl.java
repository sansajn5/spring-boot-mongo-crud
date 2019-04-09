package it.tdgroup.eroi.serviceimpl;

import it.tdgroup.eroi.dto.UserDTO;
import it.tdgroup.eroi.exception.MapperException;
import it.tdgroup.eroi.exception.ServiceException;
import it.tdgroup.eroi.mapperimpl.UserMapperImpl;
import it.tdgroup.eroi.repository.UserRepository;
import it.tdgroup.eroi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapperImpl userMapper;

    @Autowired
    @Qualifier("mongoTemplate")
    private MongoTemplate mongoTemplate;

    @Override
    public String create(UserDTO userDTO) throws ServiceException {
        return null;
    }

    @Override
    public UserDTO read(String name) throws ServiceException, MapperException {
        if (name != null && !(name.contentEquals(""))){
            UserDTO userDTO = userMapper.convertEntityToDto(userRepository.findByFirstName(name));
            return userDTO;
        }
        return null;
    }

    @Override
    public void update(String id, UserDTO userDTO) throws ServiceException {

    }

    @Override
    public void delete(String id) throws ServiceException {

    }
}

