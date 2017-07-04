/**
 * Project Name:org.myframework.sequence <br>
 * File Name:SequenceDetail.java <br>
 * Package Name:org.myframework.sequence.model <br>
 * @author xiezbmf
 * Date:2017年7月4日上午9:31:38 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.sequence.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * ClassName: SequenceDetail <br>
 * Description: 序列号详细设置明细实体类
 * @author xiezbmf
 * @Date 2017年7月4日上午9:31:38 <br>
 * @version
 * @since JDK 1.6
 */
@Alias("sequenceDetail")
public class SequenceDetail {

	/**
	 * name:序列号名称.
	 */
	private String name;
	
	/**
	 * prefixNo:序列号前缀.
	 */
	private String prefixNo;
	
	/**
	 * seqLength:序列号长度.
	 */
	private int seqLength;
	
	/**
	 * seqDesc:序列号描述.
	 */
	private String seqDesc;
	
	private Date createTime;
	
	private Date updateTime;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefixNo() {
		return prefixNo;
	}

	public void setPrefixNo(String prefixNo) {
		this.prefixNo = prefixNo;
	}

	public int getSeqLength() {
		return seqLength;
	}

	public void setSeqLength(int seqLength) {
		this.seqLength = seqLength;
	}

	public String getSeqDesc() {
		return seqDesc;
	}

	public void setSeqDesc(String seqDesc) {
		this.seqDesc = seqDesc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		return "SequenceDetail [name=" + name + ", prefixNo=" + prefixNo
				+ ", seqLength=" + seqLength + ", seqDesc=" + seqDesc + "]";
	}
}

	