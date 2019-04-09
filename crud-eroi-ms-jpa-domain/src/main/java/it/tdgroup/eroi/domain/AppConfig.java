package it.tdgroup.eroi.domain;

import com.mongodb.DBObject;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "APP_CONFIG")
@Data
public class AppConfig {

    @Id
    private String nome;

    private DBObject configurazione;

}

