package org.me.lucene.core.index;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.me.lucene.core.config.LuceneConfig;

public abstract class IndexMaker {
	private Logger log = Logger.getLogger(IndexMaker.class);
	private IndexWriter writer;
	
	public IndexMaker(LuceneConfig indexConfig) {
		Analyzer analyzer = new StandardAnalyzer();
	    IndexWriterConfig config = new IndexWriterConfig(analyzer);
	    int type = indexConfig.getType();
	    try {
	    	switch (type) {
			case 1:
				writer = makeFSDIndex(analyzer, config,indexConfig.getIndexDir());
				break;
			default:
				writer = makeRAMDIndex(analyzer, config);
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e);
		}
	}
	
	public abstract void makeIndex(List<Object> list);
	
	/**
	 * 添加Document
	 * @author chengbo
	 * @date 2016年4月5日 17:44:32
	 */
	public void addDocument(Document doc) {
		try {
			writer.addDocument(doc);
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e);
		}
	}
	
	/**
	 * 关闭IndexWriter
	 * @author chengbo
	 * @date 2016年4月5日 17:46:04
	 */
	public void closeWriter() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e);
		}
	}
	
	/**
	 * 在内存创建索引
	 * @author chengbo
	 * @date 2016年4月5日 17:16:44
	 */
	private IndexWriter makeRAMDIndex(Analyzer analyzer,IndexWriterConfig config) throws IOException {
		//将索引存储到内存中
	    Directory directory = new RAMDirectory();
	    return new IndexWriter(directory, config);
	}
	
	/**
	 * 创建指定位置索引
	 * @author chengbo
	 * @date 2016年4月5日 17:16:27
	 */
	private IndexWriter makeFSDIndex(Analyzer analyzer,IndexWriterConfig config,String indexDIR) throws IOException {
	    Directory directory = FSDirectory.open(Paths.get(indexDIR));
	    return new IndexWriter(directory, config);
	}
}
