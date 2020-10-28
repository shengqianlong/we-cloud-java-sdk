package cn.wecloud.sdk.storage.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author 陈俊雄
 * @since 2020/10/23
 **/
@Getter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WeCloudStorageGetCustomImageModel extends WeCloudStorageDownloadModel {

    private Integer width;

    private Integer height;

    @Setter
    private Float quality;

    @Setter
    private Double rotate;

    @Setter
    private Double scale;

    public WeCloudStorageGetCustomImageModel(String customId, Long bucketId) {
        super(customId, bucketId);
    }

    public WeCloudStorageGetCustomImageModel(Long userFileId, Long bucketId) {
        super(userFileId, bucketId);
    }

    public WeCloudStorageGetCustomImageModel(String customId, Long bucketId, Integer width, Integer height) {
        super(customId, bucketId);
        this.width = width;
        this.height = height;
    }

    public WeCloudStorageGetCustomImageModel(Long userFileId, Long bucketId, Integer width, Integer height) {
        super(userFileId, bucketId);
        this.width = width;
        this.height = height;
    }
}
