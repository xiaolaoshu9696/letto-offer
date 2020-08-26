package letto.offer.JavaIO;

import java.io.File;


/**
 * File 不代表文件本身，而是一个抽象表示
 */


public class testFile {

    public static void main(String[] args) {
        String parentPath = System.getProperty("user.dir");
        String name = "testIO.txt";
        File src = new File(parentPath,name);
//        src = new File(new File(parentPath),name);
        //文件或目录名称
        System.out.println(src.getName());
        //将此抽象路径名转换为一个路径名字符串。
        System.out.println(src.getPath());

        src = new File(name);
        //绝对路径
        System.out.println(src.getAbsolutePath());
        System.out.println(src.getParent()); //可能为空，相对路径时为空

        //判断信息
        System.out.println("文件是否存在: " + src.exists());
        //canWrite ,canRead 是否可读可写
        System.out.println(src.canRead());
        //isFile, isDirectory

        System.out.println(src.isDirectory());
        //文件夹默认4096字节
        System.out.println(src.length());


        //creatNewFile() 不存在时 创建新文件 存在返回false
        //delete() 删除文件
        //createTempFile() 创建临时文件，程序退出即删除。

    }

}
