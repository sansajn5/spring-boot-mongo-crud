package it.tdgroup.eroi.mapperimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import it.tdgroup.eroi.domain.AppConfig;
import it.tdgroup.eroi.dto.AppConfigDTO;
import it.tdgroup.eroi.exception.MapperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppConfigMapperImpl extends AbstractMapperComponent<AppConfigDTO, AppConfig> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public AppConfigDTO convertEntityToDto(AppConfig entity) throws MapperException {
        if (entity != null) {
            AppConfigDTO dto = new AppConfigDTO();
            dto.setNome(entity.getNome());
            dto.setConfigurazione(JSON.serialize(entity.getConfigurazione()));
            return dto;
        } else {
            return null;
        }
    }

    @Override
    public AppConfig convertDtoToEntity(AppConfigDTO dto) throws MapperException {
        try {
            if (dto != null) {
                AppConfig entity = new AppConfig();
                entity.setNome(dto.getNome());
                entity.setConfigurazione((DBObject) JSON.parse(dto.getConfigurazione()));
                return entity;
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new MapperException("Errore durnate mapper AppConfig " + ex.getMessage());
        }
    }
}
