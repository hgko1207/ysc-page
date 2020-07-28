package org.onsemiro.ysc.page.service.impl;

import java.util.List;

import org.onsemiro.ysc.page.domain.db.Notice;
import org.onsemiro.ysc.page.repository.NoticeRepository;
import org.onsemiro.ysc.page.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;

	@Override
	public Notice get(Integer id) {
		return noticeRepository.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Notice> getList() {
		return noticeRepository.findAll();
	}

	@Override
	public boolean regist(Notice domain) {
		if (isNew(domain)) {
			return noticeRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean update(Notice domain) {
		if (!isNew(domain)) {
			return noticeRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean delete(Integer id) {
		noticeRepository.deleteById(id);
		return true;
	}

	private boolean isNew(Notice domain) {
		return !noticeRepository.existsById(domain.getId());
	}
}
