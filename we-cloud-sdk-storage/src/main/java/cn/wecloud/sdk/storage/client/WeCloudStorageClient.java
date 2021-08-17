package cn.wecloud.sdk.storage.client;

import cn.wecloud.sdk.common.api.WeCloudClient;
import cn.wecloud.sdk.common.api.WeCloudParser;
import cn.wecloud.sdk.common.api.WeCloudRequest;
import cn.wecloud.sdk.common.api.WeCloudResponse;
import cn.wecloud.sdk.common.exception.WeCloudApiException;
import cn.wecloud.sdk.common.parser.ObjectBytesParser;
import cn.wecloud.sdk.common.parser.ObjectJsonParser;
import cn.wecloud.sdk.storage.data.WeCloudStorageCustomImageInfo;
import cn.wecloud.sdk.storage.model.*;
import cn.wecloud.sdk.storage.request.*;
import com.chanjx.utils.HttpClientUtils;
import com.chanjx.utils.JsonUtils;
import com.chanjx.utils.StringUtils;
import com.chanjx.utils.entity.http.HttpFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
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

    private static final String BASE_URI = "https://api.wecloud.cn:10007";

    private static final String UPLOAD_FILE_URI = BASE_URI + "/file/uploadSingleFile";

    private static final String UPLOAD_IMAGE_URI = BASE_URI + "/file/uploadImageFile";

    private static final String FAST_UPLOAD_URI = BASE_URI + "/file/fastUpload";

    private static final String DOWNLOAD_URI = BASE_URI + "/file/download";

    private static final String GET_CUSTOM_IMAGE_URI = BASE_URI + "/file/getCustomImage";

    private static final String FILE_DELETE_URI = BASE_URI + "/file/operation/delete";

    private static final String FILE_BATCH_DELETE_URI = BASE_URI + "/file/batchOperation/delete";

    private static final String FILE_RECOVERY_URI = BASE_URI + "/file/operation/delete";

    private static final String FILE_BATCH_RECOVERY_URI = BASE_URI + "/file/batchOperation/delete";

    private static final String FILE_SET_EXPIRED_URI = BASE_URI + "/file/operation/expired";

    private static final String FILE_BATCH_SET_EXPIRED_URI = BASE_URI + "/file/batchOperation/expired";

    private String accessKey;

    private String secretKey;

    private Long bucketId;

    public WeCloudStorageClient(String accessKey, String secretKey, Long bucketId) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.bucketId = bucketId;
    }

    @Override
    public <T extends WeCloudResponse> T execute(WeCloudRequest<T> request) throws WeCloudApiException, URISyntaxException {

        final WeCloudParser<T> parser = new ObjectJsonParser<>(request.getResponseClass());

        if (request instanceof WeCloudStorageUploadFileRequest) {
            return uploadFile((WeCloudStorageUploadRequest<T>) request, parser);

        } else if (request instanceof WeCloudStorageUploadImageRequest) {
            return uploadFile((WeCloudStorageUploadRequest<T>) request, parser);

        } else if (request instanceof WeCloudStorageFastUploadRequest) {
            return fastUpload((WeCloudStorageFastUploadRequest) request, parser);

        } else if (request instanceof WeCloudStorageDownloadFileRequest) {
            final ObjectBytesParser<T> bytesParser = new ObjectBytesParser<>(request.getResponseClass());
            return download((WeCloudStorageDownloadRequest<T>) request, bytesParser);

        } else if (request instanceof WeCloudStorageGetCustomImageRequest) {
            final ObjectBytesParser<T> bytesParser = new ObjectBytesParser<>(request.getResponseClass());
            return download((WeCloudStorageDownloadRequest<T>) request, bytesParser);

        } else if (request instanceof WeCloudStorageDeleteRequest) {
            return operationFile((WeCloudStorageOperationRequest<T>) request, parser, FILE_DELETE_URI);

        } else if (request instanceof WeCloudStorageBatchDeleteRequest) {
            return batchOperation((WeCloudStorageOperationRequest<T>) request, parser, FILE_BATCH_DELETE_URI);

        } else if (request instanceof WeCloudStorageRecoveryRequest) {
            return operationFile((WeCloudStorageOperationRequest<T>) request, parser, FILE_RECOVERY_URI);

        } else if (request instanceof WeCloudStorageBatchRecoveryRequest) {
            return batchOperation((WeCloudStorageOperationRequest<T>) request, parser, FILE_BATCH_RECOVERY_URI);

        } else if (request instanceof WeCloudStorageSetExpiredRequest) {
            return batchOperation((WeCloudStorageOperationRequest<T>) request, parser, FILE_SET_EXPIRED_URI);

        } else if (request instanceof WeCloudStorageBatchSetExpiredRequest) {
            return batchOperation((WeCloudStorageOperationRequest<T>) request, parser, FILE_BATCH_SET_EXPIRED_URI);

        } else {
            throw new WeCloudApiException("无效的请求类型：" + request.getClass().getName());

        }
    }

    private <T extends WeCloudResponse> T uploadFile(WeCloudStorageUploadRequest<T> request, WeCloudParser<T> parser) throws WeCloudApiException {
        try {
            final Map<String, String> uploadFileParams = getUploadFileParams(request);
            final HttpFile httpFile = new HttpFile(
                    request.getFileItem().getContent(),
                    request.getFileItem().getFileName(),
                    request.getFileItem().getMimeType(),
                    "file");
            final String uri;
            if (request instanceof WeCloudStorageUploadFileRequest) {
                uri = UPLOAD_FILE_URI;
            } else if (request instanceof WeCloudStorageUploadImageRequest) {
                uri = UPLOAD_IMAGE_URI;
            } else {
                throw new WeCloudApiException("文件上传失败，无效的请求类型：" + request.getClass().getName());
            }
            final String result = HttpClientUtils.doPostMultipartForm(
                    uri,
                    httpFile,
                    uploadFileParams).getBody();
            return parser.parse(result);
        } catch (IOException e) {
            throw new WeCloudApiException("文件上传IO异常！", e);
        }
    }

    private <T extends WeCloudResponse> Map<String, String> getUploadFileParams(WeCloudStorageUploadRequest<T> request) throws WeCloudApiException {
        try {
            final HashMap<String, String> params = new HashMap<>();
            final WeCloudStorageUploadFileModel model = (WeCloudStorageUploadFileModel) request.getParams();
            params.put("bucketId", bucketId.toString());

            if (StringUtils.isNotBlank(model.getCustomId())) {
                params.put("customId", model.getCustomId());
            }
            if (model.getExpired() != null) {
                params.put("expired", model.getExpired().toString());
            }
            if (StringUtils.isNotBlank(model.getFileHash())) {
                params.put("fileHash", model.getFileHash());
            }
            if (StringUtils.isNotBlank(model.getSender())) {
                params.put("sender", model.getSender());
            }
            if (StringUtils.isNotBlank(model.getReceiver())) {
                params.put("receiver", model.getReceiver());
            }
            if (model.getCover() != null) {
                params.put("cover", model.getCover().toString());
            }
            String originalSign = secretKey
                    + "." + bucketId
                    + (StringUtils.isBlank(model.getCustomId()) ? "" : "." + model.getCustomId())
                    + (model.getExpired() == null ? "" : "." + model.getExpired())
                    + "." + request.getFileItem().getFileName()
                    + "." + request.getFileItem().getContent().length
                    + (StringUtils.isBlank(model.getFileHash()) ? "" : "." + model.getFileHash());

            if (request instanceof WeCloudStorageUploadImageRequest) {
                final WeCloudStorageUploadImageModel imageModel = (WeCloudStorageUploadImageModel) model;
                final WeCloudStorageCustomImageInfo customImageInfo = imageModel.getCustomImageInfo();
                if (customImageInfo != null) {
                    final String cIIJson = JsonUtils.obj2JsonNonNull(customImageInfo);
                    originalSign += ("." + cIIJson);
                }
            }
            params.put("uploadToken", accessKey + "." + DigestUtils.md5Hex(originalSign));
            return params;
        } catch (IOException e) {
            throw new WeCloudApiException("获取文件IO异常！", e);
        }
    }

    private <T extends WeCloudResponse> T fastUpload(WeCloudStorageFastUploadRequest request, WeCloudParser<T> parser) throws WeCloudApiException {
        final WeCloudStorageFastUploadModel model = (WeCloudStorageFastUploadModel) request.getParams();
        final HashMap<String, String> params = new HashMap<>();
        params.put("bucketId", bucketId.toString());
        params.put("fileHash", model.getFileHash());
        params.put("fileName", model.getFileName());
        params.put("fileSize", model.getFileSize().toString());
        params.put("mimeType", model.getMimeType());
        if (StringUtils.isNotBlank(model.getCustomId())) {
            params.put("customId", model.getCustomId());
        }
        if (model.getExpired() != null) {
            params.put("expired", model.getExpired().toString());
        }
        if (StringUtils.isNotBlank(model.getSender())) {
            params.put("sender", model.getSender());
        }
        if (StringUtils.isNotBlank(model.getReceiver())) {
            params.put("receiver", model.getReceiver());
        }
        final String originalSign = secretKey
                + "." + bucketId
                + (StringUtils.isBlank(model.getCustomId()) ? "" : "." + model.getCustomId())
                + (model.getExpired() == null ? "" : "." + model.getExpired())
                + "." + model.getFileName()
                + "." + model.getFileSize()
                + "." + model.getMimeType()
                + "." + model.getFileSize();
        params.put("uploadToken", accessKey + "." + DigestUtils.md5Hex(originalSign));
        return doPostJson(parser, params, FAST_UPLOAD_URI);
    }

    private <T extends WeCloudResponse> T operationFile(WeCloudStorageOperationRequest<T> request, WeCloudParser<T> parser, String uri) throws WeCloudApiException {
        final WeCloudStorageOperationModel model = (WeCloudStorageOperationModel) request.getParams();
        final HashMap<String, String> params = new HashMap<>();
        params.put("userFileId", model.getUserFileId().toString());
        String originalSign = secretKey
                + "." + model.getUserFileId();
        if (model instanceof WeCloudStorageSetExpired) {
            params.put("expired", ((WeCloudStorageSetExpired) model).getExpired().toString());
            originalSign += ("." + ((WeCloudStorageSetExpired) model).getExpired().toString());
        }
        params.put("accessToken", accessKey + "." + DigestUtils.md5Hex(originalSign));
        return doPostJson(parser, params, uri);
    }

    private <T extends WeCloudResponse> T batchOperation(WeCloudStorageOperationRequest<T> request, WeCloudParser<T> parser, String uri) throws WeCloudApiException {
        final WeCloudStorageBatchOperationModel model = (WeCloudStorageBatchOperationModel) request.getParams();
        final HashMap<String, String> params = new HashMap<>();
        params.put("idList", Arrays.toString(model.getUserFileIds()));
        String originalSign = secretKey
                + "." + Arrays.toString(model.getUserFileIds());
        if (model instanceof WeCloudStorageBatchSetExpiredModel) {
            params.put("expired", ((WeCloudStorageBatchSetExpiredModel) model).getExpired().toString());
            originalSign += ("." + ((WeCloudStorageBatchSetExpiredModel) model).getExpired().toString());
        }
        params.put("accessToken", accessKey + "." + DigestUtils.md5Hex(originalSign));
        return doPostJson(parser, params, uri);
    }

    private <T extends WeCloudResponse> T doPostJson(WeCloudParser<T> parser, Map<String, String> params, String uri) throws WeCloudApiException {
        try {
            final String result = HttpClientUtils.doPostJson(uri, JsonUtils.obj2JsonNonNull(params)).getBody();
            return parser.parse(result);
        } catch (JsonProcessingException e) {
            throw new WeCloudApiException("Json系列化异常！", e);
        }
    }

    private <T extends WeCloudResponse> T download(WeCloudStorageDownloadRequest<T> request, WeCloudParser<T> parser) throws WeCloudApiException, URISyntaxException {
        final WeCloudStorageDownloadModel model = (WeCloudStorageDownloadModel) request.getParams();
        final String uri;
        if (model instanceof WeCloudStorageGetCustomImageModel) {
            uri = GET_CUSTOM_IMAGE_URI;
        } else {
            uri = DOWNLOAD_URI;
        }
        String originalSign = secretKey;
        final HashMap<String, String> query = new HashMap<>();
        query.put("bucketId", bucketId.toString());
        query.put("contentDisposition", model.getContentDisposition());
        if (StringUtils.isNotBlank(model.getCustomId())) {
            query.put("customId", model.getCustomId());
            originalSign += ("." + model.getCustomId());
        } else {
            query.put("userFileId", model.getUserFileId().toString());
            originalSign += ("." + model.getUserFileId().toString());
        }
        originalSign += "." + bucketId
                + "." + model.getContentDisposition();
        query.put("downloadToken", accessKey + "." + DigestUtils.md5Hex(originalSign));
        final byte[] bytes = HttpClientUtils.doGet(uri, query, null).getByteBody();
        return parser.parse(bytes);
    }
}
