package test.Thread;

/**
 * 实现线程的两种方法,第一种 创建Thread的子类
 * @date 2018-08-24
 * @author Administrator
 * @param args
 */
class MyThread extends Thread{
	Integer count=0;
	
	@Override
	public void run(){
		System.out.println("MyThread runing!");
	}
	

	public void getCount(){
		count++;
		System.out.println(count);
	}
	
}

/**
 * 实现线程的两种方法,第二种 实现Runnable接口
 * @date 2018-08-24
 * @author Administrator
 * @param args
 */
class MyRunnable implements Runnable{
	public void run(){
		System.out.println("MyRunnable running!");
	}
}

/**
 * 常见错误：调用run()方法而非start()方法
 * 想要让创建的新线程执行run()方法，必须调用新线程的start方法
 * @author Administrator
 *
 */

public class TestThread {


	public static void main(String[] args) {
		
		
		
		MyThread myThread=new MyThread();
		myThread.start();
		myThread.getCount();
		
		Thread myRunnable=new Thread(new MyRunnable());
		myRunnable.start();

	}

}
