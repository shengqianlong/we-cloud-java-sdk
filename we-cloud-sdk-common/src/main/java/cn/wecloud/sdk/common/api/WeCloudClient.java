package cn.wecloud.sdk.common.api;

import cn.wecloud.sdk.common.exception.WeCloudApiException;

/**
 * @author 陈俊雄
 * @since 2020/10/15
 **/
public interface WeCloudClient {

    <T extends WeCloudResponse> T execute(WeCloudRequest<T> request) throws WeCloudApiException;
}
