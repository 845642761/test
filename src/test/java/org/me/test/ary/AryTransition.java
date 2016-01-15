package org.me.test.ary;

/**
 * 进制转换
 * @author chengbo
 * @date: 2015年12月24日 10:43:26
 */
public class AryTransition {
	
	public static void main(String[] args) {
		AryTransition at = new AryTransition();
		for (int i = 100; i < 200; i++) {
			System.out.println(i+"的十六进制数是："+at.intToHex(i));
		}
	}
	
	/**
	 * int转16进制
	 * @param i
	 * @return String
	 * @author: chengbo
	 * @date: 2015年12月24日 10:45:03
	 */
	public String intToHex(int i) {
		return Integer.toHexString(i);
	}
}
