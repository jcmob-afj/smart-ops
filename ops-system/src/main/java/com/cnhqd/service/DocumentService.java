package com.cnhqd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cnhqd.dto.DocumentDto;
import com.cnhqd.entity.Document;
import com.cnhqd.page.CommonPager;
import com.cnhqd.query.DocumentMenuQuery;
import com.cnhqd.query.DocumentQuery;
import com.cnhqd.result.OpsResult;
import com.cnhqd.vo.DocumentVo;


/**
 * @Author afj
 * @Date 2020-12-03 13:54:30
 * @Version 1.0
 * @description: 文档记录(Document)表服务接口
 */
public interface DocumentService extends IService<Document> {

    /**
     * create document.
     *
     * @param documentDto document.
     * @return {@linkplain OpsResult}
     */
    String createOrUpdate(DocumentDto documentDto);

    /**
     * delete document.
     *
     * @param id primary key.
     * @return {@linkplain OpsResult}
     */
    String delete(Long id);

    /**
     * find page of rule by query.
     * @param documentQuery {@linkplain DocumentQuery}
     * @return {@link CommonPager}
     */
    CommonPager<DocumentVo> listByPage(DocumentQuery documentQuery);

    /**
     * detail document.
     *
     * @param id document id.
     * @return {@linkplain OpsResult}
     */
    DocumentVo findById(Long id);
}