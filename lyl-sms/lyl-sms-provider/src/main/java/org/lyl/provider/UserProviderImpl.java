package org.lyl.provider;

import java.util.List;

import org.lyl.base.BaseProviderImpl;
import org.lyl.mappers.UserProviderMapper;
import org.lyl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserProviderImpl extends BaseProviderImpl<User,UserProviderMapper> implements UserProviderApi{
		@Autowired
	    public void setMapper(UserProviderMapper userProviderMapper) {
	        this.mapper = userProviderMapper;
	    }
	public List<String> getPermissionByUserId(long id) {
		return mapper.getPermissionByUserId(id);
	}

	public User findUserByName(String username) {
		return mapper.findUserByName(username);
	}
	
}
