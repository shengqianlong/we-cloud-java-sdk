package cn.wecloud.sdk.common.api;


import cn.wecloud.sdk.common.FileItem;

import java.util.Map;

/**
 * @author 陈俊雄
 * @since 2020/10/20
 **/
public interface WeCloudUploadRequest<T extends WeCloudResponse> extends WeCloudRequest<T> {

    Map<String, FileItem> getFileParams();
}
