package jp.tuyano.spring.data1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class MyPersonDataDaoImpl
		extends AbstractMyPerrsonDataDao<MyPersonData> {

	@SuppressWarnings("unused")
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private LocalContainerEntityManagerFactoryBean factory;
	
	@PersistenceContext
	private EntityManager manager;
	
	public MyPersonDataDaoImpl() {
		init();
	}
	
	public List<MyPersonData> getAllEntity() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<MyPersonData> query = builder
			.createQuery(MyPersonData.class);
		Root<MyPersonData> root = query.from(MyPersonData.class);
		query.select(root);
		List<MyPersonData> list = (List<MyPersonData>) manager
			.createQuery(query).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<MyPersonData> findByName(String value) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<MyPersonData> query = builder.createQuery(MyPersonData.class);
		Root<MyPersonData> root = query.from(MyPersonData.class);
		query.select(root).where(builder.like(root.get("name").as(String.class), value));
		Query jpql = manager.createQuery(query);
		List<MyPersonData> list = (List<MyPersonData>) jpql.getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<MyPersonData> findByField(String field, String find) {
		Query query = manager.createQuery("from MyPersonData where " 
			+ field + " = '" + find + "'");
		return query.getResultList();
	}
	
	public void addEntity(MyPersonData entity) {
		EntityManager manager = factory.
			getNativeEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		System.out.println("add:" + entity);
		manager.flush();
		transaction.commit();
	}

	public void updateEntity(MyPersonData entity) {
		EntityManager manager = factory.
			getNativeEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(entity);
		manager.flush();
		transaction.commit();
	}

	public void removeEntity(MyPersonData data) {
		EntityManager manager = factory.
			getNativeEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(data);
		manager.flush();
		transaction.commit();
	}

	public void removeEntity(Long id) {
		MyPersonData entity = manager.find(MyPersonData.class, id);
			this.removeEntity(entity);

	}

}
