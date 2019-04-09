package it.tdgroup.eroi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * DTO for create {@link it.tdgroup.eroi.domain.hero.collection.SuperHero} entity
 *
 * @author sansajn
 */
@Data
public class CreateSuperHeroDTO {

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

}
