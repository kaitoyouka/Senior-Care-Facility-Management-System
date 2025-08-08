package com.cy.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cy.domain.User;
import com.cy.dto.UserDto;
import com.cy.service.IUserService;
import com.cy.utils.ResultVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-23
 */
@RestController
@RequestMapping("/user")
@Tag(name = "用户管理")
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public ResultVo login(String username, String password) {
        return userService.login(username, password);
    }

    @Operation(summary = "查询系统用户-分页")
    @PostMapping("/findUserPage")
    public ResultVo findUserPage(@RequestBody UserDto userDto) {
        return userService.findUserPage(userDto);
    }

    @Operation(summary = "查询所有用户-分页")
    @PostMapping("/findAllUserPage")
    public ResultVo findAllUserPage(@RequestBody UserDto userDto) {
        return userService.findAllUserPage(userDto);
    }

    @Operation(summary = "添加用户")
    @PostMapping("/addUser")
    public ResultVo addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @Operation(summary = "修改用户")
    @PostMapping("/updateUser")
    public ResultVo updateUser(@RequestBody User user) {
        return userService.updateUser( user);
    }

    @Operation(summary = "删除用户")
    @GetMapping("/deleteUser/{id}")
    public ResultVo deleteUser(@PathVariable Integer id) {
        userService.removeById(id);
        return ResultVo.ok("删除成功");
    }
}

