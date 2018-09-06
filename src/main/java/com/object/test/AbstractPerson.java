package com.object.test;

/**
 * 有一个抽象方法的类，一定是抽象类
 * 抽象类必须被子类继承，子类必须重新抽象类中的全部抽象方法
 * 抽象类不能直接被实例化，只能被子类继承
 * 抽象类类似模板，模板设计模式
 * @author jack
 * @date 2018年9月6日 下午9:10:44
 */
public abstract class AbstractPerson {
	//抽象方法，只声明不实现
	abstract void eat();
}
