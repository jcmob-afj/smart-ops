package com.cnhqd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cnhqd.entity.Document;
import com.cnhqd.query.DocumentMenuQuery;
import com.cnhqd.query.DocumentQuery;
import com.cnhqd.vo.DocumentVo;

/**
 * @Author afj
 * @Date 2020-12-03 13:54:30
 * @Version 1.0
 * @description: 文档记录(Document)表数据库访问层
 */
@Mapper
public interface DocumentMapper extends BaseMapper<Document> {


    /**
     * count document by query.
     *
     * @param documentQuery {@linkplain DocumentQuery}
     * @return the count
     */
    Integer countByQuery(DocumentQuery documentQuery);

    /**
     * select documentVo list by query.
     *
     * @param documentQuery {@linkplain DocumentQuery}
     * @return the documentVo list
     */
    List<DocumentVo> selectByQuery(DocumentQuery documentQuery);
}