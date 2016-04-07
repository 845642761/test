package org.me.test.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.ScoreDoc;
import org.me.lucene.core.config.LuceneConfig;
import org.me.lucene.search.DefaultSearchService;

public class Search_Test {
	public static void main(String[] args) {
		LuceneConfig config = new LuceneConfig();
		config.setType(1);
		config.setIndexDir("d:/a");
		
		DefaultSearchService ds = new DefaultSearchService(config);
		String[] key = new String[]{"1","2"};
		String[] fields = new String[]{"fieldname","fieldname"};
		
		/**
		 * BooleanClause.Occur.MUST表示and
		 * BooleanClause.Occur.MUST_NOT表示not
		 * BooleanClause.Occur.SHOULD表示or
		 */
		Occur[] flags = new Occur[]{BooleanClause.Occur.SHOULD,BooleanClause.Occur.SHOULD};
		ScoreDoc[] hits = ds.search(key, fields, flags);
		for (ScoreDoc scoreDoc : hits) {
    		Document doc = ds.getDocumentById(scoreDoc.doc);
			System.out.println(doc.get("fieldname"));
		}
		
		/**
		 * 单一查找
		 */
		ScoreDoc[] hit = ds.search("fieldname", "2");
		for (ScoreDoc scoreDoc : hit) {
			Document doc = ds.getDocumentById(scoreDoc.doc);
			System.out.println(doc.get("fieldname"));
		}
	}
}
