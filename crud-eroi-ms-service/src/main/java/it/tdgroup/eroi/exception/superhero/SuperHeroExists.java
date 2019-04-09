package it.tdgroup.eroi.exception.superhero;

import it.tdgroup.eroi.exception.ServiceException;

/**
 * @author sansajn
 */
public class SuperHeroExists extends ServiceException {

    public SuperHeroExists(Throwable error) {
        super("SuperHero must have unique superhero name", error);
    }
}
