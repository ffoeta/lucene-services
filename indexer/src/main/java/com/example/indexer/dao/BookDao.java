package com.example.indexer.dao;

import com.example.indexer.model.Book;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class BookDao {

  private SessionFactory sessionFactory;

  public BookDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public List<Book> getBooksById(List<UUID> uuidList) {
    var hql = "SELECT * FROM book WHERE id IN :list";
    EntityManager em = em();
    var transaction = em.getTransaction();
    transaction.begin();
    var res = em.createNativeQuery(hql)
        .setParameter("list", uuidList)
        .getResultList();
    transaction.commit();
    return res;
  }

  public int getBooksCount() {
    var hql = "SELECT COUNT(*) FROM book;";
    EntityManager em = em();
    var transaction = em.getTransaction();
    transaction.begin();
    var res = em()
        .createNativeQuery(hql)
        .getFirstResult();
    transaction.commit();
    return res;
  }

  private EntityManager em() {
    return sessionFactory.getCurrentSession();
  }
}
