package mx.com.appfull.app.fullstack.domain.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mx.com.appfull.app.fullstack.domain.dto.UserDTO;
import mx.com.appfull.app.fullstack.domain.model.User;
import mx.com.appfull.app.fullstack.domain.services.converter.Converter;
import mx.com.appfull.app.fullstack.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRespository;

    @Autowired
    private Converter convertir;

    @Override
    public List<UserDTO> findAll() {
        List<User> userList = userRespository.findAll();
        return convertir.toDtoList(userList);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = convertir.toEntity(userDTO);
        userRespository.save(user);
        return userDTO;
    }

    @Override
    public void delete(Long id) {
        userRespository.deleteById(id);
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRespository.findById(id).orElse(null);
        return convertir.toDto(user);
    }
}
