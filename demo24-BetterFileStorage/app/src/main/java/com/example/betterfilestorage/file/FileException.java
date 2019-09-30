package com.example.betterfilestorage.file;

/**
 * @author Alliance
 * @description 自定义文件异常
 */
public class FileException extends RuntimeException {

    private ErrorMessage errorMessage;
    private Exception exception = new Exception();

    /**
     * @param errorMessage FileException中自定义的文件操作异常
     * @description 构造函数
     */
    public FileException(ErrorMessage errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    /**
     * 获取抛出的异常
     */
    public Exception getException() {
        return exception;
    }

    /**
     * 设置抛出的异常
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }

    /**
     * 获取自定义异常信息
     */
    @Override
    public String getMessage() {
        return errorMessage.toString();
    }

    /**
     * 设置自定义异常信息
     */
    public void setMessage(ErrorMessage message) {
        this.errorMessage = message;
    }

    /**
     * @param errorMessage FileException中自定义的文件操作异常
     * @description 对异常进行抛出的静态方法
     */
    public static void handleException(ErrorMessage errorMessage) throws RuntimeException {
        throw new FileException(errorMessage);
    }

    @Override
    public String toString() {
        return errorMessage.toString();
    }
}
