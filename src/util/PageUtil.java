package util;

import java.util.List;

public class PageUtil<Template> {

	// ��ҳ����
	public List<Template> partPage(List<Template> list, Integer pageNow, Integer pageSize) {
		Integer first = pageSize * (pageNow - 1);
		Integer end = pageSize * pageNow;
		Integer listSize = list.size();
		Integer currentPageSize = listSize - first;
		if (currentPageSize >= pageSize) {
			List<Template> partList = list.subList(first, end);
			return partList;
		} else {
			List<Template> partList = list.subList(first, listSize);
			return partList;
		}
	}

	// ҳ�����ݼ���
	public Integer pageCount(List<Template> list, Integer pageSize) {
		Integer listSize = list.size();
		Integer count = (Integer) listSize / pageSize;
		if (listSize % pageSize > 0) 
			count++;
		return count;
	}

}
