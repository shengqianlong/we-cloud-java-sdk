package cn.wecloud.sdk.common.api;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 陈俊雄
 * @since 2020/10/15
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public abstract class WeCloudResponse implements Serializable {

    private String code;

    private String msg;

    private String body;

    private Map<String, String> params;

    public boolean isSuccess() {
        return "0".equals(code);
    }
}
