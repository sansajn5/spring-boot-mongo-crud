package it.tdgroup.eroi.mapperimpl;

import it.tdgroup.eroi.domain.User;
import it.tdgroup.eroi.dto.UserDTO;
import it.tdgroup.eroi.exception.MapperException;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl extends AbstractMapperComponent<UserDTO, User> {

    @Override
    public UserDTO convertEntityToDto(User entity) throws MapperException {
        if (entity != null) {
            UserDTO dto = new UserDTO();
            dto.setId(entity.getId());
            dto.setFirstName(entity.getFirstName());
            dto.setLastName(entity.getLastName());
            return dto;
        }
        return null;
    }

    @Override
    public User convertDtoToEntity(UserDTO dto) throws MapperException {
        if (dto != null) {
            User entity = new User();
            entity.setId(dto.getId());
            entity.setFirstName(dto.getFirstName());
            entity.setLastName(dto.getLastName());
            return entity;
        }
        return null;
    }
}
