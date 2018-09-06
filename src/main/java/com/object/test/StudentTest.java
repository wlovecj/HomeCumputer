package com.object.test;
/**
 * 父类
 * @author jack
 * @date 2018年9月6日 下午8:46:34
 */

class RenLei extends AbstractPerson{
	private int age;
	private String name;

	public RenLei() {
		System.out.println("父类的构造方法！");
	}
	
	public RenLei(int age,String name) {
		this.age=age;
		this.name=name;
		System.out.println("父类有参的构造方法！");
	}
	
	public void say() {
		System.out.println("父类普通方法！");
	}
	
	public void talk() {
		System.out.println("父类中未被重新的方法！");
	}
	
	protected void run() {
		System.out.println("受保护的方法！");
	}
	
	public final void walk() {
		System.out.println("final类不能被子类复写！");
	}
	
	public void eat() {
		System.out.println("重写抽象类中的抽象方法！");
	}
	
}
/**
 * 子类
 * @author jack
 * @date 2018年9月6日 下午8:46:48
 */
class Student extends RenLei implements IPerson,IStudent{
	private String school="清华";
	public Student() {
		System.out.println("子类的构造方法");
	}
	
	public Student(int age,String name,String school) {
		super(age,name);
		this.setSchool(school);
		System.out.println("子类构造方法，age="+age+"  name="+name+" school="+school);
	}
	
	@Override
	public void say() {
		System.out.println("因为不适合子类的方法，重写父类的普通方法！就近原则");
	}

	public void say(String str) {
		System.out.println("方法重载");
	}
	
	/*
	 * walk方法不能被子类复写
	public void walk() {
		
	}*/
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	//重写接口中的抽象方法
	public void printA() {
		System.out.print("A");
	}
	public void printB() {
		System.out.print("B");
	}
	public void printC() {
		System.out.print("C");
	}
}


/**
 * 主类
 * @author jack
 * @date 2018年9月6日 下午8:47:16
 */
public class StudentTest {

	public static void main(String[] args) {
		Student stu1=new Student(20,"zhangsan","北大");
		stu1.say();
		stu1.talk();
		stu1.run();
		Student stu2=new Student();
		System.out.println(stu2.getSchool());
		stu2.printA();
		stu2.printB();
		//多态 
		//子类向上转型
		AbstractPerson ap=new Student();
		//只能调用被子类复写过的方法
		ap.eat();
		//对象向下转型
		Student s= (Student)ap;
		s.run();
	}

}
