package com.demo.ssh.dao;

import com.demo.ssh.entity.User;
import com.demo.ssh.vo.Page;

import java.util.List;

/**
 * Created by xumiao on 4/19/18.
 */
public interface UserDao {
    boolean insert(User user);

    boolean delete(Integer id);

    boolean update(User user);

    User getUserById(Integer id);

    List<User> getUsersByPage(Page page);

    List<User> getUsers();

    Long getCount();
}
