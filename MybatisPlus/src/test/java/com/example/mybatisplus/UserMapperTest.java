package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest

public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void selectAll() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void selectById() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void insert() {
        User user=new User(null,"肥大美",20,"123456@qq.com","null","0");
        userMapper.insert(user);
    }
    @Test
    public void update(){
        User user=new User(null,"肥大美",22,"123456@qq.com","null","null");
        userMapper.updateById(user);
    }
    @Test
    public void delete(){
        userMapper.deleteById(7L);
    }
    @Test
    public void pageSelect(){
        IPage<User> page = new Page<>(2, 3);//第几页，每页长度
        userMapper.selectPage(page, null);
        System.out.println(page.getTotal()); //总共长度
        System.out.println(page.getCurrent()); //getCurrent（）,获取当前页
        System.out.println(page.getSize()); //getCurrent（）,获取当前页
        List<User> records = page.getRecords(); //getRecords（）,获取查询数据
        records.forEach(System.out::println);
    }

    @Test
    public void constructorSelect() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper
                .lt(User::getAge,24)
                .likeRight(User::getName,"赵")
                .orderByDesc(User::getId);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
