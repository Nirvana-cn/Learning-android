package com.example.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class UserViewModel extends BaseObservable {
    private String name;
    private String age;

    public UserViewModel(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    public static void update() {
        MainActivity.userViewModel.setName("aaa");
        MainActivity.userViewModel.setAge("100");
    }
}
