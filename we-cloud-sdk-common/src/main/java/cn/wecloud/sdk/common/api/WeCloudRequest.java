package cn.wecloud.sdk.common.api;

import cn.wecloud.sdk.common.WeCloudObject;

import java.util.Map;

/**
 * @author 陈俊雄
 * @since 2020/10/15
 **/
public interface WeCloudRequest<T extends WeCloudResponse> {

    /**
     * 获取TOP的API名称。
     *
     * @return API名称
     */
    String getApiMethodName();

    /**
     * 获取所有的Key-Value形式的文本请求参数集合。其中：
     * <ul>
     * <li>Key: 请求参数名</li>
     * <li>Value: 请求参数值</li>
     * </ul>
     *
     * @return 文本请求参数集合
     */
    Map<String, String> getTextParams();

    /**
     * 得到当前接口的版本
     *
     * @return API版本
     */
    String getApiVersion();

    /**
     * 设置当前API的版本信息
     *
     * @param apiVersion API版本
     */
    void setApiVersion(String apiVersion);

    /**
     * 得到当前API的响应结果类型
     *
     * @return 响应类型
     */
    Class<T> getResponseClass();

    /**
     * 获取请求参数
     *
     * @return WeCloudObject
     */
    WeCloudObject getParams();

    void setParam(WeCloudObject params);
}
