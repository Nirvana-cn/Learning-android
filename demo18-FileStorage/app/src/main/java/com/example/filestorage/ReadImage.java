package com.example.filestorage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**@author 111
 *
 * */

public class ReadImage {


    /**读取本地存储*/
    public static Bitmap load(File file){
        FileInputStream inputStream;
        Bitmap bitmap = null;
        try{
            inputStream = new FileInputStream(file);
            bitmap = BitmapFactory.decodeStream(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }

        return bitmap;

    }

    /**写入本地存储*/
    public static boolean save(File file, Bitmap bitmap){
        try{
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
