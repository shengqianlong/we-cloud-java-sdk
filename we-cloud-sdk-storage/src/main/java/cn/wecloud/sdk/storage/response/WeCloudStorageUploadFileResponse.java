package cn.wecloud.sdk.storage.response;

import cn.wecloud.sdk.common.api.WeCloudResponse;
import cn.wecloud.sdk.storage.data.WeCloudStorageUserFileInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 陈俊雄
 * @since 2020/10/19
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WeCloudStorageUploadFileResponse extends WeCloudResponse {

    private WeCloudStorageUserFileInfo data;

}
