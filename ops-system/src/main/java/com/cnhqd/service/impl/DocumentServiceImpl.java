package com.cnhqd.service.impl;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cnhqd.dto.DocumentDto;
import com.cnhqd.dto.DocumentMenuDto;
import com.cnhqd.entity.Constants;
import com.cnhqd.entity.Document;
import com.cnhqd.entity.DocumentMenu;
import com.cnhqd.mapper.DocumentMapper;
import com.cnhqd.page.CommonPager;
import com.cnhqd.page.PageParameter;
import com.cnhqd.page.PageResultUtils;
import com.cnhqd.query.DocumentQuery;
import com.cnhqd.result.OpsResult;
import com.cnhqd.service.DocumentService;
import com.cnhqd.utils.BeanUtil;
import com.cnhqd.vo.DocumentMenuVo;
import com.cnhqd.vo.DocumentVo;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author afj
 * @Date 2020-12-03 13:54:30
 * @Version 1.0
 * @description: 文档记录(Document)表服务实现类
 */
@Service
@Slf4j
public class DocumentServiceImpl extends ServiceImpl<DocumentMapper, Document> implements DocumentService {

    private final DocumentMapper documentMapper;

    @Autowired(required = false)
    public DocumentServiceImpl(final DocumentMapper documentMapper) {
        this.documentMapper = documentMapper;
    }


    /**
     * detail document.
     *
     * @param id document id.
     * @return {@linkplain OpsResult}
     */
    @Override
    public DocumentVo findById(Long id) {
        Document document = this.getById(id);
        DocumentVo vo = BeanUtil.copy(document, DocumentVo.class);
        return vo;
    }


    /**
     * create document.
     *
     * @param documentDto document.
     * @return {@linkplain OpsResult}
     */
    @Override
    public String createOrUpdate(DocumentDto documentDto) {
        Document document = BeanUtil.copy(documentDto, Document.class);
        if (documentDto.getId() == null) {
            this.save(document);
        } else {
            this.updateById(document);
        }
        return StringUtils.EMPTY;
    }

    /**
     * delete document.
     *
     * @param id primary key.
     * @return {@linkplain OpsResult}
     */
    @Override
    public String delete(Long id) {
        Document document = documentMapper.selectById(id);
        if (Objects.isNull(document)) {
            return Constants.ID_NOT_EXIST;
        }
        documentMapper.deleteById(id);
        return StringUtils.EMPTY;
    }

    /**
     * find page of rule by query.
     * @param documentQuery {@linkplain DocumentQuery}
     * @return {@link CommonPager}
     */
    @Override
    public CommonPager<DocumentVo> listByPage(DocumentQuery documentQuery) {
        PageParameter pageParameter = documentQuery.getPageParameter();
        Integer count = documentMapper.countByQuery(documentQuery);
        return PageResultUtils.result(pageParameter, count, () -> documentMapper.selectByQuery(documentQuery));
    }




}