package com.object.test;

import com.object.test.PersonDanli.Innter;

/**
 *  info:单例设计模式，只有一个实例
 *  
 * @author jack
 * @date 2018年9月5日 下午8:47:00
 */
class PersonDanli {
	/**
	 * static声明 全局属性
	 *  若属性固定，建议设置为静态属性，这样节省JVM内存
	 *  静态属性存储在全局数据区，只存储一份
	 *  全局数据区一般存储static属性和常量，不释放
	 */
	//先按顺序声明静态属性，所以先输出了‘构造块！实例化n次构造快执行n次’
	private static PersonDanli person = new PersonDanli();
	private static String country = "beijing";
	private String name="zhangsan";
	private static int count;
	{
		System.out.println("构造块！实例化n次构造快执行n次");
	}
	static {
		System.out.println("静态代码块！，只执行一次");
	}
	private PersonDanli() {
		System.out.println("无参构造方法！");
		count++;
	}
	public PersonDanli(String name) {
		//调用本类的构造方法
		this();
		//代码中建议使用this关键字
		this.name=name;
		System.out.println("有参构造方法！");
	}
	

	public static PersonDanli getPersonInstance() {
		return person;
	}

	public void say() {
		System.out.println("country=" + country + "  实例次数：" + count);
	}
	
	/**
	 * static声明的方法成为类方法，可以由类名直接调用
	 * @return 
	 */
	public static String getCountry() {
		return country;
	}
	public static void setCountry(String country) {
		PersonDanli.country = country;
	}
	/**
	 * 内部类
	 * @author 83889
	 * @date 2018年9月5日 下午9:34:59
	 */
	class Innter{
		public void talk() {
			String str="内部类！";
			System.out.println(str+name);
		}
	}
	

}
/**
 * 实现单例模式
 * @author jack
 * @date 2018年9月5日 下午9:50:14
 */
public class DanLi {
	public static void main(String[] args) {
		PersonDanli person1 = PersonDanli.getPersonInstance();
		person1.say();
		PersonDanli person2 = PersonDanli.getPersonInstance();
		person2.say();
		System.out.println(PersonDanli.getCountry());
		
		//内部类访问格式
		PersonDanli person3=new PersonDanli("lisi");
		PersonDanli.Innter in=person3.new Innter();
		in.talk();
	}
}
