package cn.wecloud.sdk.sms.client;

import cn.wecloud.sdk.common.api.WeCloudClient;
import cn.wecloud.sdk.common.api.WeCloudParser;
import cn.wecloud.sdk.common.api.WeCloudRequest;
import cn.wecloud.sdk.common.api.WeCloudResponse;
import cn.wecloud.sdk.common.exception.WeCloudApiException;
import cn.wecloud.sdk.common.parser.ObjectJsonParser;
import cn.wecloud.sdk.sms.model.WeCloudSmsModel;
import com.chanjx.utils.HttpClientUtils;
import com.chanjx.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 陈俊雄
 * @since 2020/11/3
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WeCloudSmsClient implements WeCloudClient {

    private static final String BASE_URI = "https://api.wecloud.cn:10004";

    private static final String SINGLE_SEND = BASE_URI + "/sms/service/sms/singleSend";

    private String apiKey;

    public WeCloudSmsClient(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public <T extends WeCloudResponse> T execute(WeCloudRequest<T> request) throws WeCloudApiException {
        try {
            final WeCloudParser<T> parser = new ObjectJsonParser<>(request.getResponseClass());
            WeCloudSmsModel model = (WeCloudSmsModel) request.getParams();
            model.setApiKey(apiKey);
            final String result = HttpClientUtils.doPostJson(SINGLE_SEND, JsonUtils.obj2Json(request.getParams())).getBody();

            return parser.parse(result);
        } catch (JsonProcessingException e) {
            throw new WeCloudApiException("短信发送异常！", e);
        }
    }
}
