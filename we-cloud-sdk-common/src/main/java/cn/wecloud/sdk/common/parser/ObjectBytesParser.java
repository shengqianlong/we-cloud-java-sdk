package cn.wecloud.sdk.common.parser;

import cn.wecloud.sdk.common.api.WeCloudParser;
import cn.wecloud.sdk.common.api.WeCloudResponse;
import cn.wecloud.sdk.common.exception.WeCloudApiException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 陈俊雄
 * @since 2020/10/23
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ObjectBytesParser<T extends WeCloudResponse> implements WeCloudParser<T> {

    private Class<T> clazz;

    public ObjectBytesParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T parse(String rsp) throws WeCloudApiException {
        try {
            final T t = this.clazz.newInstance();
            t.setBytes(rsp.getBytes());
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new WeCloudApiException("获取WeCloudBytesResponse对象异常！", e);
        }
    }

    @Override
    public T parse(byte[] bytes) throws WeCloudApiException {
        try {
            final T t = this.clazz.newInstance();
            t.setBytes(bytes);
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new WeCloudApiException("获取WeCloudBytesResponse对象异常！", e);
        }
    }

    @Override
    public Class<T> getResponseClass() throws WeCloudApiException {
        return this.clazz;
    }
}
