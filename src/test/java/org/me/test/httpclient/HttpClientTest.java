package org.me.test.httpclient;

import org.me.util.httpclient.HttpClientUtil;

/**
 * 测试 httpclient
 * @author chengbo
 * @date: 2016年1月19日 12:13:12
 */
public class HttpClientTest {

	public static void main(String[] args) {
		HttpClientUtil hct = new HttpClientUtil();
		System.out.println(hct.doGetExecute("https://www.baidu.com"));
	}

}
