package com.demo.ssh.service.impl;

import com.demo.ssh.dao.UserDao;
import com.demo.ssh.entity.User;
import com.demo.ssh.service.UserService;
import com.demo.ssh.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xumiao on 4/20/18.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean add(User user) {
        return this.userDao.insert(user);
    }

    @Override
    public boolean delete(Integer id) {
        return this.userDao.delete(id);
    }

    @Override
    public boolean modify(User user) {
        return this.userDao.update(user);
    }

    @Override
    public User findUserById(Integer id) {
        return this.userDao.getUserById(id);
    }

    @Override
    public List<User> findUsersByPage(Page page) {
        page.setTotalRecords(this.userDao.getCount());

        return this.userDao.getUsersByPage(page);
    }

    @Override
    public List<User> findUsers() {
        return this.userDao.getUsers();
    }
}
