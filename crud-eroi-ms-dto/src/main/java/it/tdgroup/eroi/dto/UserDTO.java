
package it.tdgroup.eroi.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UserDTO implements Serializable {

    private String id;
    private String firstName;
    private String lastName;

}

