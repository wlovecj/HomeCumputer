package com.object.test;
/**
 * 面向对象练习demo1 
 * 类：客观世界的某类群体，广义的概念
 * 对象：类中的具体事物,有属性和方法
 * 面向对象特性：封装/继承/多态
 * 类名和类文件名称一致
 * @author jack
 * @date 2018年9月4日 下午9:07:08
 */
class Person{
	//static String color="yellow";
	private String color="yellow";
	private int age;
	/**
	 * 方法1：通过geter和setter方法设置和取到私有属性
	 * @return 将修改后的私有属性color值返回
	 */
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * 方法2：通过构造方法，对类中的私有属性进行初始化
	 * 只有public 和 private 两种权限
	 * 构造方法只是对属性操作，不是方法，所以不需要有return返回值
	 */
	public Person(String color) {
		this.color=color;
	}
	/**
	 * 构造方法的重载
	 * @param color
	 * @param age
	 */
	public Person(String color,int age) {
		this.color=color;
		this.age=age;
	}
	/**
	 * 类中默认有一个构造方法
	 */
	public Person() {}
	
	public void tell(String name,int age) {
		System.out.println("name="+name+"；age="+age+";color="+color);
	}
	
	public String say(String para) {
		String a=para;
		return a;
	}
}
/**
 * 主类
 * @author jack
 * @date 2018年9月4日 下午9:54:46
 */
public class TestObject {
	/**
	 * main方法是主方法 主方法所在的类叫主类  所有代码启动的入口且只能有一个入口
	 * @param args
	 */
	public static void main(String[] args) {
		//类实例化就是对象
		Person zhangsan=new Person();
		//类中的属性不能被随意修改--引入封装特性
		//zhangsan.color="white";
		zhangsan.setColor("white");
		zhangsan.tell("zhangsan", 23);
		
		Person lisi=new Person();
		lisi.tell("lisi", 20);
		
		Person wangwu=new Person("red");
		wangwu.tell("wangwu",33);
		
		Person jackma=new Person("black",11);
		jackma.tell("jackma",33);
		
		//封装属性和方法，对外不可见
		String content=zhangsan.say("haha！");
		System.out.println(content);
	}

}
