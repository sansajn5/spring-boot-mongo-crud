
package it.tdgroup.eroi.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document (collection = "USER")
public class User implements Serializable {

    @Id
    private String id;
    private String firstName;
    private String lastName;


}

