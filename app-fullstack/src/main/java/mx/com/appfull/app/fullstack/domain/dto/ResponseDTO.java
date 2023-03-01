package mx.com.appfull.app.fullstack.domain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ResponseDTO {


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private Integer code;
    private String message;
    private Object data;
    private String alertType;
    private boolean bandera;


}
