
package top.alertcode.adelina.framework.commons.enums;

import top.alertcode.adelina.framework.commons.model.ErrorCode;
import top.alertcode.adelina.framework.exception.ProjectException;

import javax.servlet.http.HttpServletResponse;

/**
 * 业务异常枚举
 *
 * @author Bob
 * @version $Id: $Id
 */
public enum ErrorCodeEnum {

    /**
     * 400
     */
    BAD_REQUEST(HttpServletResponse.SC_BAD_REQUEST, true, "请求参数错误或不完整"),
    /**
     * JSON格式错误
     */
    JSON_FORMAT_ERROR(HttpServletResponse.SC_BAD_REQUEST, true, "JSON格式错误"),
    /**
     * 401
     */
    UNAUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, true, "请先进行认证"),
    /**
     * 403
     */
    FORBIDDEN(HttpServletResponse.SC_FORBIDDEN, true, "无权查看"),
    /**
     * 404
     */
    NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, true, "未找到该路径"),
    /**
     * 405
     */
    METHOD_NOT_ALLOWED(HttpServletResponse.SC_METHOD_NOT_ALLOWED, true, "请求方式不支�?"),
    /**
     * 406
     */
    NOT_ACCEPTABLE(HttpServletResponse.SC_NOT_ACCEPTABLE, true, "不可接受该请�?"),
    /**
     * 411
     */
    LENGTH_REQUIRED(HttpServletResponse.SC_LENGTH_REQUIRED, true, "长度受限�?"),
    /**
     * 415
     */
    UNSUPPORTED_MEDIA_TYPE(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, true, "不支持的媒体类型"),
    /**
     * 416
     */
    REQUESTED_RANGE_NOT_SATISFIABLE(HttpServletResponse.SC_REQUESTED_RANGE_NOT_SATISFIABLE, true, "不能满足请求的范�?"),
    /**
     * 500
     */
    INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, true, "服务器正在升级，请�?�心等待"),
    /**
     * 503
     */
    SERVICE_UNAVAILABLE(HttpServletResponse.SC_SERVICE_UNAVAILABLE, true, "请求超时"),
    /**
     * 演示系统，无法该操作
     */
    DEMO_SYSTEM_CANNOT_DO(HttpServletResponse.SC_SERVICE_UNAVAILABLE, true, "演示系统，无法该操作"),
    //----------------------------------------------------业务异常----------------------------------------------------
    /**
     * 用户名密码错�?
     */
    USERNAME_OR_PASSWORD_IS_WRONG(HttpServletResponse.SC_BAD_REQUEST, true, "用户名密码错�?"),
    /**
     * 用户被禁�?
     */
    USER_IS_DISABLED(HttpServletResponse.SC_NOT_ACCEPTABLE, true, "用户被禁�?"),
    /**
     * 未找到该用户
     */
    USER_NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, true, "未找到该用户"),
    /**
     * 原密码不正确
     */
    ORIGINAL_PASSWORD_IS_INCORRECT(HttpServletResponse.SC_BAD_REQUEST, true, "原密码不正确"),
    /**
     * 用户名已存在
     */
    USERNAME_ALREADY_EXISTS(HttpServletResponse.SC_BAD_REQUEST, true, "用户名已存在"),
    /**
     * 未找到该菜单
     */
    MENU_NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, true, "未找到该菜单"),

    ;

    private final int httpCode;
    private final boolean show;
    private final String msg;

    ErrorCodeEnum(int httpCode, boolean show, String msg) {
        this.httpCode = httpCode;
        this.msg = msg;
        this.show = show;
    }

    /**
     * <p>getErrorCode.</p>
     *
     * @param errorCode a {@link java.lang.String} object.
     * @return a {@link top.alertcode.adelina.framework.commons.enums.ErrorCodeEnum} object.
     */
    public static ErrorCodeEnum getErrorCode(String errorCode) {
        ErrorCodeEnum[] enums = ErrorCodeEnum.values();
        for (ErrorCodeEnum errorCodeEnum : enums) {
            if (errorCodeEnum.name().equalsIgnoreCase(errorCode)) {
                return errorCodeEnum;
            }
        }
        throw new ProjectException("Error: Unknown errorCode, or do not support changing errorCode!\n");
    }

    /**
     * 转换为ErrorCode(自定义返回消�?)
     *
     * @param msg 错误消息
     * @return ErrorCode
     */
    public ErrorCode convert(String msg) {
        return ErrorCode.builder().httpCode(httpCode()).show(show()).error(name()).msg(msg).build();
    }

    /**
     * 转换为ErrorCode
     *
     * @return ErrorCode
     */
    public ErrorCode convert() {
        return ErrorCode.builder().httpCode(httpCode()).show(show()).error(name()).msg(msg()).build();
    }

    /**
     * <p>httpCode.</p>
     *
     * @return a int.
     */
    public int httpCode() {
        return this.httpCode;
    }

    /**
     * <p>msg.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String msg() {
        return this.msg;
    }

    /**
     * <p>show.</p>
     *
     * @return a boolean.
     */
    public boolean show() {
        return this.show;
    }

}
