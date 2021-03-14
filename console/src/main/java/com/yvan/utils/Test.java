package com.yvan.utils;

import com.sun.tools.javac.util.ByteBuffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author v_yangfeng01
 * @date 2021/3/10
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String path = "/Users/v_yangfeng01/Downloads/皮卡丘简约4K壁纸_彼岸图网.jpg";
        File file1 = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file1);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        byte[] by = new byte[fileInputStream.available()];
        fileInputStream.read(by);
        ByteBuffer byteBuffer = new ByteBuffer();
        byteBuffer.appendBytes(by);
        String fileString = byteBuffer.toString();

        String path1 = "/Users/v_yangfeng01/Downloads/皮卡丘简约4K壁纸_彼岸图网1.jpg";
        File file = new File(path1);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bytes = fileString.getBytes();
        fileOutputStream.write(bytes);
        fileOutputStream.close();

    }
}
