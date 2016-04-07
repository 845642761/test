package org.me.lucene.search;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.me.lucene.core.config.LuceneConfig;
import org.me.lucene.core.search.SearchService;

public class DefaultSearchService extends SearchService{
	private Logger log = Logger.getLogger(DefaultSearchService.class);

	public DefaultSearchService(LuceneConfig indexConfig) {
		super(indexConfig);
	}

	@Override
	protected Query buildQuery(String term,String value) {
	    QueryParser parser = new QueryParser(term, new StandardAnalyzer());
	    try {
	    	return parser.parse(value);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return null;
	}
	
	/**
	 * 创建query
	 */
	@Override
	protected Query buildMultiQuery(String[] key, String[] fields, Occur[] flags) {
		Query query;
		try {
			query = MultiFieldQueryParser.parse(key, fields, flags, new StandardAnalyzer());
			return query;
		} catch (ParseException e) {
			e.printStackTrace();
			log.error(e);
		}
		return null;
	}
	
	/**
	 * 单一查找
	 * @param term
	 * @param value
	 * @author chengbo
	 * @date 2016年4月7日 10:56:31
	 */
	public ScoreDoc[] search(String term,String value) {
		log.debug("starting search....");
		long startTime = System.currentTimeMillis();
		Query query = buildQuery(term, value);
		ScoreDoc[] hits = super.search(query);
		long endTime = System.currentTimeMillis();
		log.debug("search complete; take "+(endTime-startTime)+"ms");
		return hits;
	}
	
	/**
	 * 复合查询
	 * @param key
	 * @param fields
	 * @param flags
	 * @author chengbo
	 * @date 2016年4月7日 10:52:48
	 */
	public ScoreDoc[] search(String[] key, String[] fields, Occur[] flags) {
		log.debug("starting search....");
		long startTime = System.currentTimeMillis();
		Query query = buildMultiQuery(key, fields, flags);
		ScoreDoc[] hits = super.search(query);
		long endTime = System.currentTimeMillis();
		log.debug("search complete; take "+(endTime-startTime)+"ms");
		return hits;
	}
}
