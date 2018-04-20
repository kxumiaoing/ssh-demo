package com.demo.ssh.dao.support;

import com.demo.ssh.vo.Page;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;

/**
 * Created by xumiao on 4/19/18.
 */
public class PageCallback<E> implements HibernateCallback<List<E>>{
    private String hql;
    private Object[] params;
    private Page page;

    public PageCallback(String hql, Object[] params, Page page) {
        this.hql = hql;
        this.params = params;
        this.page = page;
    }

    @Override
    public List<E> doInHibernate(Session session) throws HibernateException {
        Query<E> query = session.createQuery(this.hql);

        if (null != this.params && 0 < this.params.length){
            for (int i=0;i<this.params.length;i++) {
                query.setParameter(i,params[i]);
            }
        }

        query.setFirstResult(this.page.getStartIndex());
        query.setMaxResults(this.page.getPageSize());

        return query.list();
    }
}
