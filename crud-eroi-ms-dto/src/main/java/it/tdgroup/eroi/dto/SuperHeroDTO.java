package it.tdgroup.eroi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperHeroDTO {

    /**
     * Attribute id.
     */
    private String id;

    /**
     * Attribute name.
     */
    @NotNull
    private String name;

    /**
     * Attribute surname.
     */
    @NotNull
    private String surname;

    /**
     * Attribute superHeroName.
     */
    @NotNull
    private String superHeroName;

    /**
     * Attribute superPowers.
     */
    private List<SuperPowerDTO> superPowers;

    /**
     * Attribute createdAt.
     */
    private Date createdAt;

    /**
     * Attribute updatedAt.
     */
    private Date updatedAt;

}
