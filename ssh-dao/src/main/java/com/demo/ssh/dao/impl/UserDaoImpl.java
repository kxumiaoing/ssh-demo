package com.demo.ssh.dao.impl;

import com.demo.ssh.dao.UserDao;
import com.demo.ssh.dao.support.PageCallback;
import com.demo.ssh.entity.User;
import com.demo.ssh.vo.Page;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean insert(User user) {
        return null != this.hibernateTemplate.save(user);
    }

    @Override
    public boolean delete(Integer id) {
        User user = this.hibernateTemplate.load(User.class,id);

        if (null != user) {
            this.hibernateTemplate.delete(user);
            return true;
        }

        return false;
    }

    @Override
    public boolean update(User user) {
        this.hibernateTemplate.update(user);

        return true;
    }

    @Override
    public User getUserById(Integer id) {
        return this.hibernateTemplate.load(User.class,id);
    }

    @Override
    public List<User> getUsersByPage(Page page) {
        String hql = "from User";

        return this.hibernateTemplate.execute(new PageCallback<User>(hql,null,page));
    }

    @Override
    public List<User> getUsers() {
        return this.hibernateTemplate.loadAll(User.class);
    }

    @Override
    public Long getCount() {
        final String hql = "select count(1) from User";
        Long count = this.hibernateTemplate.execute((Session session) -> (Long) session.createQuery(hql).uniqueResult());

        return count;
    }
}
