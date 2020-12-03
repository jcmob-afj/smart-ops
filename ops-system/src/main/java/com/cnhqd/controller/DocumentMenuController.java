package com.cnhqd.controller;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnhqd.dto.DocumentMenuDto;
import com.cnhqd.entity.DocumentMenu;
import com.cnhqd.model.DocumentMenuTree;
import com.cnhqd.page.CommonPager;
import com.cnhqd.page.PageParameter;
import com.cnhqd.query.DocumentMenuQuery;
import com.cnhqd.result.OpsResult;
import com.cnhqd.service.DocumentMenuService;
import com.cnhqd.vo.DocumentMenuVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author afj
 * @Date 2020-12-01 14:05:20
 * @Version 1.0
 * @description: 文档目录(DocumentMenu)
 */
@RestController
@RequestMapping("documentMenu")
@Api(tags = "文档目录相关接口")
@Slf4j
public class DocumentMenuController {


    private final DocumentMenuService documentMenuService;

    /**
     * Instantiates a new Meta data controller.
     *
     * @param documentMenuService the meta data service
     */
    @Autowired(required = false)
    public DocumentMenuController(final DocumentMenuService documentMenuService) {
        this.documentMenuService = documentMenuService;
    }

    /**
     * select documentMenu tree.
     *
     * @return {@linkplain OpsResult}
     */
    @GetMapping("select/tree")
    @ApiOperation(value = "文档目录树")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "ok", response = DocumentMenuTree.class)})
    public OpsResult getDocumentMenuTree() {
        List<DocumentMenuTree<DocumentMenu>> documentMenus = this.documentMenuService.findDocumentMenus();
        return OpsResult.success("detail documentMenu success", documentMenus);
    }

    /**
     * detail documentMenu.
     *
     * @param id documentMenu id.
     * @return {@linkplain OpsResult}
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "查询详情")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "ok", response = DocumentMenuVo.class)})
    public OpsResult detailDocumentMenu(@ApiParam(value = "主键", required = true) @PathVariable("id") final Long id) {
        DocumentMenuVo documentMenuVo = documentMenuService.findById(id);
        return OpsResult.success("detail documentMenu success", documentMenuVo);
    }

    /**
     * create documentMenu.
     *
     * @param documentMenuDto documentMenu.
     * @return {@linkplain OpsResult}
     */
    @PostMapping("")
    @ApiOperation(value = "新增目录")
    public OpsResult createDocumentMenu(@RequestBody final DocumentMenuDto documentMenuDto) {
        String result = documentMenuService.createOrUpdate(documentMenuDto);
        if (StringUtils.isNoneBlank(result)) {
            return OpsResult.error(result);
        }
        return OpsResult.success("create documentMenu success");
    }

    /**
     * update documentMenu.
     *
     * @param id              primary key.
     * @param documentMenuDto documentMenu.
     * @return {@linkplain OpsResult}
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "修改目录")
    public OpsResult updateDocumentMenu(@PathVariable("id") final Long id, @RequestBody final DocumentMenuDto documentMenuDto) {
        Objects.requireNonNull(documentMenuDto);
        documentMenuDto.setId(id);
        final String result = documentMenuService.createOrUpdate(documentMenuDto);
        if (StringUtils.isNoneBlank(result)) {
            return OpsResult.error(result);
        }
        return OpsResult.success("update documentMenu success");
    }

    /**
     * delete documentMenu.
     *
     * @param id primary key.
     * @return {@linkplain OpsResult}
     */
    @DeleteMapping("/batch/{id}")
    @ApiOperation(value = "删除目录")
    public OpsResult deleteDocumentMenu(@PathVariable("id") final Long id) {
        final String result = documentMenuService.delete(id);
        if (StringUtils.isNoneBlank(result)) {
            return OpsResult.error(result);
        }
        return OpsResult.success("delete documentMenu success");
    }

    /**
     * query documentMenu  by documentMenu id.
     *
     * @param parentId    documentMenu id.
     * @param currentPage current page.
     * @param pageSize    page size
     * @return {@linkplain OpsResult}
     */
    @GetMapping("")
    @ApiOperation(value = "分页条件查询")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "ok", response = CommonPager.class)})
    public OpsResult queryDocumentMenus(final Long parentId, final Integer currentPage, final Integer pageSize) {
        CommonPager<DocumentMenuVo> commonPager = documentMenuService.listByPage(new DocumentMenuQuery(parentId, new PageParameter(currentPage, pageSize)));
        return OpsResult.success("query documentMenu success", commonPager);
    }

}