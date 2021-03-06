package jp.tuyano.spring.data1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyPersonDataDaoRepository 
	extends JpaRepository<MyPersonData, Integer> {

	@Query("select name from MyPersonData")
	public List<String> getAllName();

	public List<MyPersonData> findByName(String name);
	public List<MyPersonData> findByMail(String mail);
	public List<MyPersonData> findByAge(int age);
	public List<MyPersonData> findByNameLike(String name);
	public List<MyPersonData> findByMailLike(String mail);
	public List<MyPersonData> findByNameOrMail
		(String name, String mail);
	public List<MyPersonData> findByNameLikeOrMailLike
		(String name, String mail);
	public List<MyPersonData> findByAgeGreaterThan(Integer age);
	public List<MyPersonData> findByAgeLessThan(Integer age);
	public List<MyPersonData> findByAgeGreaterThanOrAgeLessThan
		(Integer age0, Integer age1);

}
