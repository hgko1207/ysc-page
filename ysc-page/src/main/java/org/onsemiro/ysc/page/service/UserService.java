package org.onsemiro.ysc.page.service;

import org.onsemiro.ysc.page.domain.db.User;

public interface UserService extends CRUDService<User, Integer> {

	User login(String username, String password);
}