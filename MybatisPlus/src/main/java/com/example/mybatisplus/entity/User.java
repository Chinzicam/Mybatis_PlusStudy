package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor  //全参构造
@NoArgsConstructor     //无参构造
//@TableName("User") //表名映射，默认与类名相同
public class User implements Serializable {

    @TableId(type = IdType.AUTO) //实现主键自增
    private Long id;
    private String name;
    private Integer age;

    @TableField(value = "email") // value =>字段映射，当这个和表名不同时可以使用

    private String email;

    @TableField(exist = false)  //默认是true，如果表里没有这个字段，可以使用
    private String status;

    @TableField(select = true)   // select =>是否查询这个字段，默认是true
//    @TableLogic   //.yml有配置全局，所以这里不用写TableLogic =>逻辑删除
    private String deleted;
}
