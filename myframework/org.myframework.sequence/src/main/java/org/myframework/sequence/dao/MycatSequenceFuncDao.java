/**
 * Project Name:org.myframework.sequence <br>
 * File Name:MycatSequenceFuncDao.java <br>
 * Package Name:org.myframework.sequence.dao <br>
 * @author xiezbmf
 * Date:2017年7月4日上午10:41:15 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.sequence.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * ClassName: MycatSequenceFuncDao <br>
 * Description: mycat sequence函数操作接口
 * @author xiezbmf
 * @Date 2017年7月4日上午10:41:15 <br>
 * @version
 * @since JDK 1.6
 */
@Repository("mycatSequenceFuncDao")
public interface MycatSequenceFuncDao {
	/**
	 * 
	 * callSeqNextVal:调用mycat_seq_nextval(seqName),获取下一个序列号. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午10:48:39 <br>
	 * @param seqName 序列号名称
	 * @return
	 */
	String callSeqNextVal(@Param("seqName")String seqName);
	
	/**
	 * 
	 * callSeqNextVals:调用mycat_seq_nextvals(seqName,num),获取多个序列号. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午10:49:40 <br>
	 * @param seqName 序列号名称
	 * @param num 个数
	 * @return
	 */
	String callSeqNextVals(@Param("seqName")String seqName,@Param("num")int num);
}

	