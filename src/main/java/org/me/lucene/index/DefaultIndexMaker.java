package org.me.lucene.index;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.me.lucene.core.config.LuceneConfig;
import org.me.lucene.core.index.IndexMaker;

public class DefaultIndexMaker extends IndexMaker {
	public DefaultIndexMaker(LuceneConfig indexConfig) {
		super(indexConfig);
	}

	private Logger log = Logger.getLogger(DefaultIndexMaker.class);

	@Override
	public void makeIndex(List<Object> list) {
		if(list == null){
			log.info("no index data need...");
			return;
		}
		for (Object object : list) {
			String text = (String) object;
			Document doc = new Document();
			doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
			super.addDocument(doc);
		}
		closeWriter();
		log.debug("make index complete...");
	}

}
