package org.lyl.model;

import java.io.Serializable;

public class User implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String id;
		private String loginName;
		private String passWord;
		public String getLoginName() {
			return loginName;
		}
		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}
		public String getPassWord() {
			return passWord;
		}
		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
}
