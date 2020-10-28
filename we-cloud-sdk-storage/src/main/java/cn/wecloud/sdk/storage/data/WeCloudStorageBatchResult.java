package cn.wecloud.sdk.storage.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author 陈俊雄
 * @since 2020/10/23
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WeCloudStorageBatchResult implements Serializable {

    private List<WeCloudStorageUserFileInfo> success;

    private List<WeCloudStorageUserFileInfo> fails;

}
