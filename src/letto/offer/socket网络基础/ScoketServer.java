package letto.offer.socket网络基础;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ScoketServer {
    public static void main(String[] args) throws IOException {
        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        //server将一直等待连接的到来
        System.out.println("---等待连接---");
        Socket socket = server.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes))!=-1){
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }
        System.out.println("get message" + sb);
        inputStream.close();
        socket.close();
        server.close();

    }

}
