package com.cnhqd.result;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.cnhqd.exception.CommonErrorCode;

import lombok.Data;

/**
 * @Author afj
 * @Date 2020-12-01 14:38:01
 * @Version 1.0
 * @description: CommonPager
 */
@Data
public class OpsResult implements Serializable {

    private static final long serialVersionUID = -2792556188993845048L;

    private Integer code;

    private String message;

    private Object data;

    /**
     * Instantiates a new Soul result.
     */
    public OpsResult() {

    }

    /**
     * Instantiates a new Soul result.
     *
     * @param code    the code
     * @param message the message
     * @param data    the data
     */
    public OpsResult(final Integer code, final String message, final Object data) {

        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * return success.
     *
     * @return {@linkplain OpsResult}
     */
    public static OpsResult success() {
        return success("");
    }

    /**
     * return success.
     *
     * @param msg msg
     * @return {@linkplain OpsResult}
     */
    public static OpsResult success(final String msg) {
        return success(msg, null);
    }

    /**
     * return success.
     *
     * @param data this is result data.
     * @return {@linkplain OpsResult}
     */
    public static OpsResult success(final Object data) {
        return success(null, data);
    }

    /**
     * return success.
     *
     * @param msg  this ext msg.
     * @param data this is result data.
     * @return {@linkplain OpsResult}
     */
    public static OpsResult success(final String msg, final Object data) {
        return get(CommonErrorCode.SUCCESSFUL, msg, data);
    }

    /**
     * return error .
     *
     * @param msg error msg
     * @return {@linkplain OpsResult}
     */
    public static OpsResult error(final String msg) {
        return error(CommonErrorCode.ERROR, msg);
    }

    /**
     * return error .
     *
     * @param code error code
     * @param msg  error msg
     * @return {@linkplain OpsResult}
     */
    public static OpsResult error(final int code, final String msg) {
        return get(code, msg, null);
    }

    /**
     * return timeout .
     *
     * @param msg error msg
     * @return {@linkplain OpsResult}
     */
    public static OpsResult timeout(final String msg) {
        return error(HttpStatus.REQUEST_TIMEOUT.value(), msg);
    }

    private static OpsResult get(final int code, final String msg, final Object data) {
        return new OpsResult(code, msg, data);
    }

}
