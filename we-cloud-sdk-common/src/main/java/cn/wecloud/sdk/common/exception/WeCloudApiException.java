package cn.wecloud.sdk.common.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 陈俊雄
 * @since 2020/10/13
 **/
@Slf4j
public class WeCloudApiException extends Exception {

    private String errCode;

    private String errMsg;

    public WeCloudApiException() {
        super("WeCloud SDK异常！");
    }

    public WeCloudApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeCloudApiException(String message) {
        super(message);
    }

    public WeCloudApiException(Throwable cause) {
        super(cause);
    }

    public WeCloudApiException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
