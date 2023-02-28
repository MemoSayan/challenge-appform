package mx.com.appfull.app.fullstack.domain.base;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Base class for an entity, as explained in the book "Domain Driven Design".
 * All entities in this project have an identity attribute with type Long and
 * name id. Inspired by the DDD Sample project.
 *
 * @author Guillermo De la cruz
 * @since 2023-02/28
 */
@AllArgsConstructor @NoArgsConstructor
@ToString
@Getter @Setter
@MappedSuperclass
public abstract class EntityBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
