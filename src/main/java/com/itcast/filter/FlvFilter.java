package com.itcast.filter;

import java.io.File;
import java.io.FileFilter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: TheFei
 * @Date: 2019-09-10
 * @Time: 22:41
 */
public class FlvFilter implements FileFilter
{

    @Override
    public boolean accept(File pathname)
    {
        if (pathname.isDirectory())
        {
            return true;
        }
        return pathname.getName().toLowerCase().endsWith(".flv");
    }
}
