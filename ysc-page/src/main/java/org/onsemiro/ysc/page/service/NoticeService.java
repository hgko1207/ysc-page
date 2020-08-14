package org.onsemiro.ysc.page.service;

import java.util.List;

import org.onsemiro.ysc.page.domain.db.Notice;
import org.onsemiro.ysc.page.domain.param.SearchParam;

public interface NoticeService extends CRUDService<Notice, Integer> {

	List<Notice> getList(SearchParam param);

}