package com.example.filemanagement;

/**
 * @author Alliance
 */
public enum MyErrorMessage {
    // 文件错误
    FILE_EXIST("100","文件已存在"),
    FILE_NAME_NOT_RIGHT("101","文件名路径不正确"),
    FILE_NOT_EXIST("102","找不到文件"),
    FILE_IN_UES("103","文件正在使用中"),
    CREATE_FILE_FAILED("104","创建文件失败"),


    // 文件夹错误
    DIR_EXIST("200","文件夹已存在"),
    DIR_NOT_EXIST("201","找不到文件夹"),
    DIR_NAME_NOT_RIGHT("202","文件夹路径不正确"),
    DIR_IS_EMPTY("203","文件夹为空"),
    CREATE_DIR_FAILED("204","创建文件夹失败"),


    // 其它错误
    STORAGE_NOT_ENOUGH("300","存储空间不足"),
    UNKNOWN_ERROR("500","未知错误");

    private final String code;
    private final String message;

    MyErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
