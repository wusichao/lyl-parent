package org.lyl.service;

import java.util.List;

import org.lyl.base.BaseService;
import org.lyl.model.User;
import org.lyl.provider.UserProviderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService extends BaseService<UserProviderApi, User>{
	 @Autowired
	    public void setProvider(UserProviderApi provider) {
	        this.provider = provider;
	    }
	//根据用户id，获取权限
		public List<String> getPermissionByUserId(long id){
			
			return provider.getPermissionByUserId(id);
		}
		public User findUserByName(String username) {
			return provider.findUserByName(username);
		}
}
