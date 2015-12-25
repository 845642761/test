package org.me.test.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp {
	
	public static void main(String[] args) {
		TimeStamp ts = new TimeStamp();
		/*long stamp = Long.parseLong("1450343882419");//1450343882875
		String date = ts.DateFormat(ts.stampToDate(stamp));
		System.out.println(date);*/
		//Date date = ts.StringToDate("2015-12-18 00:00:15");//1450368015000
		//Date date = ts.StringToDate("2015-12-18 00:00:00");//1450368000000
		//Date date = ts.StringToDate("2015-12-18 15:00:00");//1450422000000
		//Date date = ts.StringToDate("2015-12-18 16:00:00");//1450425600000
		//Date date = ts.StringToDate("2015-12-18 21:00:00");//1450443600000
		Date date = ts.StringToDate("2000-01-01 00:00:00");//946656000000
		System.out.println(date.getTime());
	}
	
	/**
	 * 时间戳转Date
	 * @author: chengbo
	 * @date: 2015年12月16日 10:18:03
	 */
	public Date stampToDate(long stamp){
		return new Date(stamp);
	}
	
	/**
	 * Date格式化
	 * @author: chengbo
	 * @date: 2015年12月16日 10:21:54
	 */
	public String DateFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 字符串转日期
	 * @author: chengbo
	 * @date: 2015年12月18日 19:48:55
	 */
	public Date StringToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
