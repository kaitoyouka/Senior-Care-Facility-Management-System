package com.cy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cy.domain.Menu;
import com.cy.domain.User;
import com.cy.dto.UserDto;
import com.cy.mapper.MenuMapper;
import com.cy.mapper.RoleMapper;
import com.cy.mapper.RolemenuMapper;
import com.cy.mapper.UserMapper;
import com.cy.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.utils.Jwt;
import com.cy.utils.ResultVo;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-23
 */
@Service

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RolemenuMapper rolemenuMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private Jwt jwt;
    @Override
    @Transactional
    public ResultVo login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password", password);
        User user1 = getOne(queryWrapper);
        if (user1 != null) {
            // 根据用户角色获取当前用户的菜单
            // ①获取得到角色对应的role_id
            QueryWrapper listRoleQw = new QueryWrapper();
            listRoleQw.eq("role_id", user1.getRoleId());
            listRoleQw.select("menu");
            List<Integer> menuIds = rolemenuMapper.selectObjs(listRoleQw);
            // ②根据menu_id查询一级菜单列表
            List<Menu> menus = menuMapper.selectBatchIds(menuIds);
            // ③查询子菜单
            for (Menu menu:menus) {
                QueryWrapper<Menu> listMenuLqw = new QueryWrapper<>();
                listMenuLqw.eq("parent_id", menu.getId());
                menu.setChildren(menuMapper.selectList(listMenuLqw));
            }
            user1.setMenuList(menus);
            String token = jwt.createToken(user1.getUsername());
            return ResultVo.ok(user1, token);
        }
        return ResultVo.fail("用户名或密码错误");
    }

    @Override
    public ResultVo findUserPage(UserDto userDTO) {
        Page<User> MyPage=new Page<>(userDTO.getPageSize(),3);
        QueryWrapper qw=new QueryWrapper();
        if(userDTO.getNickname()!=null && userDTO.getNickname()!=""){
            qw.like("nickname",userDTO.getNickname());
        }
        if(userDTO.getRoleId()!=null){
            qw.eq("role_id",userDTO.getRoleId());
        }
        qw.eq("is_deleted",0); //显示
        page(MyPage,qw);
        return ResultVo.ok(MyPage);
    }

    @Override
    public ResultVo findAllUserPage(UserDto userDTO){
        Page<User> MyPage=new Page<>(userDTO.getPageSize(),3);
        QueryWrapper qw=new QueryWrapper();
        page(MyPage,qw);
        return ResultVo.ok(MyPage);
    }

    @Override
    public ResultVo addUser(User user){
        user.setIsDeleted(0);
        userMapper.insert(user);
        return ResultVo.ok("添加成功");
    }

    @Override
    public ResultVo updateUser(User user){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();
        updateWrapper.eq("id",user.getId());
        userMapper.update(user,updateWrapper);
        return ResultVo.ok("修改成功");
    }
}
