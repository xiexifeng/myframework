/**
 * Project Name:org.myframework.common <br>
 * File Name:SerializableTest.java <br>
 * Package Name:org.myframework.common <br>
 * @author xiezbmf
 * Date:2017年7月6日上午11:52:30 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common;

import org.junit.Test;
import org.myframework.common.util.SerializableUtil;

/**
 * ClassName: SerializableTest <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月6日上午11:52:30 <br>
 * @version
 * @since JDK 1.6
 */
public class SerializableTest {
	@Test
	public void testSerialize(){
		SerializableObj1 t = new SerializableObj1();
		t.setAge("12");
		t.setMoney("32424");
		t.setName("ai");
		System.out.println(t);
		byte[] bytes = SerializableUtil.serialize(t);
		System.out.println(SerializableUtil.deserialize(bytes));
	}
}

	