package org.me.test.basetype;

import java.math.BigDecimal;

public class BigDecimal_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigDecimal_Test bt = new BigDecimal_Test();
		BigDecimal source = new BigDecimal("1.01");
		BigDecimal target = new BigDecimal("1.01");
		System.out.println(bt.isEqules(source, target));
	}
	
	/**
	 * 验证两个BigDecimal是否相等
	 * @author: chengbo
	 * @param: source
	 * @param: target
	 * @return: boolean
	 * @date: 2015年12月29日 18:50:50
	 */
	public boolean isEqules(BigDecimal source,BigDecimal target) {
		if(source.intValue() == target.intValue()){
			return true;
		}
		return false;
	}

}
