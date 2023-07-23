package com.syzechuan.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "Emp Login DTO")
public class EmployeeLoginDTO implements Serializable {

    @ApiModelProperty("UserName")
    private String username;

    @ApiModelProperty("Password")
    private String password;

}
