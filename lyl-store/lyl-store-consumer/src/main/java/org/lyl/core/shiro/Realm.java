package org.lyl.core.shiro;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.lyl.Constants;
import org.lyl.model.User;
import org.lyl.service.UserService;
import org.lyl.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * 鏉冮檺妫�鏌ョ被
 * 
 * @author ShenHuaJie
 * @version 2016骞�5鏈�20鏃� 涓嬪崍3:44:45
 */
@SuppressWarnings("unchecked")
public class Realm extends AuthorizingRealm {
    private final Logger logger = LogManager.getLogger("Realm");
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;


    // 鏉冮檺
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Long userId = WebUtil.getCurrentUser();
		List<String> list = (List<String>) redisTemplate.opsForValue().get(Constants.PERMISSION_NAMESPACE);
        if(list==null){
        	list = userService.getPermissionByUserId(userId);
        redisTemplate.opsForValue().set(Constants.PERMISSION_NAMESPACE+userId,(Serializable) list);
        }
        for (String permission : list) {
            if (StringUtils.isNotBlank(permission)) {
                // 娣诲姞鍩轰簬Permission鐨勬潈闄愪俊鎭�
                info.addStringPermission(permission);
            }
        }
        // 娣诲姞鐢ㄦ埛鏉冮檺
        info.addStringPermission("user");
        return info;
    }

    // 鐧诲綍楠岃瘉
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
        throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
       User user = userService.findUserByName(token.getUsername());
            if (user.getPassWord().equals(token.getPassword())) {
                
                saveSession(user.getLoginName());
                AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getLoginName(), user.getPassWord(),
                    user.getLoginName());
                return authcInfo;
            }
            logger.error("USER [{}] PASSWORD IS WRONG: {}"+token.getUsername()+token.getPassword().toString());
            return null;
    }

    /** 淇濆瓨session */
    @SuppressWarnings("unused")
	private void saveSession(String account) {
        // 韪㈠嚭鐢ㄦ埛
//        sysSessionService.deleteByAccount(account);
//        SysSession record = new SysSession();
//        record.setAccount(account);
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
//        record.setSessionId(session.getId().toString());
//        String host = (String)session.getAttribute("HOST");
//        record.setIp(StringUtils.isBlank(host) ? session.getHost() : host);
//        record.setStartTime(session.getStartTimestamp());
//        sysSessionService.update(record);
    }
}
