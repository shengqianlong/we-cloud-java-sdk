package cn.wecloud.sdk.storage.request;


import cn.wecloud.sdk.common.FileItem;
import cn.wecloud.sdk.common.api.WeCloudRequest;
import cn.wecloud.sdk.common.api.WeCloudResponse;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈俊雄
 * @since 2020/10/20
 **/
@Data
public abstract class WeCloudStorageUploadRequest<T extends WeCloudResponse> implements WeCloudRequest<T> {

    private FileItem fileItem;

    Map<String, FileItem> getFileParams() {
        final HashMap<String, FileItem> fileParams = new HashMap<>();
        fileParams.put("file", this.fileItem);
        return fileParams;
    }
}
