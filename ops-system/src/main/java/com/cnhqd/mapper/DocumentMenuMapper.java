package com.cnhqd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cnhqd.entity.DocumentMenu;
import com.cnhqd.query.DocumentMenuQuery;
import com.cnhqd.vo.DocumentMenuVo;

/**
 * @Author afj
 * @Date 2020-12-01 14:05:21
 * @Version 1.0
 * @description: 文档目录(DocumentMenu)表数据库访问层
 */
@Mapper
public interface DocumentMenuMapper extends BaseMapper<DocumentMenu> {


    /**
     * count documentMenu by query.
     *
     * @param documentMenuQuery {@linkplain DocumentMenuQuery}
     * @return the count
     */
    int countByQuery(DocumentMenuQuery documentMenuQuery);

    /**
     * select documentMenu list by query.
     *
     * @param documentMenuQuery {@linkplain DocumentMenuQuery}
     * @return the documentMenu list
     */
    List<DocumentMenuVo> selectByQuery(DocumentMenuQuery documentMenuQuery);
}