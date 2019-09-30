package com.example.betterfilestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Environment;

import com.example.betterfilestorage.file.FileType;
import com.example.betterfilestorage.file.FileUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file = FileUtils.createNewFile(333, "test", FileType.MP3, false);

//        try {
//            Process p = Runtime.getRuntime().exec("chmod 771 " + file);
//            int status = p.waitFor();
//            if (status == 0) {
//                System.out.println(11111);
//            } else {
//                System.out.println(22222);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        FileUtils.emptyDir(333,false, FileType.MP3);
//            List<File> files = FileUtils.getGivenTypeFiles(333,FileType.MP3);
//            for(File f: files){
//                System.out.println(f.getName());
//                System.out.println(f.getAbsolutePath());
//            }

//        final ProgressDialog pending = ProgressDialog.show(this, "提示", "生成作品中...");
//
//        new Timer().schedule(new TimerTask() {
//
//            @Override
//            public void run() {
//                pending.cancel();
//
//            }
//        }, 3000);


//        String string = Environment.getExternalStorageState();
//        System.out.println(string);
//        System.out.println(Environment.getDataDirectory());
//
//        System.out.println(MyApplication.getContext().getExternalCacheDir());
//        System.out.println(MyApplication.getContext().getExternalFilesDir(""));
//
//        System.out.println(MyApplication.getContext().getFilesDir());
//        System.out.println(MyApplication.getContext().getCacheDir());
    }
}
