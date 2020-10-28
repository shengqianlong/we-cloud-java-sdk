package cn.wecloud.sdk.common.api;

import cn.wecloud.sdk.common.exception.WeCloudApiException;

/**
 * @author 陈俊雄
 * @since 2020/10/21
 **/
public interface WeCloudParser<T extends WeCloudResponse > {
    /**
     * 把响应字符串解释成相应的领域对象。
     *
     * @param rsp 响应字符串
     * @return 领域对象
     */
    T parse(String rsp) throws WeCloudApiException;


    T parse(byte[] bytes) throws WeCloudApiException;

    /**
     * 获取响应类类型。
     */
    Class<T> getResponseClass() throws WeCloudApiException;

}
