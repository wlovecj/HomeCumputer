package com.object.test;

/**
 * 定义接口
 * 一个子类一次可以实现多个接口，这样可以摆脱类的单继承
 * @author jack
 * @date 2018年9月6日 下午9:22:56
 */
public interface IPerson {
	//接口中只能定义全局常量
	public static final String str="haha";
	
	public abstract void printA();
	//不写public abstract也代表 是抽象方法
	void printB();
}

interface  IStudent{
	public abstract void printC();
}