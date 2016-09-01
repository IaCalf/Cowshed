package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {
	/**
	 * 字符转日期
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(String str) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(str);

	}
	/**
	 * 日期转字符
	 * @param data
	 * @return
	 */
	public static String getStr(Date data){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(data);
	}
}
