package it.tdgroup.eroi.domain.hero;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Base class for all entities in the system. All model classses shoud inherit this one
 *
 * @author sansajn
 */
@Data
public abstract class AbstractEntity {

    /**
     * Attribute id.
     */
    @Id
    private String id;

    /**
     * Attribute createdAt.
     */
    private Date createdAt;

    /**
     * Attribute updatedAt.
     */
    private Date updatedAt;

    public AbstractEntity() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
}
