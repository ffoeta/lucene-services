package com.example.indexer.session;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class SqlSessionTemplate {

  private SessionFactory sessionFactory;

  public SqlSessionTemplate(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Transactional
  public <T> Optional<T> getById(Class<T> tClass, String index, Integer id) {
    var hql = "SELECT * FROM " + index + " WHERE id = " + id;
    try {
       return Optional.of(
           (T) em()
          .createNativeQuery(hql)
          .getSingleResult()
       );
    } catch (NoResultException e) {
      return Optional.empty();
    }
  }

  @Transactional
  public int getCount(String index) {
    var hql = "SELECT COUNT(*) FROM " + index;
    return em()
        .createNativeQuery(hql)
        .getFirstResult();
  }

  private EntityManager em() {
    return sessionFactory.openSession();
  }

  private String idList(List<Integer> list) {
    if (list.isEmpty()) {
      return "";
    }
    StringBuilder stringBuilder = new StringBuilder();

    var iterator = list.iterator();
    stringBuilder.append("(");
    stringBuilder.append(iterator.next());

    while (iterator.hasNext()) {
      stringBuilder.append(",");
      stringBuilder.append(iterator.next());
    }
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}
