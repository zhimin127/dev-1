package junit;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.my.enums.MapperEnum;
import com.my.utils.CalendarUtil;
import com.my.utils.MD5;
import com.my.utils.UUIDGenerator;

public class Junit_Java {
	
	protected final Log logger = LogFactory.getLog(getClass());
	@Test
	public void enums(){
		logger.debug(MapperEnum.SYS_RESOURCE.getMapperName());
	}
	//@Test
	public void uuid() {
		for (int i = 0; i < 100; i++) {
			System.out.println(UUID.randomUUID());
			System.out.println(UUIDGenerator.generate());
		}
	}

	// @Test
	public void calendar() {
		List<Date> list = CalendarUtil.getDateSection();
		for (Date date : list) {
			System.out.println(CalendarUtil.getLongDate(date));
		}
	}

	// @Test
	public void md5() {
		String s1 = "abc";
		System.out.println("原始：" + s1);
		System.out.println("MD5后：" + MD5.encode(s1));
		System.out.println("MD5后再加密：" + MD5.KL(MD5.encode(s1)));
		System.out.println("解密为MD5后的：" + MD5.JM(MD5.KL(MD5.encode(s1))));
		System.out.println("解密为MD5后的值：" + MD5.JM(MD5.JM(s1)));// 一次加密两次解密
	}

}
