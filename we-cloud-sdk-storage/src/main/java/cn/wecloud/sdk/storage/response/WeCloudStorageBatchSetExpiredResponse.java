package cn.wecloud.sdk.storage.response;

import cn.wecloud.sdk.common.api.WeCloudResponse;
import cn.wecloud.sdk.storage.data.WeCloudStorageBatchResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 陈俊雄
 * @since 2020/10/22
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WeCloudStorageBatchSetExpiredResponse extends WeCloudResponse {

    private WeCloudStorageBatchResult data;

}
