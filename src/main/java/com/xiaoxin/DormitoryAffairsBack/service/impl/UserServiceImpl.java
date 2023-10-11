package com.xiaoxin.DormitoryAffairsBack.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoxin.DormitoryAffairsBack.entity.User;
import com.xiaoxin.DormitoryAffairsBack.exception.ServiceException;
import com.xiaoxin.DormitoryAffairsBack.mapper.UserMapper;
import com.xiaoxin.DormitoryAffairsBack.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaoxin
 * @since 2023-10-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User login(User user) {
        User dbUser;
        try {
            dbUser=getOne(new QueryWrapper<User>().eq("username", user.getUsername()));

        } catch (Exception e) {
            throw new RuntimeException("数据库异常");
        }
        if(dbUser == null){
            throw new ServiceException("用户未注册");
        }
        if (!dbUser.getPassword().equals(user.getPassword())) {
            throw new ServiceException("账号或者密码错误");
        }
        return dbUser;

    }
}
