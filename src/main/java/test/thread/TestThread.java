package test.thread;

/**
 * 实现线程的两种方法,第一种 创建Thread的子类
 * @date 2018-08-24
 * @author Administrator
 * @param args
 */
class MyThread extends Thread{

	@Override
	public void run(){
		System.out.println("MyThread runing!");
	}
	

}

/**
 * 实现线程的两种方法,第二种 实现Runnable接口
 * @date 2018-08-24
 * @author Administrator
 * @param args
 */
class MyRunnable implements Runnable{
	private String inputchar;
	private int times;
	
	MyRunnable(String inputchar,int times){
		this.inputchar=inputchar;
		this.times=times;
	}
	
	public void run(){
		for(int i=0;i<times;i++)
		System.out.print(inputchar);
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
		
		Thread myRunnable1=new Thread(new MyRunnable("a",10));
		Thread myRunnable2=new Thread(new MyRunnable("b",10));
		Thread myRunnable3=new Thread(new MyRunnable("c",10));
		myRunnable1.start();
		myRunnable2.start();
		myRunnable3.start();

	}

}
