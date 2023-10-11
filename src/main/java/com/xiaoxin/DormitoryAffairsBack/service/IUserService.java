package com.xiaoxin.DormitoryAffairsBack.service;

import com.xiaoxin.DormitoryAffairsBack.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoxin
 * @since 2023-10-11
 */
public interface IUserService extends IService<User> {

    User login(User user);

    boolean updatePassword(User user);
}
