package letto.offer.JavaIO;

import java.io.*;

public class testStream {

    public static void main(String[] args) throws IOException {
        write();


    }

    public static void  read() throws IOException {
        File src = new File("testIO.txt");
        InputStream is = new FileInputStream(src);
        //缓冲数组
        byte[] buffer = new byte[10];
        int len = 0; // 接受实际读取的大小
        //循环读取
        while (-1 != (len = is.read(buffer))){
            //输出 字节数组转成字符串
            String info = new String(buffer, 0, len);
            System.out.println(info);
        }
        is.close();
    }

    public static void write() throws IOException{
        File src = new File("testIO.txt");
        OutputStream os = new FileOutputStream(src, true);
        String str  = "233 jlajdf";
        byte[] buffer =  str.getBytes();
        os.write(buffer);
        os.flush();//强制刷新出去
        os.close();
    }


}
