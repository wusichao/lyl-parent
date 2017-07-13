package org.lyl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.lyl.base.BaseController;
import org.lyl.config.Resources;
import org.lyl.exception.LoginException;
import org.lyl.model.User;
import org.lyl.service.UserService;
import org.lyl.support.Assert;
import org.lyl.support.HttpCode;
import org.lyl.support.login.LoginHelper;
import org.lyl.util.Request2ModelUtil;
import org.lyl.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class UserControler extends BaseController {
		@Autowired
		private UserService userService;
		/**
		 * 注册
		 * @param request
		 * @param modelMap
		 * @param account
		 * @param password
		 * @return
		 */
		@RequestMapping("/register")
		public Object register(HttpServletRequest request, ModelMap modelMap,
				@RequestParam(value = "loginName", required = true) String account,
				@RequestParam(value = "passWord", required = true) String password){
			User user = Request2ModelUtil.covert(User.class, request);
			Assert.notNull(user.getLoginName(),"loginName");
			Assert.notNull(user.getPassWord(),"passWord");
			userService.add(user);
			return setSuccessModelMap(modelMap,HttpCode.OK);
		}
		
		/**
		 * 登陆
		 * @param modelMap
		 * @param account
		 * @param password
		 * @return
		 */
	    @GetMapping("/login")
	    public Object login(ModelMap modelMap,
	         @RequestParam(value = "loginName", required = false) String account,
	         @RequestParam(value = "passWord", required = false) String password) {
	        Assert.notNull(account, "ACCOUNT");
	        Assert.notNull(password, "PASSWORD");
	        if (LoginHelper.login(account,password)) {
	        	User user = userService.findUserByName(account);
	        	WebUtil.saveCurrentUser(user.getId());
	            return setSuccessModelMap(modelMap,HttpCode.OK);
	        }
	        throw new LoginException(Resources.getMessage("LOGIN_FAIL"));
	    }
	    /**
	     * 查询用户
	     * @param modelMap
	     * @param userName
	     * @param request
	     * @return
	     */
	    @RequiresPermissions("sms:user:select")
	    @GetMapping("/getUser")
	    public Object getUser(ModelMap modelMap ,@RequestParam(value="loginName",required=false)String userName,HttpServletRequest request){
	    		List<User> data = new ArrayList<User>();
	    		Map<String, Object> params = WebUtil.getParameterMap(request);	  
	    			data=userService.select(params);	    		
			return setSuccessModelMap(modelMap, data);
	    	
	    }
	    public Object deleteUser(){
			return userService;
	    	
	    }
	    
}
