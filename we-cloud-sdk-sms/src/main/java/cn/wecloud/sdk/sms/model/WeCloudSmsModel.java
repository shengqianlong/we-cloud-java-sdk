package cn.wecloud.sdk.sms.model;

import cn.wecloud.sdk.common.WeCloudObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 陈俊雄
 * @since 2020/11/3
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public abstract class WeCloudSmsModel extends WeCloudObject {

    /**
     * apiKey
     */
    private String apiKey;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 模版id
     */
    private String templateId;

    /**
     * 验证码内容
     */
    private String verificationCode;

    /**
     * 自定义id
     */
    private String customId;

    /**
     * 回调地址
     */
    private String callbackUrl;

    public WeCloudSmsModel(String phone, String templateId, String verificationCode) {
        this.phone = phone;
        this.templateId = templateId;
        this.verificationCode = verificationCode;
    }
}
