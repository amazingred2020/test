package com.senlainc.service.user;

import com.senlainc.dao.FriendsInviteDao;
import com.senlainc.dao.RoleDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.user.AddFriendRequest;
import com.senlainc.dto.user.GetUserRequest;
import com.senlainc.dto.user.SaveUserRequest;
import com.senlainc.dto.user.UserTextSearchRequest;
import com.senlainc.enums.Status;
import com.senlainc.entity.User;
import com.senlainc.mappers.user.UserMapper;
import com.senlainc.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional(readOnly = true)
	public User findUserById(Long id) {
		Optional<User> user = Optional.ofNullable(userDao.findById(id));
		if(user.isPresent()){
			return user.get();
		}
		return null;
	}

	@Override
	public User saveUser(SaveUserRequest request) {
		User newUser = userMapper.userSaveUserRequestToUser(request);
		newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		if(request.getRoleId() == null){
			newUser.setRole(roleDao.findById(1l));
		}
		return userDao.save(newUser);
	}

	@Override
	public void addFriend(AddFriendRequest request) {
		if(request.getButtonName().equals("confirm")){
			userDao.addFriend(request.getUserFrom(), request.getUserTo());
			friendsInviteDao.findInvitesByUsersId(request.getUserFrom(), request.getUserTo()).get().setStatus(Status.CONFIRM);
		} else {
			friendsInviteDao.findInvitesByUsersId(request.getUserFrom(), request.getUserTo()).get().setStatus(Status.REJECT);
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
	public List<User> findUsersByParameters(GetUserRequest request) {
		return userDao.findByParameters(request.getName(), request.getSurname());
	}

	@Override
	public List<User> getUsersByTextSearch(UserTextSearchRequest request) {
		return userDao.getUsersByTextSearch(request.getFirstName(), request.getLastName(), request.getCity()).get();
	}

	@Override
	public List<User> getPaginatedUserList(int page, int size) {
		return userDao.getPaginatedUserList(page, size);
	}

	@Override
	public User findByAnyId(Long id) {
		Optional<User> user = userDao.findByAnyId(id);
		if(user.isPresent()){
			return user.get();
		}
		return null;
	}

}
