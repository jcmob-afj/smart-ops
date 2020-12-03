package com.cnhqd.configure;


import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

/**
 * @Author afj
 * @Date 2020/8/10 16:51
 * @Version 1.0
 * @description:
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final Logger LOGGER= LoggerFactory.getLogger(MyMetaObjectHandler.class);

    //insert操作时要填充的字段
    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ...");
        //根据属性名字设置要填充的值
        this.setInsertFieldValByName("createTime",new Date(),metaObject);
        this.setInsertFieldValByName("updateTime",new Date(),metaObject);
    }

    //update操作时要填充的字段
    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.info("start update fill ...");
        this.setUpdateFieldValByName("updateTime",new Date(),metaObject);
    }
}