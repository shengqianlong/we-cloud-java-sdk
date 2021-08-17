package cn.wecloud.sdk;

import cn.wecloud.sdk.common.FileItem;
import cn.wecloud.sdk.common.exception.WeCloudApiException;
import cn.wecloud.sdk.storage.client.WeCloudStorageClient;
import cn.wecloud.sdk.storage.model.WeCloudStorageDownloadModel;
import cn.wecloud.sdk.storage.model.WeCloudStorageUploadImageModel;
import cn.wecloud.sdk.storage.request.WeCloudStorageDownloadFileRequest;
import cn.wecloud.sdk.storage.request.WeCloudStorageUploadImageRequest;
import cn.wecloud.sdk.storage.response.WeCloudStorageDownloadResponse;
import cn.wecloud.sdk.storage.response.WeCloudStorageUploadImageResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.net.URISyntaxException;

/**
 * @author 陈俊雄
 * @since 2020/10/22
 **/
@Slf4j
public class StorageTest {
    @Test
    public void uploadFile() throws WeCloudApiException, URISyntaxException {
        // 创建连接对象
        final WeCloudStorageClient client = new WeCloudStorageClient("603HlpEe4k", "rGxLoi0cRP1g", 1331421226355433473L);
        // 创建文件对象
        final FileItem fileItem = new FileItem("C:\\Users\\Kevin\\Pictures\\farmers-market-hero.jpg");
        // 创建业务对象
        final WeCloudStorageUploadImageModel model = new WeCloudStorageUploadImageModel();
        // 创建文件上传请求
        final WeCloudStorageUploadImageRequest request = new WeCloudStorageUploadImageRequest(fileItem);
        // 设置请求参数
        request.setParam(model);
        // 执行请求
        final WeCloudStorageUploadImageResponse response = client.execute(request);
        System.out.println(response.getData());
    }

    @Test
    public void downloadFile() throws WeCloudApiException, URISyntaxException {
        final WeCloudStorageClient client = new WeCloudStorageClient("603HlpEe4k", "rGxLoi0cRP1g", 1331421226355433473L);
        final WeCloudStorageDownloadModel model = new WeCloudStorageDownloadModel(1346334324072415234L, 1331421226355433473L);
        final WeCloudStorageDownloadFileRequest request = new WeCloudStorageDownloadFileRequest();
        request.setParam(model);
        // 执行请求
        final WeCloudStorageDownloadResponse response = client.execute(request);
        System.out.println(response);
    }

}
