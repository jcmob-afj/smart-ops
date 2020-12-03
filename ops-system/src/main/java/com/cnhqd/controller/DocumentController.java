package com.cnhqd.controller;

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

import com.cnhqd.dto.DocumentDto;
import com.cnhqd.dto.DocumentMenuDto;
import com.cnhqd.entity.Document;
import com.cnhqd.page.CommonPager;
import com.cnhqd.page.PageParameter;
import com.cnhqd.query.DocumentMenuQuery;
import com.cnhqd.query.DocumentQuery;
import com.cnhqd.result.OpsResult;
import com.cnhqd.service.DocumentService;
import com.cnhqd.vo.DocumentMenuVo;
import com.cnhqd.vo.DocumentVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author afj
 * @Date 2020-12-03 13:54:30
 * @Version 1.0
 * @description: 文档记录(Document)表控制层
 */
@RestController
@RequestMapping("document")
@Api(tags = "文档记录相关接口")
@Slf4j
public class DocumentController {

    private final DocumentService documentService;

    /**
     * Instantiates a new Meta data controller.
     *
     * @param documentService the meta data service
     */
    @Autowired(required = false)
    public DocumentController(final DocumentService documentService) {
        this.documentService = documentService;
    }


    /**
     * create document.
     *
     * @param documentDto document.
     * @return {@linkplain OpsResult}
     */
    @PostMapping("")
    @ApiOperation(value = "新增文档")
    public OpsResult createDocumentMenu(@RequestBody final DocumentDto documentDto) {
        String result = documentService.createOrUpdate(documentDto);
        if (StringUtils.isNoneBlank(result)) {
            return OpsResult.error(result);
        }
        return OpsResult.success("create document success");
    }

    /**
     * detail document.
     *
     * @param id document id.
     * @return {@linkplain OpsResult}
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "查询详情")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "ok", response = DocumentVo.class)})
    public OpsResult detailDocumentMenu(@ApiParam(value = "主键", required = true) @PathVariable("id") final Long id) {
        DocumentVo documentVo = documentService.findById(id);
        return OpsResult.success("detail documentMenu success", documentVo);
    }

    /**
     * update document.
     *
     * @param id          primary key.
     * @param documentDto document.
     * @return {@linkplain OpsResult}
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "修改文档")
    public OpsResult updateDocumentMenu(@PathVariable("id") final Long id, @RequestBody final DocumentDto documentDto) {
        Objects.requireNonNull(documentDto);
        documentDto.setId(id);
        final String result = documentService.createOrUpdate(documentDto);
        if (StringUtils.isNoneBlank(result)) {
            return OpsResult.error(result);
        }
        return OpsResult.success("update documentMenu success");
    }

    /**
     * delete document.
     *
     * @param id primary key.
     * @return {@linkplain OpsResult}
     */
    @DeleteMapping("/batch/{id}")
    @ApiOperation(value = "删除文档")
    public OpsResult deleteDocumentMenu(@PathVariable("id") final Long id) {
        final String result = documentService.delete(id);
        if (StringUtils.isNoneBlank(result)) {
            return OpsResult.error(result);
        }
        return OpsResult.success("delete document success");
    }

    /**
     * query document  by document id.
     *
     * @param childMenuId  documentMenu id.
     * @param currentPage current page.
     * @param pageSize    page size
     * @param name  document name
     * @param secret document secret
     * @param startTime document before create_time
     * @param stopTime  document after create_time
     * @return {@linkplain OpsResult}
     */
    @GetMapping("")
    @ApiOperation(value = "分页条件查询")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "ok", response = CommonPager.class)})
    public OpsResult queryDocumentMenus(final Long childMenuId,
                                        final Integer currentPage, final Integer pageSize,
                                        final String name, final String secret,
                                        final String startTime, final String stopTime) {
        CommonPager<DocumentVo> commonPager = documentService.listByPage(new DocumentQuery(childMenuId,name,secret,startTime,stopTime, new PageParameter(currentPage, pageSize)));
        return OpsResult.success("query documentMenu success", commonPager);
    }

}