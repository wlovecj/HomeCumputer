package com.expression;
/**
 * 运算符/表达式/语句
 * 1.赋值运算符 =
 * 2.一元运算符 + - ！
 * 3.算数运算符 + - * / %(取余数)
 * 4.关系运算符 < <= > >= == !=
 * 5.自增自减运算符 ++  --
 * 6.逻辑运算符 
 *   &（and，与）  &&（短路与） 第一个条件不满足，则后面的条件不再判断  & 判断所有条件
 *   |（or，或）  || （短路或） 第一个条件为true，则后面的条件不再判断  | 判断所有条件
 * 7.括号运算符 （）
 *  
 * 8、表达式运算符 +=、-=、。。。%=
 * @author jack
 * @date 2018年9月7日 下午8:39:01
 */

class YunSun{
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int operator(int a,int b) {
		return a+b;
	}
	
	//+特点 同类类型相加，非同类型就拼接
	public String operator(int a,String b) {
		return a+b;
	}
	
	
	
}

public class Expression {

	public static void main(String[] args) {
		YunSun ys=new YunSun();
		System.out.println(ys.operator(1, 2));
		//案例1 c++ 先将c的值赋值给d，然后再执行c=c+1；
		//     ++c 先执行c=c+2，再将c的值赋值给e
		int c=3;
		int d=c++;
		System.out.println("案例1：d="+d+" c="+c);
		int e=++c;
		System.out.println("案例1：e="+e+" c="+c);
		
		//案例2  c--  自减原理相同
		int f=c--;
		System.out.println("案例2：f="+f+" c="+c);
		
		//案例3 逻辑运算符
		boolean ba=true;
		boolean bb=false;
		System.out.println("ba || bb "+(ba||bb));
		System.out.println("ba && bb "+(ba&&bb));
		
		System.out.println("ba | bb "+(ba|bb));
		System.out.println("ba & bb "+(ba&bb));
		
		//案例4 &&系统没有判断后面的条件，改为&系统会验证，执行会报错
		//Eclipse 当比较两个相同的值时，会给出警告，可以设置
		int num1=10;
		if(10!=num1 && 10/0==0) {
			System.out.println("条件满足！");
		}else{
			System.out.println("条件不满足！");
		}
		
		//案例5 
		int num2=10;
		int num3=1;
		num3*=num2++;
		System.out.println(num3);
		num3*=++num2;
		System.out.println(num3);
		
	}

}
