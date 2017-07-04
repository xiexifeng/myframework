/**
 * Project Name:org.myframework.sequence <br>
 * File Name:MycatSequenceDao.java <br>
 * Package Name:org.myframework.sequence.dao <br>
 * @author xiezbmf
 * Date:2017年7月4日上午9:49:44 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.sequence.dao;

import org.apache.ibatis.annotations.Param;
import org.myframework.sequence.model.MycatSequence;
import org.myframework.sequence.model.SequenceDetail;
import org.springframework.stereotype.Repository;

/**
 * ClassName: MycatSequenceDao <br>
 * Description: mycat序列号数据操作接口
 * @author xiezbmf
 * @Date 2017年7月4日上午9:49:44 <br>
 * @version
 * @since JDK 1.6
 */
@Repository("mycatSequenceDao")
public interface MycatSequenceDao {
	/**
	 * 
	 * saveMycatSequence:保存序列号信息. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午9:41:49 <br>
	 * @param mycatSequence
	 * @return int 插入行数
	 */
	int saveMycatSequence(MycatSequence mycatSequence);
	/**
	 * 
	 * queryMycatSequenceByName:通过name查询序列号信息. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午9:37:06 <br>
	 * @param name 序列号名称
	 * @return SequenceDetail
	 */
	SequenceDetail queryMycatSequenceByName(@Param("name")String name);
	
	/**
	 * 
	 * deleteMycatSequenceByName:通过name删除序列号信息. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午9:42:05 <br>
	 * @param name 序列号名称
	 * @return int 删除行数
	 */
	int deleteMycatSequenceByName(@Param("name")String name);
	
	/**
	 * 
	 * updateMycatSequence:更新mycat sequence. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午9:59:50 <br>
	 * @param mycatSequence
	 * @return
	 */
	int updateMycatSequence(MycatSequence mycatSequence);
}

	