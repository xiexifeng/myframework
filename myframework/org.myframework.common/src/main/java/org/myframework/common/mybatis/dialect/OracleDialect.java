/**
 * Project Name:org.myframework.common <br>
 * File Name:OracleDialect.java <br>
 * Package Name:org.myframework.common.mybatis.dialect <br>
 * @author xiezbmf
 * Date:2017年6月27日下午3:17:59 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.mybatis.dialect;


/**
 * ClassName: OracleDialect <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年6月27日下午3:17:59 <br>
 * @version
 * @since JDK 1.6
 */
public class OracleDialect extends Dialect {

	public String getLimitString(String sql, int offset, int limit) {

		sql = sql.trim();
		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" for update")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}

		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		
		pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		
		pagingSelect.append(sql);
		
		pagingSelect.append(" ) row_ ) where rownum_ > "+offset+" and rownum_ <= "+(offset + limit));

		if (isForUpdate) {
			pagingSelect.append(" for update");
		}
		
		return pagingSelect.toString();
	}

}

	