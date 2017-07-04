/**
 * Project Name:org.myframework.sequence <br>
 * File Name:MycatSequenceFuncComponent.java <br>
 * Package Name:org.myframework.sequence.component <br>
 * @author xiezbmf
 * Date:2017年7月4日上午10:50:38 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.sequence.component;


/**
 * ClassName: MycatSequenceFuncComponent <br>
 * Description: 获取序列号组件接口
 * @author xiezbmf
 * @Date 2017年7月4日上午10:50:38 <br>
 * @version
 * @since JDK 1.6
 */
public interface MycatSequenceFuncComponent {
	/**
	 * 
	 * getSeqNextVal:获取下一个序列号. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午10:48:39 <br>
	 * @param seqName 序列号名称
	 * @return
	 */
	long getSeqNextVal(String seqName);
	
	/**
	 * 
	 * getSeqNextVals:获取多个序列号. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午10:49:40 <br>
	 * @param seqName 序列号名称
	 * @param num 个数
	 * @return
	 */
	long getSeqNextVals(String seqName,int num);
}

	