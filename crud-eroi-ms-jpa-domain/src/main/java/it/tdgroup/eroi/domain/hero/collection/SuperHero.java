package it.tdgroup.eroi.domain.hero.collection;

import it.tdgroup.eroi.domain.hero.AbstractEntity;
import it.tdgroup.eroi.domain.hero.embedded.SuperPower;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Super Hero entity.
 *
 * @author sansajn
 */
@Data
@Document(collection = "heros")
@AllArgsConstructor
public class SuperHero extends AbstractEntity {

    /**
     * Attribute name.
     */
    private String name;

    /**
     * Attribute surname.
     */
    private String surname;

    /**
     * Attribute superHeroName.
     */
    @Indexed(unique = true)
    private String superHeroName;

    /**
     * Attribute powers.
     */
    private List<SuperPower> powers = new ArrayList<>();

    /**
     * Constructor for superhero
     */
    public SuperHero() {
        super();
    }

}
