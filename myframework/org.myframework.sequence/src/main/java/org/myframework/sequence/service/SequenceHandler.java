/**
 * Project Name:org.myframework.sequence <br>
 * File Name:SequenceHandler.java <br>
 * Package Name:org.myframework.sequence.service <br>
 * @author xiezbmf
 * Date:2017年7月4日上午10:18:25 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.sequence.service;
/**
 * ClassName: SequenceHandler <br>
 * Description: 序列号处理接口
 * @author xiezbmf
 * @Date 2017年7月4日上午10:18:25 <br>
 * @version
 * @since JDK 1.6
 */
public interface SequenceHandler {
	
	/**
	 * 
	 * nextId:获取下一个序列号. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午10:22:03 <br>
	 * @param seqName 序列号名称
	 * @return long 序列号，获取失败时，返回-1
	 */
	long nextId(String seqName);
	
	/**
	 * 
	 * nextIds:批量获取序列号.<br>
	 * 如获取 nextIds(seq,2).返回1时，则1,2可用 .<br>
	 * 即序列号取值范围为[val,val+count-1].
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午10:28:20 <br>
	 * @param seqName 序列号名称
	 * @param num 序列号个数 
	 * @return long 序列号起始值,获取失败时,返回-1
	 */
	long nextIds(String seqName,int num);
}

	