package cn.wecloud.sdk.sms.request;

import cn.wecloud.sdk.common.WeCloudObject;
import cn.wecloud.sdk.common.api.WeCloudRequest;
import cn.wecloud.sdk.sms.response.WeCloudSmsDomesticSingleSendResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author 陈俊雄
 * @since 2020/11/3
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WeCloudSmsAbroadSingleSendRequest implements WeCloudRequest<WeCloudSmsDomesticSingleSendResponse> {

    private String apiVersion = "0.0.1";

    private WeCloudObject params;

    public WeCloudSmsAbroadSingleSendRequest(WeCloudObject params) {
        this.params = params;
    }

    @Override
    public String getApiMethodName() {
        return "we-cloud.sms.abroad.single.send";
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
    public Class<WeCloudSmsDomesticSingleSendResponse> getResponseClass() {
        return WeCloudSmsDomesticSingleSendResponse.class;
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
