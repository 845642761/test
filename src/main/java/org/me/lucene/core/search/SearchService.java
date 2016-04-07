package org.me.lucene.core.search;

import java.io.IOException;
import java.nio.file.Paths;
import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.me.lucene.core.config.LuceneConfig;

/**
 * 搜索服务
 * @author chengbo
 * @date 2016年4月6日 09:35:43
 */
public abstract class SearchService {
	private Logger log = Logger.getLogger(SearchService.class);
	private IndexSearcher iSearcher;
	
	public SearchService(LuceneConfig indexConfig) {
		Directory directory = null;
		int type = indexConfig.getType();
	    switch (type) {
	    case 1:
	    	try {
				directory = FSDirectory.open(Paths.get(indexConfig.getIndexDir()));
			} catch (IOException e) {
				e.printStackTrace();
				log.error(e);
			}
	    	break;
	    default:
	    	directory = new RAMDirectory();
	    }
		
		DirectoryReader ireader = null;
		try {
			ireader = DirectoryReader.open(directory);
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e);
		}
	    iSearcher = new IndexSearcher(ireader);
	}
	
	protected abstract Query buildQuery(String term,String value);
	protected abstract Query buildMultiQuery(String[] key, String[] fields,Occur[] flags);
	
	public ScoreDoc[] search(Query query) {
		try {
			TopDocs topDocs = iSearcher.search(query, 1000);
			ScoreDoc[] hits = topDocs.scoreDocs;
			return hits;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return null;
	}
	
	public Document getDocumentById(int docID) {
		try {
			return iSearcher.doc(docID);
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e);
		}
		return null;
	}
}
