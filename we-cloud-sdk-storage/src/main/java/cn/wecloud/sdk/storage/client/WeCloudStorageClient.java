package cn.wecloud.sdk.storage.client;

import cn.wecloud.sdk.storage.model.WeCloudUploadFileModel;
import cn.wecloud.sdk.storage.request.WeCloudStorageUploadFileRequest;
import cn.wecloud.sdk.storage.request.WeCloudStorageUploadImageRequest;
import com.chanjx.utils.HttpClientUtils;
import com.chanjx.utils.StringUtils;
import com.chanjx.utils.entity.http.HttpFile;
import cn.wecloud.sdk.common.api.WeCloudClient;
import cn.wecloud.sdk.common.api.WeCloudParser;
import cn.wecloud.sdk.common.api.WeCloudRequest;
import cn.wecloud.sdk.common.api.WeCloudResponse;
import cn.wecloud.sdk.common.exception.WeCloudApiException;
import cn.wecloud.sdk.common.parser.ObjectJsonParser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈俊雄
 * @since 2020/10/20
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WeCloudStorageClient implements WeCloudClient {

    private static final String BASE_URI = "https://api-wecloud.da300.com:10007";

    private static final String UPLOAD_URI = BASE_URI + "/file/uploadSingleFile";

    private String accessKey;

    private String secretKey;

    private Long bucketId;

    public WeCloudStorageClient(String accessKey, String secretKey, Long bucketId) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.bucketId = bucketId;
    }

    @Override
    public <T extends WeCloudResponse> T execute(WeCloudRequest<T> request) throws WeCloudApiException {

        final ObjectJsonParser<T> parser = new ObjectJsonParser<>(request.getResponseClass());

        if (request instanceof WeCloudStorageUploadFileRequest) {
            return uploadFile((WeCloudStorageUploadFileRequest) request, parser);
        } else if (request instanceof WeCloudStorageUploadImageRequest) {

            return null;

        } else {

            return null;

        }
    }

    private <T extends WeCloudResponse> T uploadFile(WeCloudStorageUploadFileRequest request, WeCloudParser<T> parser) throws WeCloudApiException {
        try {
            final Map<String, String> uploadFileParams = getUploadFileParams(request);
            final HttpFile httpFile = new HttpFile(
                    request.getFileItem().getContent(),
                    request.getFileItem().getFileName(),
                    request.getFileItem().getMimeType(),
                    "file");
            final String result = HttpClientUtils.doPostMultipartForm(
                    UPLOAD_URI,
                    httpFile,
                    uploadFileParams);
            return parser.parse(result);
        } catch (IOException e) {
            throw new WeCloudApiException("文件上传IO异常！", e);
        }
    }

    private Map<String, String> getUploadFileParams(WeCloudStorageUploadFileRequest request) throws WeCloudApiException {
        try {
            final HashMap<String, String> map = new HashMap<>();
            final WeCloudUploadFileModel params = (WeCloudUploadFileModel) request.getParams();
            final String fileName = request.getFileItem().getFileName();
            final int length = request.getFileItem().getContent().length;
            String originalSign = secretKey
                    + "."
                    + bucketId
                    + (StringUtils.isBlank(params.getCustomId()) ? "" : "." + params.getCustomId())
                    + (params.getExpired() == null ? "" : "." + params.getExpired())
                    + "." + fileName
                    + "." + length
                    + (StringUtils.isBlank(params.getFileHash()) ? "" : "." + params.getFileHash());
            final String sign = DigestUtils.md5Hex(originalSign);
            map.put("bucketId", bucketId.toString());
            map.put("uploadToken", accessKey + "." + sign);
            if (StringUtils.isNotBlank(params.getCustomId())) {
                map.put("customId", params.getCustomId());
            }
            if (params.getExpired() != null) {
                map.put("expired", params.getExpired().toString());
            }
            if (StringUtils.isNotBlank(params.getFileHash())) {
                map.put("fileHash", params.getFileHash());
            }
            if (StringUtils.isNotBlank(params.getSender())) {
                map.put("sender", params.getSender());
            }
            if (StringUtils.isNotBlank(params.getReceiver())) {
                map.put("receiver", params.getReceiver());
            }
            if (params.getCover() != null) {
                map.put("cover", params.getCover().toString());
            }
            return map;
        } catch (IOException e) {
            throw new WeCloudApiException("获取文件IO异常！", e);
        }
    }
}
