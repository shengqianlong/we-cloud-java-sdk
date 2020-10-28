package cn.wecloud.sdk.storage.request;

import cn.wecloud.sdk.common.WeCloudObject;
import cn.wecloud.sdk.storage.response.WeCloudStorageDownloadResponse;

import java.util.Map;

/**
 * @author 陈俊雄
 * @since 2020/10/22
 **/
public class WeCloudStorageDownloadFileRequest extends WeCloudStorageDownloadRequest<WeCloudStorageDownloadResponse> {

    private String apiVersion = "0.0.1";

    private WeCloudObject params;

    @Override
    public String getApiMethodName() {
        return "we-cloud.storage.download";
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
    public Class<WeCloudStorageDownloadResponse> getResponseClass() {
        return WeCloudStorageDownloadResponse.class;
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
