package com.example.betterfilestorage.file;

import android.content.Context;
import android.os.Environment;

import com.example.betterfilestorage.MyApplication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String MOUNTED = "mounted";

    public static File createNewFile(long programId, String fileName, FileType fileType, boolean external) {
        String path = File.separator + programId + File.separator + fileType.toString() + File.separator + fileName + "." + fileType.toString();
        return generateNewFile(path, external, false);
    }

    public static File createNewFile(long programId, FileType fileType, boolean external) {
        String prefix = "record-" + programId;
        String path = File.separator + programId + File.separator + fileType.toString() + File.separator + prefix + "." + fileType;
        return generateNewFile(path, external, false);
    }

    public static File createNewCacheFile(long programId, String fileName, FileType fileType, boolean external) {
        String path = File.separator + programId + File.separator + fileType.toString() + File.separator + fileName + "." + fileType;
        return generateNewFile(path, external, true);
    }

    public static File createNewCacheFile(long programId, FileType fileType, boolean external) {
        String prefix = "record-" + programId;
        String path = File.separator + programId + File.separator + fileType.toString() + File.separator + prefix + "." + fileType;
        return generateNewFile(path, external, true);
    }

    public static File createNewDir(long programId, boolean external) {
        String path = File.separator + programId + File.separator;
        return generateNewDir(path, external, false);
    }

    public static File createNewCacheDir(long programId, boolean external) {
        String path = File.separator + programId;
        return generateNewDir(path, external, true);
    }


    public static void emptyDir(long programId, boolean external) {
        String path = File.separator + programId;
        if (external) {
            path = MyApplication.getContext().getExternalFilesDir("") + path;
        } else {
            path = MyApplication.getContext().getFilesDir() + path;
        }
        deleteAllFiles(new File(path));
    }

    public static void emptyDir(long programId, boolean external, FileType fileType) {
        String path = File.separator + programId + File.separator + fileType;
        if (external) {
            path = MyApplication.getContext().getExternalFilesDir("") + path;
        } else {
            path = MyApplication.getContext().getFilesDir() + path;
        }
        deleteAllFiles(new File(path));
    }


    public static List<File> getGivenTypeFiles(long programId, FileType fileType) {
        String filePath = MyApplication.getContext().getFilesDir() + File.separator + programId + File.separator + fileType;
        File file = new File(filePath);
        return getFiles(file);
    }


    private static File generateNewFile(String path, boolean external, boolean cache) {
        Context context = MyApplication.getContext();

        if (external) {
            if (Environment.getExternalStorageState().equals(MOUNTED)) {
                if (cache) {
                    path = context.getExternalCacheDir() + path;
                } else {
                    path = context.getExternalFilesDir("") + path;
                }
            } else {
                FileException.handleException(ErrorMessage.EXTERNAL_STORAGE_NOT_MOUNTED);
            }

        } else {
            if (cache) {
                path = context.getCacheDir() + path;
            } else {
                path = context.getFilesDir() + path;
            }

        }
        System.out.println(path);
        File file = new File(path);

        /**
         * 判断文件是否存在，若文件已存在则抛出文件已存在的异常
         * */
        if (file.exists()) {
            FileException.handleException(ErrorMessage.FILE_EXIST);
        }

        /**
         * 判断文件路径是否以文件夹结束，若文件路径以文件夹结束则抛出文件名不正确的异常
         * */
        if (file.getAbsolutePath().endsWith(File.separator)) {
            FileException.handleException(ErrorMessage.FILE_NAME_NOT_RIGHT);
        }

        /**
         * 判断父目录是否存在，若父目录不存在则创建父目录，创建父目录失败时抛出异常
         * */
        if (!file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
                FileException.handleException(ErrorMessage.CREATE_DIR_FAILED);
            }
        }

        /**
         * 创建文件
         * */
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            FileException.handleException(ErrorMessage.CREATE_FILE_FAILED);
        }

        return file;
    }

    private static File generateNewDir(String path, boolean external, boolean cache) {
        Context context = MyApplication.getContext();

        if (external) {
            if (Environment.getExternalStorageState().equals(MOUNTED)) {
                if (cache) {
                    path = context.getExternalCacheDir() + path;
                } else {
                    path = context.getExternalFilesDir("") + path;
                }
            } else {
                FileException.handleException(ErrorMessage.EXTERNAL_STORAGE_NOT_MOUNTED);
            }

        } else {
            if (cache) {
                path = context.getCacheDir() + path;
            } else {
                path = context.getFilesDir() + path;
            }
        }
        System.out.println(path);
        File dir = new File(path);
        if (path.endsWith(File.separator)) {
            if (!dir.mkdirs()) {
                FileException.handleException(ErrorMessage.UNKNOWN_ERROR);
            }
        }
        return dir;
    }

    private static boolean deleteExistFile(File file) {
        if (file.isFile()) {
            file.delete();
        } else {
            FileException.handleException(ErrorMessage.FILE_NOT_EXIST);
        }
        return true;
    }

    private static File getExistFile(File file) {
        if (!file.exists()) {
            FileException.handleException(ErrorMessage.FILE_NOT_EXIST);
        }
        return file;
    }

    private static void deleteAllFiles(File root) {
        File[] files = root.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteAllFiles(f);
                } else {
                    if (f.exists()) {
                        try {
                            f.delete();
                        } catch (FileException e) {
                            FileException.handleException(ErrorMessage.UNKNOWN_ERROR);
                        }
                    }
                }
            }
        }
        root.delete();
    }

    private static List<File> getFiles(File file){
        List<File> arrayList = new ArrayList<>();

        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File f : children) {
                    if (f.isFile()) {
                        arrayList.add(f);
                    } else {
                        arrayList.addAll(getFiles(f));
                    }
                }
            }
        } else {
            FileException.handleException(ErrorMessage.DIR_NAME_NOT_RIGHT);
        }

        return arrayList;
    }


}
