package org.lyl.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
		/**
	 * <p>Discription:[]</p>
	 */
		/**
	 * 
	 */
		private Long id;
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
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
}
