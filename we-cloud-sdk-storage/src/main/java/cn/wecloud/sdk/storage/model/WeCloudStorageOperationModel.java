package cn.wecloud.sdk.storage.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * @author 陈俊雄
 * @since 2020/10/22
 **/
@Getter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WeCloudStorageOperationModel extends WeCloudStorageModel {

    private final Long userFileId;

    public WeCloudStorageOperationModel(Long userFileId) {
        this.userFileId = userFileId;
    }
}
