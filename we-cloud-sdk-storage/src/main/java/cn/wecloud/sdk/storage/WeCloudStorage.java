package cn.wecloud.sdk.storage;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

/**
 * @author 陈俊雄
 * @since 2020/10/15
 **/
public class WeCloudStorage implements Serializable {

    private String accessKey;

    private String securityKey;

    private Long bucketId;

    public WeCloudStorage(String accessKey, String securityKey, Long bucketId) {
        this.accessKey = accessKey;
        this.securityKey = securityKey;
        this.bucketId = bucketId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public Long getBucketId() {
        return bucketId;
    }

    public void setBucketId(Long bucketId) {
        this.bucketId = bucketId;
    }

    public void uploadFile(File file) {

    }

    public void uploadFile(InputStream inputStream) {

    }
}
