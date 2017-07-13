package org.lyl;

/**
 * 常量表
 * 
 * @author ShenHuaJie
 * @version $Id: Constants.java, v 0.1 2014-2-28 上午11:18:28 ShenHuaJie Exp $
 */
public interface Constants {
	/**
	 * 异常信息统一头信息<br>
	 * 非常遗憾的通知您,程序发生了异常
	 */
	public static final String Exception_Head = "OH,MY GOD! SOME ERRORS OCCURED! AS FOLLOWS :";
	/** 客户端语言 */
	public static final String USERLANGUAGE = "userLanguage";
	/** 客户端主题 */
	public static final String WEBTHEME = "webTheme";
	/** 当前用户 */
	public static final String CURRENT_USER = "CURRENT_USER";
	/** 在线用户数量 */
	public static final String ALLUSER_NUMBER = "ALLUSER_NUMBER";
	/** 登录用户数量 */
	public static final String USER_NUMBER = "USER_NUMBER";
	/** 上次请求地址 */
	public static final String PREREQUEST = "PREREQUEST";
	/** 上次请求时间 */
	public static final String PREREQUEST_TIME = "PREREQUEST_TIME";
	/** 非法请求次数 */
	public static final String MALICIOUS_REQUEST_TIMES = "MALICIOUS_REQUEST_TIMES";
	   /** 缓存命名空间 */
    public static final String REDIS_NAMESPACE = "lyl-sms:";
    /** 缓存命名空间权限 */
    public static final String PERMISSION_NAMESPACE = "permission:";
    /** 缓存权限过期时间 */
    public static final long PERMISSION_EXPIRE = 3600;
    /** 缓存命名空间售卖统计 */
    public static final String LOC_COUNTSIGN_USER_NAMESPACE = "loc_countsign:user:";
    /** 缓存命名空间售卖统计 */
    public static final String LOC_COUNTSIGN_GOODS_NAMESPACE = "loc_countsign:goods:";
    /** 缓存命名空间售卖统计 */
    public static final String GOODS_COUNTSIGN_USER_NAMESPACE = "goods_countsign:user:";
    /** 缓存命名空间售卖统计 */
    public static final String GOODS_COUNTSIGN_GOODS_NAMESPACE = "goods_countsign:goods:";
    /** 缓存不过期 */
    public static final Integer NO_EXPIRE =365*24*60*60;
}
