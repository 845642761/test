package org.me.test.file;

import org.me.util.file.FileUtil;

public class FileUtil_Test {

	public static void main(String[] args) {
		FileUtil fu = new FileUtil("e:ax.txt");
		fu.writeFile("/n=======/n++++++++++",true);
	}
	
}
