package org.onsemiro.ysc.page.repository;

import org.onsemiro.ysc.page.domain.db.User;

public interface UserRepository extends DefaultRepository<User, Integer> {

	User findByUserIdAndPassword(String userId, String password);

}
