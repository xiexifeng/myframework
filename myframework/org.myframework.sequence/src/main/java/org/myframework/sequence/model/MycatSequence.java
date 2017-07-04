/**
 * Project Name:org.myframework.sequence <br>
 * File Name:MycatSequence.java <br>
 * Package Name:org.myframework.sequence.model <br>
 * @author xiezbmf
 * Date:2017年7月4日上午9:50:32 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.sequence.model;

import org.apache.ibatis.type.Alias;

/**
 * ClassName: MycatSequence <br>
 * Description: MycatSequence
 * @author xiezbmf
 * @Date 2017年7月4日上午9:50:32 <br>
 * @version
 * @since JDK 1.6
 */
@Alias("mycatSequence")
public class MycatSequence {
	/**
	 * name:序列号名称.
	 */
	private String name;
	
	/**
	 * currentValue:当前值.
	 */
	private long currentValue;
	
	/**
	 * increment:增长值.
	 */
	private int increment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(long currentValue) {
		this.currentValue = currentValue;
	}

	public int getIncrement() {
		return increment;
	}

	public void setIncrement(int increment) {
		this.increment = increment;
	}

	@Override
	public String toString() {
		return "MycatSequence [name=" + name + ", currentValue=" + currentValue
				+ ", increment=" + increment + "]";
	}
}

	