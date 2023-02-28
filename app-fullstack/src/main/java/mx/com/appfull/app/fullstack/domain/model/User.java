package mx.com.appfull.app.fullstack.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import mx.com.appfull.app.fullstack.domain.base.EntityBase;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "employee")
public class User extends EntityBase {

    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;
    @NotEmpty
    @Size(min = 1, max = 50)
    private String lastName;
    @Email
    private String email;
    @Size(min = 5, max = 10)
    private String phone;

}