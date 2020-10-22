package cn.wecloud.sdk;

import cn.wecloud.sdk.common.FileItem;
import cn.wecloud.sdk.common.exception.WeCloudApiException;
import cn.wecloud.sdk.storage.client.WeCloudStorageClient;
import cn.wecloud.sdk.storage.model.WeCloudUploadFileModel;
import cn.wecloud.sdk.storage.request.WeCloudStorageUploadFileRequest;
import cn.wecloud.sdk.storage.response.WeCloudStorageUploadFileResponse;
import org.junit.Test;

import java.util.Map;

/**
 * @author 陈俊雄
 * @since 2020/10/22
 **/
public class StorageTest {
    @Test
    public void uploadFile() throws WeCloudApiException {
        final WeCloudStorageClient client = new WeCloudStorageClient("vWQfmkeCTx", "ZT2NFpnyiio0", 1318443637411033089L);
        final FileItem fileItem = new FileItem("C:\\Users\\Kevin\\Pictures\\Saved Pictures\\hello.jpg");
        final WeCloudStorageUploadFileRequest request = new WeCloudStorageUploadFileRequest(fileItem);
        final WeCloudUploadFileModel model = new WeCloudUploadFileModel();
        request.setParam(model);
        final WeCloudStorageUploadFileResponse response = client.execute(request);
        final Map<String, String> params = response.getParams();
    }
}
