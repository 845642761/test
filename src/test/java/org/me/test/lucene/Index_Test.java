package org.me.test.lucene;

import java.util.ArrayList;
import java.util.List;

import org.me.lucene.core.config.LuceneConfig;
import org.me.lucene.index.DefaultIndexMaker;

public class Index_Test {
	public static void main(String[] args) {
		LuceneConfig config = new LuceneConfig();
		config.setType(1);
		config.setIndexDir("d:/a");
		
		DefaultIndexMaker im = new DefaultIndexMaker(config);
		List<Object> data = new ArrayList<Object>();
		for (int i = 0; i < 10; i++) {
			data.add(i+"");
		}
		im.makeIndex(data);
	}
}
