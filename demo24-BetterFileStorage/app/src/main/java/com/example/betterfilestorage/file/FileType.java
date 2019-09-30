package com.example.betterfilestorage.file;

public enum FileType {
    /**
     * 文件类型
     */
    MP3("mp3"),
    SRT("srt"),
    PCM("pcm");

    private String type;

    FileType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
