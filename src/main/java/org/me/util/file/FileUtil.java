package org.me.util.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 文件工具类
 * @author: chengbo
 * @date: 2016年1月14日 11:59:02
 */
public class FileUtil {
	@SuppressWarnings("unused")
	private String file;
	private FileOutputStream out;

	public FileUtil(String file) {
		this.file = file;
		try {
			this.out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 写文件
	 * @author: chengbo
	 * @date: 2016年1月14日 12:08:03
	 */
	public void writeFile(String content) {
		 PrintStream ps=new PrintStream(out);
         ps.println(content);
	}
}
