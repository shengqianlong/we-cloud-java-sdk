package cn.wecloud.sdk;

import cn.wecloud.sdk.common.exception.WeCloudApiException;
import cn.wecloud.sdk.sms.client.WeCloudSmsClient;
import cn.wecloud.sdk.sms.data.WeCloudSmsSingleSendResult;
import cn.wecloud.sdk.sms.model.WeCloudSmsDomesticModel;
import cn.wecloud.sdk.sms.request.WeCloudSmsDomesticSingleSendRequest;
import cn.wecloud.sdk.sms.response.WeCloudSmsDomesticSingleSendResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author 陈俊雄
 * @since 2020/11/3
 **/
@Slf4j
public class SmsTest {
    @Test
    public void domesticSingleSend() throws WeCloudApiException {
        // 创建连接对象
        final WeCloudSmsClient client = new WeCloudSmsClient("5kXMjmRCdWFqkkds");
        // 创建请求信息对象
        final WeCloudSmsDomesticModel model = new WeCloudSmsDomesticModel("18059273037", "1323474417736716290", "123456");
        // 创建请求对象
        final WeCloudSmsDomesticSingleSendRequest request = new WeCloudSmsDomesticSingleSendRequest(model);
        // 执行请求
        final WeCloudSmsDomesticSingleSendResponse execute = client.execute(request);
        // 判断是否请求成功
        if (execute.isSuccess()) {
            // 获取返回业务对象
            final WeCloudSmsSingleSendResult result = execute.getData();
        } else {
            // 输出请求失败信息
            log.error(execute.getMsg());
        }
    }
}
