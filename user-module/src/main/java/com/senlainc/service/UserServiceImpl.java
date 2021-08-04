package com.senlainc.service;

import com.senlainc.dao.FriendsInviteDao;
import com.senlainc.dao.RoleDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.user.AddFriendRequest;
import com.senlainc.dto.user.UserCriteriaRequest;
import com.senlainc.dto.user.UserRequest;
import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.Status;
import com.senlainc.entity.User;
import com.senlainc.mappers.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private FriendsInviteDao friendsInviteDao;

	@Autowired
	UserMapper mapper;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Transactional(readOnly = true)
	public User findUserById(Long id) {
		log.debug("ВЗЯТЫЙ ИЗ БД ПОЛЬЗОВАТЕЛЬ" + userDao.findById(id));
		return userDao.findById(id);
	}

	@Override
	public User saveUser(UserRequest request) {
		User newUser = mapper.userDtoToUser(request);
		newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		if(request.getRoleId() != null){
			newUser.setRole(roleDao.findById(request.getRoleId()));
		} else {
			newUser.setRole(roleDao.findById(1l));
		}
		return userDao.save(newUser);
	}

	@Override
	public void addFriend(AddFriendRequest request) {
		if(request.getButtonName().equals("confirm")){
			userDao.addFriend(request.getUserFrom(), request.getUserTo());
			friendsInviteDao.findInvitesByUsersId(request.getUserFrom(), request.getUserTo()).setStatus(Status.CONFIRM);
		} else {
			friendsInviteDao.findInvitesByUsersId(request.getUserFrom(), request.getUserTo()).setStatus(Status.REJECT);
		}
	}

	@Override
	public void deleteFriend(Long userId, Long friendId) {
		userDao.deleteFriend(userId, friendId);
	}

	@Override
	public void changeRole(Long userId, Long roleId) {
		userDao.findById(userId).setRole(roleDao.findById(roleId));
	}

	@Override
	public List<User> findUsersByCriteria(UserCriteriaRequest request) {
		return userDao.findByCriteries(request.getName(), request.getSurname());
	}

}
