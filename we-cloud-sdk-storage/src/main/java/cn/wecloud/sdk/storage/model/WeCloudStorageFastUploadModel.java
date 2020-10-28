package cn.wecloud.sdk.storage.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author 陈俊雄
 * @since 2020/10/22
 **/
@Getter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WeCloudStorageFastUploadModel extends WeCloudStorageModel {

    /**
     * 用户自定义文件获取Id，
     * 获取文件可直接通过该Id获取，
     * 且该字段必须用户Id下唯一，
     * 若为空服务端自动生成
     */
    @Setter
    private String customId;

    /**
     * 文件过期时间：
     * expired 小于 0 或 expired == null 不过期，
     * expired == 0 次日0点过期，
     * expired 大于 0 指定天数后0点过期
     */
    @Setter
    private Long expired;

    /**
     * 文件sha256值
     */
    private final String fileHash;

    /**
     * 文件名
     */
    private final String fileName;

    /**
     * 文件大小
     */
    private final Long fileSize;

    /**
     * 文件mime类型
     */
    private final String mimeType;

    /**
     * 额外字段：用于记录项目发送者Id、信息等
     */
    @Setter
    private String sender;

    /**
     * 额外字段：用于记录项目发送者Id、信息等
     */
    @Setter
    private String receiver;


    public WeCloudStorageFastUploadModel(String fileHash, String fileName, Long fileSize, String mimeType) {
        this.fileHash = fileHash;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.mimeType = mimeType;
    }
}
