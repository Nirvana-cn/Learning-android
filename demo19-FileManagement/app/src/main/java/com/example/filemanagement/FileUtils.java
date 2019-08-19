package com.example.filemanagement;

import android.app.Application;
import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class FileUtils extends Application {

    private static String fileType = ".txt";

    public static File createFilePath(Context context, long programId, Integer partId) {
        String filePath = context.getFilesDir() + "/" + programId + "/" + partId + fileType;
        File file = new File(filePath);

        // 判断文件是否存在
        if (file.exists()) {
            // 抛出文件已存在的异常
            FileException.handleException(MyErrorMessage.FILE_EXIST);
        }
        // 判断文件路径是否以文件夹结束
        if (filePath.endsWith(File.separator)) {
            FileException.handleException(MyErrorMessage.FILE_NAME_NOT_RIGHT);
        }

        // 判断父目录是否存在
        if (!file.getParentFile().exists()) {
            // 父目录不存在 创建父目录
            if (!file.getParentFile().mkdirs()) {
                FileException.handleException(MyErrorMessage.CREATE_DIR_FAILED);
            }
        }

        // 创建文件
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            FileException.handleException(MyErrorMessage.CREATE_FILE_FAILED);
        }
        return file;
    }

    public static ArrayList<File> getFilePath(Context context, long programId) {
        ArrayList arrayList = new ArrayList();
        String filePath = context.getFilesDir() + "/" + programId;
        File file = new File(filePath);
        if (file.isDirectory()) {
            String[] children = file.list();
            for (int i = 0; i < children.length; i++) {
                File cFile = new File(file, children[i]);
                String path = cFile.getPath();
                arrayList.add(path);
            }
        } else {
            FileException.handleException(MyErrorMessage.DIR_NAME_NOT_RIGHT);
        }

        if (arrayList.size() == 0) {
            FileException.handleException(MyErrorMessage.DIR_IS_EMPTY);
        }

        return arrayList;
    }

    public static File getFilePath(Context context, long programId, Integer partId) {
        String filePath = context.getFilesDir() + "/" + programId + "/" + partId + fileType;
        File file = new File(filePath);

        if (!file.exists()) {
            FileException.handleException(MyErrorMessage.FILE_NOT_EXIST);
        }
        return file;
    }

    public static boolean deleteFile(Context context, long programId, Integer partId) {
        String filePath = context.getFilesDir() + "/" + programId + "/" + partId + fileType;
        File file = new File(filePath);
        if (file.isFile()) {
            file.delete();
        } else {
            FileException.handleException(MyErrorMessage.FILE_NOT_EXIST);
        }
        return true;
    }

    public static boolean deleteFile(Context context, long programId) {
        String filePath = context.getFilesDir() + "/" + programId;
        File file = new File(filePath);
        if (file.isDirectory()) {
            String[] children = file.list();
            for (int i = 0; i < children.length; i++) {
                new File(file, children[i]).delete();
            }
        } else {
            FileException.handleException(MyErrorMessage.DIR_NAME_NOT_RIGHT);
        }
        return true;
    }

    public Boolean selectFilePath(Context context, long programId, Integer partId) {
        String filePath = context.getFilesDir() + "/" + programId + "/" + partId + fileType;
        File file = new File(filePath);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }
}
