package cn.wecloud.sdk.sms.response;

import cn.wecloud.sdk.common.api.WeCloudResponse;
import cn.wecloud.sdk.sms.data.WeCloudSmsSingleSendResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 陈俊雄
 * @since 2020/11/3
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WeCloudSmsAbroadSingleSendResponse extends WeCloudResponse {

    private WeCloudSmsSingleSendResult data;
}
