import com.itcast.fileUtils.FileToolkit;
import org.junit.Test;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: TheFei
 * @Date: 2019-09-10
 * @Time: 23:43
 */
public class cx {
    @Test
    public void test()
    {
        File file = new File("D:\\ok\\haha");
        FileToolkit.renameFile(file.getPath(),"Javaweb.7z");
    }
}
