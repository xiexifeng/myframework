/**
 * Project Name:org.myframework.sequence <br>
 * File Name:MycatSequenceFuncComponentImpl.java <br>
 * Package Name:org.myframework.sequence.component.impl <br>
 * @author xiezbmf
 * Date:2017年7月4日上午10:51:59 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.sequence.component.impl;

import org.myframework.common.log.CommonLogger;
import org.myframework.common.log.Log;
import org.myframework.common.log.LogTemplate;
import org.myframework.common.util.AssertUtil;
import org.myframework.common.util.StringUtil;
import org.myframework.sequence.component.MycatSequenceFuncComponent;
import org.myframework.sequence.dao.MycatSequenceFuncDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: MycatSequenceFuncComponentImpl <br>
 * Description: 获取序列号组件接口实现类
 * 
 * @author xiezbmf
 * @Date 2017年7月4日上午10:51:59 <br>
 * @version
 * @since JDK 1.6
 */
@Component("mycatSequenceFuncComponent")
public class MycatSequenceFuncComponentImpl implements MycatSequenceFuncComponent {
	private static final Log logger = CommonLogger.getInstance();

	@Autowired
	private MycatSequenceFuncDao mycatSequenceFuncDao;

	@Override
	public long getSeqNextVal(String seqName) {

		AssertUtil.hasText(seqName, "序列号名称不能为空");
		String cmd = "sequence:getSeqNextVal";
		String msg = null;
		try {
			String val = mycatSequenceFuncDao.callSeqNextVal(seqName);
			if (StringUtil.isNotEmpty(val)) {
				String[] vals = val.split(",");
				if (vals.length == 2) {
					Long seqVal = Long.parseLong(vals[0]);
					msg = "获取" + seqName + "成功，" + val;
					logger.debug(LogTemplate.genCommonSysOkLogStr("getSeqNextVals", msg));
					return seqVal;
				}
			}
			msg = "获取" + seqName + "失败，数据库返回值为：" + val;
			logger.info(LogTemplate.genCommonSysFailLogStr(cmd, msg));
		} catch (Exception e) {
			msg = "获取" + seqName + "异常，" + e.getMessage();
			logger.error(LogTemplate.genCommonSysFailLogStr(cmd, msg));
		}
		return -1;
	}

	@Override
	public long getSeqNextVals(String seqName, int num) {

		AssertUtil.hasText(seqName, "序列号名称不能为空");
		AssertUtil.isTrue(num > 0, "序列号个数需大于0");

		String cmd = "sequence:getSeqNextVals";
		String msg = null;
		try {
			String val = mycatSequenceFuncDao.callSeqNextVals(seqName, num);
			if (StringUtil.isNotEmpty(val)) {
				String[] vals = val.split(",");
				if (vals.length == 2) {
					Long seqVal = Long.parseLong(vals[0]);
					msg = "获取" + seqName + "成功，" + val;
					logger.debug(LogTemplate.genCommonSysOkLogStr("getSeqNextVals", msg));
					return seqVal;
				}
			}
			msg = "获取" + seqName + "失败，数据库返回值为：" + val;
			logger.info(LogTemplate.genCommonSysFailLogStr("getSeqNextVals", msg));
		} catch (Exception e) {
			msg = "获取" + seqName + "异常，" + e.getMessage();
			logger.error(LogTemplate.genCommonSysFailLogStr(cmd, msg));
		}

		return -1;
	}

}
