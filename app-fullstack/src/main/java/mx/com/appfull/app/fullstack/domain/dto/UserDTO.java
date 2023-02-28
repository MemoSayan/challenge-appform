package mx.com.appfull.app.fullstack.domain.dto;

import jakarta.persistence.*;
import lombok.*;
import mx.com.appfull.app.fullstack.domain.base.EntityBase;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class UserDTO extends EntityBase {
    private Long id;
    private String name;

    private String lastName;

    private String email;

    private String phone;

}
