package org.me.test.hbase;

import org.me.util.hbase.HBaseUtil;

/**
 * 测试hbase
 * @author: chengbo
 * @date: 2016年2月1日 11:31:49
 */
public class Hbase_Test {
	public static void main(String[] args) {
		HBaseUtil hbu = new HBaseUtil(null);
		hbu.createTable("ces", "c1");
	}
}
