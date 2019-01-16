package com.framgia.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.framgia.bean.UserInfo;
import com.framgia.exception.EmailExistsException;
import com.framgia.hepler.ConvertUser;
import com.framgia.model.User;
import com.framgia.service.UserService;

public class UserServiceImpl extends BaseServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Override
	public User findById(Serializable key) {
		try {
			return getUserDAO().findById(key);
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public User saveOrUpdate(User entity) {
		try {
			return getUserDAO().saveOrUpdate(entity);
		}catch (Exception e) {
			throw(e);
		}
	}

	@Override
	public boolean delete(User entity) {
		try {
			getUserDAO().delete(entity);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public UserInfo findByEmailAndPassword(String email, String password) {
		try {
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			boolean checkUser = passwordEncoder.matches(password, findByEmail(email).getPassword());
			if (!checkUser) {
				return null;
			}
			return ConvertUser.userToUserInfo(getUserDAO().findByEmail(email));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public UserInfo findByEmail(String email) {
		try {
			return ConvertUser.userToUserInfo(userDAO.findByEmail(email));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public List<User> getAll() {
		try {
			return userDAO.getAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean deleteUser(Integer id) {
		try {
			return delete(getUserDAO().findByIdUsingLock(id, LockMode.PESSIMISTIC_WRITE));
		}catch (Exception e) {
			throw(e);
		}
	}

	@Override
	public UserInfo findByOrderId(int indexOf) {
		try {
			return ConvertUser.userToUserInfo(userDAO.findByOrderId(indexOf));
		}catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public User registerNewUserAccount(User accountDto) throws EmailExistsException {
		if (emailExist(accountDto.getEmail())) {   
            throw new EmailExistsException("There is an account with that email address:" 
            			+ accountDto.getEmail());
        }
		User user = new User();    
        user.setName(accountDto.getName());
        user.setPassword(accountDto.getPassword());
        user.setPhone(accountDto.getPhone());
        user.setEmail(accountDto.getEmail());
        user.setRole(1);
        return userDAO.saveOrUpdate(user);       
	}
	
	private boolean emailExist(String email) {
        User user = userDAO.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}