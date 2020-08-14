package org.onsemiro.ysc.page.domain.db;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.onsemiro.ysc.page.domain.Domain;

import lombok.Data;

/**
 * 궁금합니다 테이블 도메인
 * 
 * @author hgko
 *
 */
@Data
public class Wonder implements Domain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
}
