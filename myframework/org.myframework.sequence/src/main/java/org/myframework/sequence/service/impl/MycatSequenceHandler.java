/**
 * Project Name:org.myframework.sequence <br>
 * File Name:MycatSequenceHandler.java <br>
 * Package Name:org.myframework.sequence.service.impl <br>
 * @author xiezbmf
 * Date:2017年7月4日上午10:39:05 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.sequence.service.impl;

import org.myframework.common.log.CommonLogger;
import org.myframework.common.log.Log;
import org.myframework.common.log.LogTemplate;
import org.myframework.sequence.component.MycatSequenceFuncComponent;
import org.myframework.sequence.service.SequenceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: MycatSequenceHandler <br>
 * Description: mycat序列号处理实现类
 * @author xiezbmf
 * @Date 2017年7月4日上午10:39:05 <br>
 * @version
 * @since JDK 1.6
 */
@Service("mycatSequenceHandler")
public class MycatSequenceHandler implements SequenceHandler {
	private static final Log logger = CommonLogger.getInstance();
	
	@Autowired
	private MycatSequenceFuncComponent mycatSequenceFuncComponent;
	@Override
	public long nextId(String seqName) {
		try{
			return mycatSequenceFuncComponent.getSeqNextVal(seqName);
		}catch(Exception e){
			logger.error(LogTemplate.genCommonSysFailLogStr("sequence:nextId", e.getMessage()));
		}
		return -1;
	}

	@Override
	public long nextIds(String seqName, int num) {
		try{
			return mycatSequenceFuncComponent.getSeqNextVals(seqName, num);
		}catch(Exception e){
			logger.error(LogTemplate.genCommonSysFailLogStr("sequence:nextIds", e.getMessage()));
		}
		return -1;
	}

}

	