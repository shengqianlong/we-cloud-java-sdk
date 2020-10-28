package cn.wecloud.sdk.storage.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * @author 陈俊雄
 * @since 2020/10/23
 **/
@Getter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WeCloudStorageSetExpired extends WeCloudStorageOperationModel {

    private final Long expired;

    public WeCloudStorageSetExpired(Long userFileId, Long expired) {
        super(userFileId);
        this.expired = expired;
    }
}
