package org.chenxh.io;

import java.io.*;

public class IO {
    public void inputStream() throws Exception{
        //字节流，可以处理任何类型的文件
        File file = new File("C:/123.jpg");
        InputStream  fileInputStream = new FileInputStream(file);
        File outFile = new File("D:/456.jpg");
        OutputStream outputStream = new FileOutputStream(outFile);
        try{
            byte[] bytes = new byte[1024];
         /*   fileInputStream.read(bytes);
            outputStream.write(bytes);*/
            while (fileInputStream.read(bytes)!=-1){
                outputStream.write(bytes);
            }
        }catch (Exception e){

        }finally {
            fileInputStream.close();
            outputStream.close();
        }

    }

    public void Reader() throws Exception{
        //字符流，只能处理字符类的文件
        File inpuFile = new File("C:/123.jpg");
        //Reader reader = new FileReader(inpuFile);
        BufferedReader reader =new BufferedReader(new InputStreamReader(new FileInputStream(inpuFile)));
        File outFile = new File("D:/123.jpg");
        Writer writer = new FileWriter(outFile);

      /*  String start = reader.readLine();
        String second = reader.readLine();
        writer.write(start);
        writer.write(second);*/
        String line = null;
        while((line = reader.readLine())!=null){
            writer.write(line+"\n");
        }
        reader.close();
        writer.close();
    }

    public static void main(String[] args) throws Exception{
        IO io = new IO();
        io.Reader();
    }

}
