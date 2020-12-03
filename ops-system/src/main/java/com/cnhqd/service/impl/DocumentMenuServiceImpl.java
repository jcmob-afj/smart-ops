package com.cnhqd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cnhqd.dto.DocumentMenuDto;
import com.cnhqd.entity.Constants;
import com.cnhqd.entity.Document;
import com.cnhqd.entity.DocumentMenu;
import com.cnhqd.mapper.DocumentMapper;
import com.cnhqd.mapper.DocumentMenuMapper;
import com.cnhqd.model.DocumentMenuTree;
import com.cnhqd.page.CommonPager;
import com.cnhqd.page.PageParameter;
import com.cnhqd.page.PageResultUtils;
import com.cnhqd.query.DocumentMenuQuery;
import com.cnhqd.result.OpsResult;
import com.cnhqd.service.DocumentMenuService;
import com.cnhqd.utils.BeanUtil;
import com.cnhqd.utils.TreeUtil;
import com.cnhqd.vo.DocumentMenuVo;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author afj
 * @Date 2020-12-01 14:05:20
 * @Version 1.0
 * @description: 文档目录(DocumentMenu)表服务实现类
 */
@Service
@Slf4j
public class DocumentMenuServiceImpl extends ServiceImpl<DocumentMenuMapper, DocumentMenu> implements DocumentMenuService {

    private final DocumentMenuMapper documentMenuMapper;
    private final DocumentMapper documentMapper;

    @Autowired(required = false)
    public DocumentMenuServiceImpl(final DocumentMenuMapper documentMenuMapper, DocumentMapper documentMapper) {
        this.documentMenuMapper = documentMenuMapper;
        this.documentMapper = documentMapper;
    }


    /**
     * find documentMenu by id.
     *
     * @param id pk.
     * @return {@linkplain DocumentMenuVo}
     */
    @Override
    public DocumentMenuVo findById(final Long id) {
        DocumentMenu documentMenu = this.getById(id);
        DocumentMenuVo vo = BeanUtil.copy(documentMenu, DocumentMenuVo.class);
        return vo;
    }

    /**
     * create or update documentMenu.
     *
     * @param documentMenuDto {@linkplain DocumentMenuDto}
     * @return rows
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createOrUpdate(DocumentMenuDto documentMenuDto) {
        final String msg = checkData(documentMenuDto);
        if (StringUtils.isNoneBlank(msg)) {
            return msg;
        }
        DocumentMenu documentMenu = BeanUtil.copy(documentMenuDto, DocumentMenu.class);
        if (documentMenuDto.getId() == null) {
            this.save(documentMenu);
        } else {
            this.updateById(documentMenu);
        }
        return StringUtils.EMPTY;
    }

    /**
     * delete documentMenu.
     *
     * @param id primary key.
     * @return rows
     */
    @Override
    public String delete(Long id) {
        DocumentMenu exist = this.getById(id);
        if (Objects.nonNull(exist)) {
            return Constants.ID_NOT_EXIST;
        }
        QueryWrapper<DocumentMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(DocumentMenu::getParentId, id);
        List<DocumentMenu> menuList = this.documentMenuMapper.selectList(queryWrapper);
        if (menuList != null && menuList.size() > 0) {
            return Constants.DOCUMENT_CHILDREN_EXIST;
        }
        //如果二级目录下有文件不能删除
        QueryWrapper<Document> queryDocumentWrapper = new QueryWrapper<>();
        queryDocumentWrapper.lambda().eq(Document::getChildMenuId, id);
        List<Document> list = this.documentMapper.selectList(queryDocumentWrapper);
        if (list != null && list.size() > 0) {
            return Constants.DOCUMENT_EXIST;
        }
        this.removeById(id);
        return StringUtils.EMPTY;

    }

    /**
     * find page of rule by query.
     *
     * @param documentMenuQuery {@linkplain DocumentMenuQuery}
     * @return {@link CommonPager}
     */
    @Override
    public CommonPager<DocumentMenuVo> listByPage(DocumentMenuQuery documentMenuQuery) {
        PageParameter pageParameter = documentMenuQuery.getPageParameter();
        Integer count = documentMenuMapper.countByQuery(documentMenuQuery);
        return PageResultUtils.result(pageParameter, count, () -> documentMenuMapper.selectByQuery(documentMenuQuery));
    }

    /**
     * select documentMenu tree.
     *
     * @return {@linkplain OpsResult}
     */
    @Override
    public List<DocumentMenuTree<DocumentMenu>> findDocumentMenus() {
        List<DocumentMenu> menus = this.list();
        List<DocumentMenuTree<DocumentMenu>> trees = this.convertDepts(menus);
        return TreeUtil.buildDeptTree(trees);
    }


    private String checkData(final DocumentMenuDto documentMenuDto) {
        QueryWrapper<DocumentMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(DocumentMenu::getMenuName, documentMenuDto.getMenuName());
        final DocumentMenu exist = documentMenuMapper.selectOne(queryWrapper);
        if (documentMenuDto.getId() != null) {
            if (Objects.nonNull(exist)) {
                return Constants.NAME_IS_EXIST;
            }
        } else {
            if (Objects.isNull(exist) || !exist.getId().equals(documentMenuDto.getId())) {
                return Constants.NAME_NOT_EXIST;
            }
        }
        return StringUtils.EMPTY;
    }

    private List<DocumentMenuTree<DocumentMenu>> convertDepts(List<DocumentMenu> documentMenus) {
        List<DocumentMenuTree<DocumentMenu>> trees = new ArrayList<>();
        documentMenus.forEach(menu -> {
            DocumentMenuTree<DocumentMenu> tree = new DocumentMenuTree<>();
            tree.setId(menu.getId());
            tree.setParentId(menu.getParentId());
            tree.setMenuName(menu.getMenuName());
            tree.setData(menu);
            trees.add(tree);
        });
        return trees;
    }
}