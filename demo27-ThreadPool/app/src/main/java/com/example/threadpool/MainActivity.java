package com.example.threadpool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 6; i++) {
			executor.submit(new Task("" + i));
		}
		
		executor.submit(()->{
		
		});
		
		executor.shutdown();
		
	}
	
	
	static class Task implements Runnable {
		private final String name;
		
		public Task(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			System.out.println("start task " + name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end task " + name);
		}
	}
}