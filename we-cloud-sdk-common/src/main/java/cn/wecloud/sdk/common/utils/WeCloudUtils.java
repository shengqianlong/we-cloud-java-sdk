package cn.wecloud.sdk.common.utils;

import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;

/**
 * @author 陈俊雄
 * @since 2020/10/20
 **/
public abstract class WeCloudUtils {

    public static final Tika TIKA = new Tika();

    public static String getMimeType(File file) throws IOException {
        return TIKA.detect(file);
    }

    public static String getMimeType(byte[] bytes) {
        return TIKA.detect(bytes);
    }
}
