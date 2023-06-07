package com.example.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql:///mybatis_plus", "root", "czc123")
                .globalConfig(builder -> {
                    builder.author("czc") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\Learnfiles\\MybatisPlus\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example") // 设置父包名
                            .moduleName("MP_GeneratorTest") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "E:\\Learnfiles\\MybatisPlus\\src\\main\\resources\\com\\example\\MP_GeneratorTest\\mapper" )); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("x_user,x_role") // 设置需要生成的表名
                            .addTablePrefix("x_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
