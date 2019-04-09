package it.tdgroup.eroi.exception;

/**
 * @author sansajn
 */
public class EntityDosntExists extends ServiceException {

    public EntityDosntExists(Throwable error, String id) {
        super("Entity with " + id + " id is not found", error);
    }
}
