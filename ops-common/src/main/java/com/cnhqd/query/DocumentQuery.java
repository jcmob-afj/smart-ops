
package com.cnhqd.query;

import java.io.Serializable;

import com.cnhqd.page.PageParameter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author afj
 * @Date 2020-12-03 14:48:21
 * @Version 1.0
 * @description: DocumentQuery
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentQuery implements Serializable {

    /**
     * 二级目录id
     */
    private Long childMenuId;

    /**
     * document name.
     */
    private String name;

    /**
     * document secret
     */
    private String secret;

    /**
     * document createTime
     */
    private String startTime;

    /**
     * document createTime
     */
    private String stopTime;

    /**
     * page parameter.
     */
    private PageParameter pageParameter;
}
