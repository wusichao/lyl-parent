package org.lyl.mappers;

import java.util.List;

import org.lyl.base.BaseMapper;
import org.lyl.model.User;


public interface UserProviderMapper extends BaseMapper<User>{
	List<String> getPermissionByUserId(long id);

	User findUserByName(String username);
}
