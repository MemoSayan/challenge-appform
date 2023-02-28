package mx.com.appfull.app.fullstack.domain.dto;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserDTO  {
    private Long id;
    private String name;

    private String lastName;

    private String email;

    private String jobTitle;

    private String phone;

}
