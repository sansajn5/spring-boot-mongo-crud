package it.tdgroup.eroi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import lombok.extern.apachecommons.CommonsLog;

/**
 * Classe utility per la conversione di JSON in Oggetti e viceversa.
 *
 * @param <T>
 */
@CommonsLog
public abstract class UtilityConverter<T> {

   
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public List<T> createObjectListFromJson(String jsonContent, Class clazz) {

        try {
            JavaType type = MAPPER.getTypeFactory().constructCollectionType(List.class, clazz);
            return MAPPER.readValue(jsonContent, type);
        } catch (IOException ex) {
            log.error("Errore:", ex);
            return null;
        }
    }

    public T createObjectFromJson(String jsonContent, Class<?> clazz) {
        try {
            return (T) MAPPER.readValue(jsonContent, clazz);
        } catch (IOException ex) {
            log.error("Errore:", ex);
            return null;
        }
    }

    public String createJsonFromObject(T object) {
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            log.error("Errore:" + ex);
            return null;
        }
    }
}
