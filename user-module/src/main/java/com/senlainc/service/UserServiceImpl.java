package com.senlainc.service;

import com.senlainc.dao.FriendsInviteDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.user.AddFriendRequest;
import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.Status;
import com.senlainc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;

	@Autowired
	private FriendsInviteDao friendsInviteDao;

	@Transactional(readOnly = true)
	public User findUserById(Long id) {
		return userDao.findById(id);
	}

	public User saveUser(User user) {
			return userDao.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userDao.remove(id);
	}

	@Override
	public void addFriend(AddFriendRequest request) {
		FriendInvite friendInvite = new FriendInvite(userDao.findById(request.getUserFrom()),
				userDao.findById(request.getUserTo()), request.getStatus());
		friendsInviteDao.save(friendInvite);
		friendInvite = changeInviteStatus(friendInvite);
		if(friendInvite.getStatus() == Status.CONFIRM){
			userDao.addFriend(request.getUserFrom(), request.getUserTo());
			friendsInviteDao.deleteByUsersId(request.getUserFrom(), request.getUserTo());
		}
	}

	private FriendInvite changeInviteStatus(FriendInvite friendInvite) {
		if(Math.random() < 0.5){
			friendInvite.setStatus(Status.CONFIRM);
		} else {
			friendInvite.setStatus(Status.REJECT);
		}
		return friendInvite;
	}


	@Override
	public void deleteFriend(Long userId, Long friendId) {
		userDao.deleteFriend(userId, friendId);
	}

}
