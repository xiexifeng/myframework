/**
 * Project Name:org.myframework.common <br>
 * File Name:SerializableObj.java <br>
 * Package Name:org.myframework.common <br>
 * @author xiezbmf
 * Date:2017年7月6日上午11:53:23 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ClassName: SerializableObj <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月6日上午11:53:23 <br>
 * @version
 * @since JDK 1.6
 */
public class SerializableObj1 extends SerializableObj{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 2636939360430590651L;
	private String name ;
	private String age;
	private transient String money;
	private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "SerializableObj [name=" + name + ", age=" + age + ", money=" + money + "]";
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException { 
		out.defaultWriteObject();  //序列化所有非transient字段,必须是该方法的第一个操作 
		out.writeObject(money); //序列化transient字段 
	} 

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException { 
		in.defaultReadObject();             //反序列化所有非transient字段,必须是该方法的第一个操作 
		money = (String)in.readObject(); //反序列化transient字段 
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	} 
	
}

	