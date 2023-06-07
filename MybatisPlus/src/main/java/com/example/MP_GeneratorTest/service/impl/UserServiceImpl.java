package com.example.MP_GeneratorTest.service.impl;

import com.example.MP_GeneratorTest.entity.User;
import com.example.MP_GeneratorTest.mapper.UserMapper;
import com.example.MP_GeneratorTest.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czc
 * @since 2023-06-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
