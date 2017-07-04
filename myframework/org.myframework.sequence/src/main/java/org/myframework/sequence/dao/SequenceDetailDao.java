/**
 * Project Name:org.myframework.sequence <br>
 * File Name:SequenceDetailDao.java <br>
 * Package Name:org.myframework.sequence.dao <br>
 * @author xiezbmf
 * Date:2017年7月4日上午9:29:29 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.sequence.dao;

import org.apache.ibatis.annotations.Param;
import org.myframework.sequence.model.SequenceDetail;
import org.springframework.stereotype.Repository;

/**
 * ClassName: SequenceDetailDao <br>
 * Description: 序列号详细配置数据操作接口
 * @author xiezbmf
 * @Date 2017年7月4日上午9:29:29 <br>
 * @version
 * @since JDK 1.6
 */
@Repository("sequenceDetailDao")
public interface SequenceDetailDao {
	
	/**
	 * 
	 * saveSequenceDetail:保存序列号详细信息. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午9:41:49 <br>
	 * @param sequenceDetail
	 * @return int 插入行数
	 */
	int saveSequenceDetail(SequenceDetail sequenceDetail);
	/**
	 * 
	 * querySequenceDetailByName:通过name查询序列号详细信息. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午9:37:06 <br>
	 * @param name 序列号名称
	 * @return SequenceDetail
	 */
	SequenceDetail querySequenceDetailByName(@Param("name")String name);
	
	/**
	 * 
	 * deleteSequenceDetailByName:通过name删除序列号详细信息. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午9:42:05 <br>
	 * @param name 序列号名称
	 * @return int 删除行数
	 */
	int deleteSequenceDetailByName(@Param("name")String name);
	
	/**
	 * 
	 * updateSequenceDetail:更新序列号详细信息. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日上午10:03:41 <br>
	 * @param sequenceDetail
	 * @return
	 */
	int updateSequenceDetail(SequenceDetail sequenceDetail);
}

	