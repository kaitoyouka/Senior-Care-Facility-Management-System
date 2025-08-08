package com.cy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cy.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.dto.UserDto;
import com.cy.utils.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-23
 */
public interface IUserService extends IService<User> {
    ResultVo login(String username, String password);

    ResultVo findUserPage(UserDto userDTO);

    ResultVo findAllUserPage(UserDto userDTO);

    ResultVo addUser(User user);

    ResultVo updateUser(User user);
}
