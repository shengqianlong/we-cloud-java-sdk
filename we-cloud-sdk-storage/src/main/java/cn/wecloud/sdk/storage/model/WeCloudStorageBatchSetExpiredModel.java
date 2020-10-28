package cn.wecloud.sdk.storage.model;

import lombok.Getter;

/**
 * @author 陈俊雄
 * @since 2020/10/23
 **/
@Getter
public class WeCloudStorageBatchSetExpiredModel extends WeCloudStorageBatchOperationModel {

    private final Long expired;

    public WeCloudStorageBatchSetExpiredModel(Long[] userFileIds, Long expired) {
        super(userFileIds);
        this.expired = expired;
    }
}
