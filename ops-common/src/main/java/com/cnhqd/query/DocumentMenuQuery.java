
package com.cnhqd.query;

import java.io.Serializable;

import com.cnhqd.page.PageParameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author afj
 * @Date 2020-12-01 14:15:34
 * @Version 1.0
 * @description: DocumentMenuQuery
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentMenuQuery implements Serializable {

    /**
     * documentMenu id.
     */
    private Long parentId;

    /**
     * page parameter.
     */
    private PageParameter pageParameter;
}
