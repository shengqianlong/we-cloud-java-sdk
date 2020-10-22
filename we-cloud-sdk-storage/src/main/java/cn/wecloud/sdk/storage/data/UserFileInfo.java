package cn.wecloud.sdk.storage.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 陈俊雄
 * @since 2020/10/22
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserFileInfo implements Serializable {
    /**
     * 用户文件Id，
     * 用于获取、操作文件
     */
    private String id;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件格式
     */
    private String fileFormat;

    /**
     * 用户自定义文件获取Id
     */
    private String customId;

    /**
     * 是否删除
     */
    private Boolean isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;
}
