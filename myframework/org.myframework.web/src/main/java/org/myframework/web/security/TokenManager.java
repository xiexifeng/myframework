/**
 * Project Name:org.myframework.web <br>
 * File Name:TokenManager.java <br>
 * Package Name:org.myframework.web.security <br>
 * @author xiezbmf
 * Date:2017年7月25日下午4:23:50 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security;

import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * ClassName: TokenManager <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月25日下午4:23:50 <br>
 * @version
 * @since JDK 1.6
 */
public interface TokenManager {
	/**
     * Creates a new token for the user and returns its {@link TokenInfo}.
     * It may add it to the token list or replace the previous one for the user. Never returns {@code null}.
     */
    TokenInfo createNewToken(UserDetails userDetails);

    /** Removes all tokens for user. */
    //void removeUserDetails(UserDetails userDetails);

    /** Removes a single token. */
    UserDetails removeToken(String token);

    /** Returns user details for a token. */
    UserDetails getUserDetails(String token);
    
    /** Returns user details for a username. */
    UserDetails getUserDetailsByUsername(String username);

    /** Returns a collection with token information for a particular user. */
    Collection<TokenInfo> getUserTokens(UserDetails userDetails);
    
    
    Boolean validateToken(String token);
}

	