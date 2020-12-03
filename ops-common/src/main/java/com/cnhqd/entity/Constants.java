package com.cnhqd.entity;

/**
 * @Author afj
 * @Date 2020/8/31 19:50
 * @Version 1.0
 * @description: 系统常量
 */
public class Constants {


    /**
     * 异步线程池名称
     */
    public static final String ASYNC_POOL = "AsyncThreadPool";

    /**
     * The constant NAME_IS_EXIST.
     */
    public static final String NAME_IS_EXIST = "名称已经存在，不能重复添加!";

    /**
     * The constant ID_NOT_EXIST.
     */
    public static final String ID_NOT_EXIST = "id不存在！";

    /**
     * The constant NAME_NOT_EXIST.
     */
    public static final String NAME_NOT_EXIST = "名称已经不存在!";

    /**
     * The constant SYS_NOT_DELETE.
     */
    public static final String SYS_NOT_DELETE = "系统不能删除!";

    /**
     * The constant Document children menu exist.
     */
    public static final String DOCUMENT_CHILDREN_EXIST = "当前一级目录下仍有二级目录，无法删除当前目录，如需删除此目录，请确保当前目录下无附属的二级目录。";

    /**
     * The constant Document exist
     */
    public static final String DOCUMENT_EXIST = "当前目录下还有归属文档，无法删除当前目录，如需删除此目录请将此目录下的文档移动至别处。";

    /**
     * The constant DEFAULT_SUCCESS_MESSAGE
     */
    public static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";

}
