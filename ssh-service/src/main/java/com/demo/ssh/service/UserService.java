package com.demo.ssh.service;

import com.demo.ssh.entity.User;
import com.demo.ssh.vo.Page;

import java.util.List;

/**
 * Created by xumiao on 4/20/18.
 */
public interface UserService {
    boolean add(User user);

    boolean delete(Integer id);

    boolean modify(User user);

    User findUserById(Integer id);

    List<User> findUsersByPage(Page page);

    List<User> findUsers();
}
