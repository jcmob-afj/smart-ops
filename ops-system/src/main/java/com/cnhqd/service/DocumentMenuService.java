package com.cnhqd.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cnhqd.dto.DocumentMenuDto;
import com.cnhqd.entity.DocumentMenu;
import com.cnhqd.model.DocumentMenuTree;
import com.cnhqd.page.CommonPager;
import com.cnhqd.query.DocumentMenuQuery;
import com.cnhqd.result.OpsResult;
import com.cnhqd.vo.DocumentMenuVo;


/**
 * @Author afj
 * @Date 2020-12-01 14:05:20
 * @Version 1.0
 * @description: 文档目录(DocumentMenu)表服务接口
 */
public interface DocumentMenuService extends IService<DocumentMenu> {

    /**
     * find documentMenu by id.
     *
     * @param id pk.
     * @return {@linkplain DocumentMenuVo}
     */
    DocumentMenuVo findById(Long id);

    /**
     * Create or update long.
     *
     * @param documentMenuDto the documentMenu dto
     * @return the string
     */
    String createOrUpdate(DocumentMenuDto documentMenuDto);

    /**
     * Delete long.
     *
     * @param id the id
     * @return the string
     */
    String delete(Long id);

    /**
     * find page of rule by query.
     * @param documentMenuQuery {@linkplain DocumentMenuQuery}
     * @return {@link CommonPager}
     */
    CommonPager<DocumentMenuVo> listByPage(DocumentMenuQuery documentMenuQuery);

    /**
     * select documentMenu tree.
     *
     * @return {@linkplain OpsResult}
     */
    List<DocumentMenuTree<DocumentMenu>> findDocumentMenus();

}