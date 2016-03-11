package org.me.util.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 文件工具类
 * 
 * @author: chengbo
 * @date: 2016年1月14日 11:59:02
 */
public class FileUtil {
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
		PrintStream ps = new PrintStream(out);
		ps.println(content);
	}

	/**
	 * 写文件
	 * @author: chengbo
	 * @date: 2016年2月22日 16:22:10
	 */
	public void writeFile(String content,boolean isAppend) {
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			FileWriter writer = new FileWriter(file, isAppend);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
