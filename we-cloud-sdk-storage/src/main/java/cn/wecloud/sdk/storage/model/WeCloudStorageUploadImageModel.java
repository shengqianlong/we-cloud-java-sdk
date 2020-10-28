package cn.wecloud.sdk.storage.model;

import cn.wecloud.sdk.storage.data.WeCloudStorageCustomImageInfo;
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
public class WeCloudStorageUploadImageModel extends WeCloudStorageUploadFileModel {

    private WeCloudStorageCustomImageInfo customImageInfo;

}
