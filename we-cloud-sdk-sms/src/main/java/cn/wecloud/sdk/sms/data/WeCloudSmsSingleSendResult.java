package cn.wecloud.sdk.sms.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 陈俊雄
 * @since 2020/11/3
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WeCloudSmsSingleSendResult implements Serializable {

    /**
     * 发送状态
     */
    private Long status;

    /**
     * 消息（例如发送成功）
     */
    private String message;

    /**
     * 发送条数
     */
    private Long count;

    /**
     * 扣费金额
     */
    private BigDecimal amount;

    /**
     * 计费单位 例如RMB
     */
    private String unit;

    /**
     * 发送手机号
     */
    private String mobile;

    /**
     * 短信 id
     */
    private String smsId;
}
