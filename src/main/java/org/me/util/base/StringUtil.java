package org.me.util.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * 字符串更换解析
	 * <p>copy from mybatis</p>
	 * @param: openToken
	 * @param: closeToken
	 * @param: source
	 * @param: target
	 * @author: chengbo
	 * @date: 2016年1月28日 17:17:11
	 */
	public String parse(String openToken, String closeToken, String source, String target) {
	    StringBuilder builder = new StringBuilder();
	    if (source != null && source.length() > 0) {
	      char[] src = source.toCharArray();
	      int offset = 0;
	      int start = source.indexOf(openToken, offset);
	      while (start > -1) {
	        if (start > 0 && src[start - 1] == '\\') {
	          builder.append(src, offset, start - offset - 1).append(openToken);
	          offset = start + openToken.length();
	        } else {
	          int end = source.indexOf(closeToken, start);
	          if (end == -1) {
	            builder.append(src, offset, src.length - offset);
	            offset = src.length;
	          } else {
	            builder.append(src, offset, start - offset);
	            offset = start + openToken.length();
	            //String content = new String(src, offset, end - offset);//值
	            builder.append(target);
	            offset = end + closeToken.length();
	          }
	        }
	        start = source.indexOf(openToken, offset);
	      }
	      if (offset < src.length) {
	        builder.append(src, offset, src.length - offset);
	      }
	    }
	    return builder.toString();
	  }
	
	/**
     * 替换固定格式的字符串（支持正则表达式）
     */
    public static String replaceAll(String str, String regex, String replacement) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, replacement);
        }
        m.appendTail(sb);
        return sb.toString();
    }
}
