package cn.wecloud.sdk.storage.request;

import cn.wecloud.sdk.common.FileItem;
import cn.wecloud.sdk.common.WeCloudObject;
import cn.wecloud.sdk.storage.response.WeCloudStorageUploadImageResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author 陈俊雄
 * @since 2020/10/19
 **/
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WeCloudStorageUploadImageRequest extends WeCloudStorageUploadRequest<WeCloudStorageUploadImageResponse> {

    private String apiVersion="0.0.1";

    private WeCloudObject params;

    @Getter
    private final FileItem fileItem;

    public WeCloudStorageUploadImageRequest(FileItem fileItem) {
        this.fileItem = fileItem;
    }

    public WeCloudStorageUploadImageRequest(WeCloudObject params, FileItem fileItem) {
        this.params = params;
        this.fileItem = fileItem;
    }

    @Override
    public String getApiMethodName() {
        return "we-cloud.storage.upload-image";
    }

    @Override
    public Map<String, String> getTextParams() {
        return null;
    }

    @Override
    public String getApiVersion() {
        return this.apiVersion;
    }

    @Override
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public Class<WeCloudStorageUploadImageResponse> getResponseClass() {
        return WeCloudStorageUploadImageResponse.class;
    }

    @Override
    public WeCloudObject getParams() {
        return this.params;
    }

    @Override
    public void setParam(WeCloudObject params) {
        this.params = params;
    }
}
