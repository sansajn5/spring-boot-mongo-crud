package it.tdgroup.eroi.domain.hero.embedded;

import it.tdgroup.eroi.domain.hero.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Super hero's power entity
 *
 * @Belongs to {@link it.tdgroup.eroi.domain.hero.collection.SuperHero}.
 *
 * @author sansajn
 */
@Data
@AllArgsConstructor
public class SuperPower extends AbstractEntity {

    /**
     * Attribute name.
     */
    private String name;

    /**
     * Attribute description.
     */
    private String description;

    /**
     * Constructor for Superpower.
     */
    public SuperPower() {
        super();
    }

}
