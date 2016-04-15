package org.me.util.base;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
	
	/**
	 * 切分List
	 * @param lists 切分后每个List大小限制
	 * @param limit
	 * @return List<List<String>>
	 */
	public List<List<String>> disperseList(List<String> lists, int limit) {
		if (lists == null) {
			return null;
		}

		int size = lists.size();
		ArrayList<List<String>> al = new ArrayList<List<String>>();

		int end = 0;
		for (int i = 0; i < size; i = i + limit) {
			end = i + limit;

			if (end > size) {
				end = size;
			}

			List<String> list = lists.subList(i, end);
			al.add(list);
		}

		return al;
	}
}
