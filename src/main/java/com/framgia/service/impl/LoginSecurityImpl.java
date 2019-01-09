package com.framgia.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.framgia.bean.UserInfo;
import com.framgia.hepler.ConvertUser;

public class LoginSecurityImpl extends BaseServiceImpl implements UserDetailsService {
	private static final Logger logger = Logger.getLogger(LoginSecurityImpl.class);
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		logger.info("login with: " + email);
		try {
			UserInfo user = ConvertUser.userToUserInfo(getUserDAO().findByEmail(email));
			if (user == null) {
				logger.info("User not found " + email);
				throw new UsernameNotFoundException(null);
			}

			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
			grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
			
			return new User(user.getEmail(), user.getPassword(),
					grantedAuthorities);
		} catch (Exception e) {
			return null;
		}
	}


}
