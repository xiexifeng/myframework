/**
 * Project Name:org.myframework.sequence <br>
 * File Name:BaseJUnit.java <br>
 * Package Name:org.myframework.sequence.test <br>
 * @author xiezbmf
 * Date:2017年7月4日上午11:31:00 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.sequence.test;

import java.util.Date;

import org.junit.Test;
import org.myframework.sequence.dao.MycatSequenceDao;
import org.myframework.sequence.model.MycatSequence;
import org.myframework.sequence.service.SequenceHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: BaseJUnit <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月4日上午11:31:00 <br>
 * @version
 * @since JDK 1.6
 */
public class BaseJUnit {
	public static ApplicationContext ctx = null;

	 static{
	   long b = new Date().getTime();
	   ctx = new ClassPathXmlApplicationContext("xml/sequence.xml");
	   long e = new Date().getTime();
	   System.out.println("cost load xml time:"+(e-b)/1000+"s"+","+(e-b)+"ms");
	 }
	@Test
	public void test() {
		System.out.println("hello");
		SequenceHandler mycatSequenceHandler = (SequenceHandler)ctx.getBean("mycatSequenceHandler");
		System.out.println(mycatSequenceHandler.nextIds("GLOBAL",3));
		MycatSequenceDao mycatSequenceDao =(MycatSequenceDao)ctx.getBean("mycatSequenceDao");
		MycatSequence mycatSequence = new MycatSequence();
		String name = "L_LOAN_REPAYMENT";
		mycatSequence.setName(name);
		mycatSequence.setIncrement(1);
		mycatSequence.setCurrentValue(0);
		mycatSequenceDao.saveMycatSequence(mycatSequence);
		mycatSequenceDao.deleteMycatSequenceByName(name);
	}
}

	