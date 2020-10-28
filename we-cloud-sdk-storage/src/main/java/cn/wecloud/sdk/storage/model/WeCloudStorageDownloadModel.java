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
public class WeCloudStorageDownloadModel extends WeCloudStorageModel {

    private String customId;

    private Long userFileId;

    private final String contentDisposition = "attachment";

    private final Long bucketId;

    public WeCloudStorageDownloadModel(String customId, Long bucketId) {
        this.customId = customId;
        this.bucketId = bucketId;
    }

    public WeCloudStorageDownloadModel(Long userFileId, Long bucketId) {
        this.userFileId = userFileId;
        this.bucketId = bucketId;
    }
}
