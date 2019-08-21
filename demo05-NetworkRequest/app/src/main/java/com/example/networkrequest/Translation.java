package com.example.networkrequest;

import java.util.ArrayList;
import java.util.List;

public class Translation {
    private String code;
    private String message;
    private List<Content> result;

    public class Content {
        private String name;
        private String age;
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Content> getList() {
        return result;
    }

    public void setList(List<Content> list) {
        this.result = list;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
