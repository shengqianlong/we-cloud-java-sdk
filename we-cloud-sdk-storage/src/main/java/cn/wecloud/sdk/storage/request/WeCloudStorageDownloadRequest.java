package cn.wecloud.sdk.storage.request;


import cn.wecloud.sdk.common.api.WeCloudRequest;
import cn.wecloud.sdk.common.api.WeCloudResponse;
import lombok.Data;

/**
 * @author 陈俊雄
 * @since 2020/10/20
 **/
@Data
public abstract class WeCloudStorageDownloadRequest<T extends WeCloudResponse> implements WeCloudRequest<T> {

}
