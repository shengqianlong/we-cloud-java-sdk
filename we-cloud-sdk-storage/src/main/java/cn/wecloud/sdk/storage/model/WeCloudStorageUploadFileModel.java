package cn.wecloud.sdk.storage.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 陈俊雄
 * @since 2020/10/21
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WeCloudStorageUploadFileModel extends WeCloudStorageModel {
    /**
     * 用户自定义文件获取id，
     * 获取文件可直接通过该id获取，
     * 且该字段必须空间内自定义id下唯一
     */
    private String customId;

    /**
     * 文件过期时间：
     * expired 大于 0 或 expired == null 不过期，
     * expired == 0 次日0点过期，
     * expired 小于 0 指定天数后0点过期
     */
    private Long expired;

    /**
     * 用于校验文件完整性文件hash256值
     */
    private String fileHash;

    /**
     * 当customId存在时且cover=true时覆盖原有文件
     */
    private Boolean cover;

    /**
     * 额外字段：用于记录项目发送者Id、信息等
     */
    private String sender;

    /**
     * 额外字段：用于记录项目发送者Id、信息等
     */
    private String receiver;


}
