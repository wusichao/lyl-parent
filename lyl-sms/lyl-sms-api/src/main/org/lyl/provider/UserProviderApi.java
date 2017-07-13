package org.lyl.provider;

import java.util.List;

import org.lyl.base.BaseApi;
import org.lyl.model.User;


public interface UserProviderApi extends BaseApi<User>{
	public List<String> getPermissionByUserId(long id);
	public User findUserByName(String username);
}
