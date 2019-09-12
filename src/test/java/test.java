import com.alibaba.fastjson.JSON;
import com.itcast.bean.Info;
import com.itcast.fileUtils.FileToolkit;
import com.itcast.filter.FlvFilter;
import com.itcast.filter.InfoFilter;
import org.apache.commons.io.FileUtils;
import sun.nio.cs.UTF_32LE_BOM;

import java.io.File;
import java.io.FileFilter;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: TheFei
 * @Date: 2019-09-10
 * @Time: 22:23
 */
public class test
{
    public static void main(String[] args) throws Exception
    {
        /*Scanner scanner = new Scanner(System.in);
        String pathName = scanner.nextLine();*/
        Info info = new Info();
        Format f1 = new DecimalFormat("000");
        String pathName ="D:\\B站下载\\43532833";
        File rootDirectory= new File(pathName);
        List<File> flvFiles = FileToolkit.getFileFromDirectory(rootDirectory,new FlvFilter());//所有的视频文件flv格式的
        for (File flvFile : flvFiles)
        {
            System.out.println("之前"+flvFile);
            File directory = flvFile.getParentFile();//视频文件上层目录
            List<File> InfoFiles = FileToolkit.getFileFromDirectory(directory, new InfoFilter());
            String infoString = FileUtils.readFileToString(InfoFiles.get(0),"UTF-8");
            info = JSON.parseObject(infoString, Info.class);
            FileToolkit.renameFile(flvFile.getPath(),f1.format( Integer.valueOf(info.getPartNo()))+" "+info.getPartName()+".flv");//重命名
        }


        String s = rootDirectory.getParent() +"\\"+info.getTitle();
        File afterDirectory = new File(s);
        boolean mkdir = afterDirectory.mkdir();

        flvFiles = FileToolkit.getFileFromDirectory(rootDirectory,new FlvFilter());//所有的视频文件flv格式的
        for (File flvFile : flvFiles)
        {
            System.out.println("之后"+flvFile);
            FileToolkit.moveFile(flvFile.getPath(),s);
            System.out.println("正在移动"+flvFile.getName());
        }
        FileToolkit.deleteFile(rootDirectory.getPath());




    }

}
