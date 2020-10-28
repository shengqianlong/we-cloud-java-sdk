package cn.wecloud.sdk.storage.data;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 陈俊雄
 * @since 2020/10/22
 **/
@Getter
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WeCloudStorageCustomImageInfo implements Serializable {

    /**
     * 目标格式：
     * jpg、jpeg、gif、bmp、wbmp、png
     */

    @Setter
    private String targetFormat;

    /**
     * 图片宽度
     * （高度与宽度必须同时有值或为空）
     */
    @Setter
    private Integer width;

    /**
     * 图片高度
     * （高度与宽度必须同时有值或为空）
     */
    private Integer height;

    /**
     * 图片质量（介于0和1之间的值）
     */
    @Setter
    private Float quality;

    /**
     * 旋转角度
     */
    @Setter
    private Double rotate;

    /**
     * 图片缩放大小
     */
    @Setter
    private Double scale;


    public WeCloudStorageCustomImageInfo() {
    }

    public WeCloudStorageCustomImageInfo(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }
}
