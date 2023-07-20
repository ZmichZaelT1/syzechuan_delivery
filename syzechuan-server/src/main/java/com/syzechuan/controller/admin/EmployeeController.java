package com.syzechuan.controller.admin;

import com.syzechuan.constant.JwtClaimsConstant;
import com.syzechuan.dto.EmployeeDTO;
import com.syzechuan.dto.EmployeeLoginDTO;
import com.syzechuan.dto.EmployeePageQueryDTO;
import com.syzechuan.entity.Employee;
import com.syzechuan.properties.JwtProperties;
import com.syzechuan.result.PageResult;
import com.syzechuan.result.Result;
import com.syzechuan.service.EmployeeService;
import com.syzechuan.utils.JwtUtil;
import com.syzechuan.vo.EmployeeLoginVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 登录
     *
     * @param employeeLoginDTO
     * @return
     */
    @PostMapping("/login")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("员工登录：{}", employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(employee.getId())
                .userName(employee.getUsername())
                .name(employee.getName())
                .token(token)
                .build();

        return Result.success(employeeLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }


    @PostMapping
    @ApiOperation("Add Employee")
    public Result save(@RequestBody EmployeeDTO employeeDTO) {
        log.info("add employee: {}", employeeDTO);
        employeeService.save(employeeDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("Employee Page Query")
    public Result<PageResult> page(EmployeePageQueryDTO employeePageQueryDTO) {
        PageResult pageResult = employeeService.pageQuery(employeePageQueryDTO);
        return Result.success(pageResult);

    }

    @PostMapping("/status/{status}")
    @ApiOperation("Enable/Disable Employee Account")
    public Result startOrStop(@PathVariable Integer status, Long id) {
        employeeService.startOrStop(status, id);
        return Result.success();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get Emp info by id")
    public Result<Employee> getById(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        return Result.success(employee);
    }

    @PutMapping
    @ApiOperation("Edit Emp info")
    public Result update(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.update(employeeDTO);
        return Result.success();
    }
}
