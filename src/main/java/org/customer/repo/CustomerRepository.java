package org.customer.repo;

import java.util.List;

import org.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.email_id = :email_id")
	boolean existsByEmail_id(@Param("email_id") String email_id);
	
//	List<Customer> findByEmail_id(String email_id);
	
	//List<Customer> findByEmail_Id(@Param("email_id") String email_id);
	
	@Query(value = "SELECT c.mobile_number FROM customer c where c.mobile_number = ?1", nativeQuery = true)
	List<Customer> findByMobile_number(String mobile_number);
	
	@Query(value = "SELECT * FROM customer c where c.customer_id = ?1", nativeQuery = true)
	List<Customer> findByUser_id(String customer_id);
	
	@Query(value = "SELECT c.user_id FROM customer c where c.user_id = ?1", nativeQuery = true)
	List<Customer> findByLast_name(String last_name);
}
