package org.me.lucene.core.config;

public class LuceneConfig {
	private int type;//0:内存  1:文件
	private String indexDir;//索引位置
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getIndexDir() {
		return indexDir;
	}
	public void setIndexDir(String indexDir) {
		this.indexDir = indexDir;
	}
}
