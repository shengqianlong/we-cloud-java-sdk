import org.apache.commons.io.FileUtils;
import org.apache.tika.Tika;
import org.apache.tika.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 陈俊雄
 * @since 2020/10/20
 **/
public class MimeTypeTest {
    @Test
    public void mimeTypeTest() throws IOException {
        final File file = new File("C:\\Users\\Kevin\\Desktop\\index.html");
        final byte[] bytes = FileUtils.readFileToByteArray(file);
        final Tika tika = new Tika();
        System.out.println(tika.detect(bytes));
    }
}
