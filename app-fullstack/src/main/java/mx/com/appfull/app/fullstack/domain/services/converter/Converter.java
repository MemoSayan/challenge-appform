package mx.com.appfull.app.fullstack.domain.services.converter;

import mx.com.appfull.app.fullstack.domain.dto.UserDTO;
import mx.com.appfull.app.fullstack.domain.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    User user;

    public UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public User toEntity(UserDTO user) {
        if (user == null) {
            return null;
        }
        User entity = new User();
        BeanUtils.copyProperties(user, entity);
        return entity;
    }

    public List<UserDTO> toDtoList(List<User> user) {
        if (user == null) {
            return null;
        }
        List<UserDTO> list = new ArrayList<>();
        for (int i = 0; i < user.size(); i++) {
            User employeeEt = user.get(i);
            UserDTO employeeDTO = toDto(employeeEt);
            list.add(employeeDTO);
        }
        return list;
    }

}
