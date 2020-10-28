package cn.wecloud.sdk.storage.request;

import cn.wecloud.sdk.common.api.WeCloudRequest;
import cn.wecloud.sdk.common.api.WeCloudResponse;

/**
 * @author 陈俊雄
 * @since 2020/10/23
 **/
public abstract class WeCloudStorageOperationRequest<T extends WeCloudResponse> implements WeCloudRequest<T> {
}
