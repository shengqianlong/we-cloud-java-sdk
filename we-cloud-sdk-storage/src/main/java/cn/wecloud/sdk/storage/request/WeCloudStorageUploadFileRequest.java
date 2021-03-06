package cn.wecloud.sdk.storage.request;

import cn.wecloud.sdk.common.FileItem;
import cn.wecloud.sdk.common.WeCloudObject;
import cn.wecloud.sdk.storage.response.WeCloudStorageUploadFileResponse;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author 陈俊雄
 * @since 2020/10/19
 **/
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WeCloudStorageUploadFileRequest extends WeCloudStorageUploadRequest<WeCloudStorageUploadFileResponse> {

    private String apiVersion = "0.0.1";

    private WeCloudObject params;

    public WeCloudStorageUploadFileRequest(FileItem fileItem) {
        this.setFileItem(fileItem);
    }

    @Override
    public String getApiMethodName() {
        return "we-cloud.storage.upload-file";
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
    public Class<WeCloudStorageUploadFileResponse> getResponseClass() {
        return WeCloudStorageUploadFileResponse.class;
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
