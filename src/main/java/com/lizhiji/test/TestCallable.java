package com.lizhiji.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


public class TestCallable {
	
	public static void main(String[] args) throws Exception {
		Callable<Integer> callable = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				
				return 503;
			}
		};
		
		Integer call = callable.call();
		System.out.println(call);
		System.out.println("---------------------------------");
		
//		1.0
//		new Thread(new FutureTask<>(new Callable<Integer>() {
//			@Override
//			public Integer call() throws Exception {
//				System.out.println("网关超时");
//				return 504;
//			}
//		})).start();
		
//		1.1
		FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				for (int i = 0; i < 10; i++) {
					System.out.println("服务器停机");
				}
				return 503;
			}
		});
		new Thread(task,"AA").start();
		System.out.println(task.get());
		
		for (int i = 0; i < 10; i++) {
			System.out.println("XXX");
		}
		
		
		
	}
}
