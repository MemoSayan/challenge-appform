package mx.com.appfull.app.fullstack.domain.services;

import mx.com.appfull.app.fullstack.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO save(UserDTO userDTO);

    void delete(Long id);

    UserDTO findById(Long id);

}
