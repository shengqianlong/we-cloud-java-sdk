package cn.wecloud.sdk;

import cn.wecloud.sdk.common.FileItem;
import cn.wecloud.sdk.common.exception.WeCloudApiException;
import cn.wecloud.sdk.storage.client.WeCloudStorageClient;
import cn.wecloud.sdk.storage.data.WeCloudStorageUserFileInfo;
import cn.wecloud.sdk.storage.model.WeCloudStorageUploadFileModel;
import cn.wecloud.sdk.storage.request.WeCloudStorageUploadFileRequest;
import cn.wecloud.sdk.storage.response.WeCloudStorageUploadFileResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author 陈俊雄
 * @since 2020/10/22
 **/
@Slf4j
public class StorageTest {
    @Test
    public void uploadFile() throws WeCloudApiException {
        final WeCloudStorageClient client = new WeCloudStorageClient("vWQfmkeCTx", "ZT2NFpnyiio0", 1318443637411033089L);
        final FileItem fileItem = new FileItem("C:\\Users\\Kevin\\Pictures\\Saved Pictures\\hello.jpg");
        final WeCloudStorageUploadFileModel model = new WeCloudStorageUploadFileModel();
        final WeCloudStorageUploadFileRequest request = new WeCloudStorageUploadFileRequest(fileItem);
        request.setParam(model);
        final WeCloudStorageUploadFileResponse response = client.execute(request);
        if (response.isSuccess()) {
            final WeCloudStorageUserFileInfo responseData = response.getData();
            System.out.println(responseData);
        } else {
            log.error(response.getMsg());
        }
    }

}
