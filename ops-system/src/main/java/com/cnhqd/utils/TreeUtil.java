package com.cnhqd.utils;


import java.util.ArrayList;
import java.util.List;

import com.cnhqd.model.DocumentMenuTree;


/**
 * @author afj
 */
public class TreeUtil {

    private static final Long TOP_NODE_ID = 0L;


    public static <T> List<DocumentMenuTree<T>> buildDeptTree(List<DocumentMenuTree<T>> nodes) {
        if (nodes == null) {
            return null;
        }
        List<DocumentMenuTree<T>> result = new ArrayList<>();
        nodes.forEach(children -> {
            Long pid = children.getParentId();
            if (pid == null || TOP_NODE_ID.equals(pid)) {
                result.add(children);
                return;
            }
            for (DocumentMenuTree<T> n : nodes) {
                Long id = n.getId();
                if (id != null && id.equals(pid)) {
                    if (n.getChildren() == null) {
                        n.initChildren();
                    }
                    n.getChildren().add(children);
                    children.setHasParent(true);
                    n.setHasChild(true);
                    return;
                }
            }
        });

        return result;
    }


}