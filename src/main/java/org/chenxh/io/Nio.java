package org.chenxh.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//http://www.importnew.com/22623.html
//nio 更多用来用于客户端与服务端的使用
public class Nio {

    private void fileNio() throws Exception{
        File inputFile = new File("");
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        File outFile = new File("");
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (fileChannel.read(byteBuffer)!=-1){

        }
    }

}
