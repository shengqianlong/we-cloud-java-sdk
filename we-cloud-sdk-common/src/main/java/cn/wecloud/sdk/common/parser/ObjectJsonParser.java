package cn.wecloud.sdk.common.parser;

import cn.wecloud.sdk.common.api.WeCloudParser;
import cn.wecloud.sdk.common.api.WeCloudResponse;
import cn.wecloud.sdk.common.exception.WeCloudApiException;
import com.chanjx.utils.JsonUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.IOException;

/**
 * @author 陈俊雄
 * @since 2020/10/21
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ObjectJsonParser<T extends WeCloudResponse> implements WeCloudParser<T> {

    private Class<T> clazz;

    public ObjectJsonParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T parse(String rsp) throws WeCloudApiException {
        try {
            return JsonUtils.json2Obj(rsp, clazz);
        } catch (IOException e) {
            throw new WeCloudApiException("Json反序列化失败！", e);
        }
    }

    @Override
    public Class<T> getResponseClass() throws WeCloudApiException {
        return clazz;
    }
}
