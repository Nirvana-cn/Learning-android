package com.example.filestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit);
        button = findViewById(R.id.bt);

        String history = load();

        /**判断文件是否为空*/
        if(!TextUtils.isEmpty(history)){
            editText.setText(history);
            editText.setSelection(history.length());
            Toast.makeText(this, "Restoring succeeded", Toast.LENGTH_SHORT).show();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveFile(editText.getText().toString());
            }
        });

        // 读取本地图片，然后保存
        File imageFile = new File(this.getFilesDir(), "dota.png");
        Bitmap bitmap = ReadImage.load(imageFile);
        File imageTest = new File(this.getFilesDir(),"test.jpg");
        boolean imageResult = ReadImage.save(imageTest, bitmap);
        Log.d("test",String.valueOf(imageResult));

        // 读取本地音频，然后保存
        File musicFile = new File(this.getFilesDir(),"music.mp3");
        File musicTest = new File(this.getFilesDir(),"test.mp3");
        boolean musicResult = ReadAudio.copy(musicFile, musicTest);
        Log.d("test",String.valueOf(musicResult));

        // 遍历目录
        String root = this.getFilesDir().toString();
        File dir = new File(root);
        TraverseCatalog.visitAllDirsAndFiles(dir);


        // android获取不同的路径，不要指定绝对路径
        Log.d("test",this.getFilesDir().toString());
        Log.d("test",Environment.getExternalStorageState());
        Log.d("test",Environment.getExternalStorageDirectory().toString());
        Log.d("test",Environment.getDataDirectory().toString());
        Log.d("test",Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString());
        Log.d("test",Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).toString());
    }

    /**读取本地存储*/
    public String load(){
        FileInputStream inputStream;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try{
            inputStream = openFileInput("data.txt");
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null){
                content.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }

    /**写入本地存储*/
    public void  saveFile(String string){
        FileOutputStream outputStream;
        BufferedWriter writer = null;
        try{
            outputStream = openFileOutput("data.txt", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(string);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            Log.d("test","写入成功");
            try{
                if(writer != null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
