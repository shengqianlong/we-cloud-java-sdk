package cn.wecloud.sdk.sms.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * @author 陈俊雄
 * @since 2020/11/3
 **/
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WeCloudSmsDomesticModel extends WeCloudSmsModel {
    /**
     * 区号(+86, +855)
     */
    @Getter
    private final String areaCode = "+86";


    public WeCloudSmsDomesticModel(String phone, String templateId, String verificationCode) {
        super(phone, templateId, verificationCode);
    }
}
