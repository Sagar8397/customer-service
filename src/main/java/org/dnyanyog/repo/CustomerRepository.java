package org.dnyanyog.repo;

import java.util.List;

import org.dnyanyog.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByUsernameAndPassword(String username, String password);
	
	List<Customer> findByUsername(String username);
	
	@Query(value = "SELECT customer_id FROM Customer", nativeQuery = true)
	List<Long> findByIdOfAllCustomer();
	
	@Query(value = "SELECT * FROM Customer", nativeQuery = true)
	List<Customer> findByAllCustomer();
}
