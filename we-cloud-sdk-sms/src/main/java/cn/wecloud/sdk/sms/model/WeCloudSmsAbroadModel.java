package cn.wecloud.sdk.sms.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author 陈俊雄
 * @since 2020/11/3
 **/
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WeCloudSmsAbroadModel extends WeCloudSmsModel {
    /**
     * 区号(+86, +855)
     */
    @Getter
    @Setter
    private String areaCode;

    public WeCloudSmsAbroadModel(String areaCode, String phone, String templateId, String verificationCode) {
        super(phone, templateId, verificationCode);
        this.areaCode = areaCode;
    }
}
