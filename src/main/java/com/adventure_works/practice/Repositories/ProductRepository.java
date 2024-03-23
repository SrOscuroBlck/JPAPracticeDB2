package com.adventure_works.practice.Repositories;

import com.adventure_works.practice.Models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    Optional<ProductModel> findByName(@Param("name")String name);
	/*@Repository
	public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	}
	@Query("SELECT p FROM Product p WHERE p.name :name")
	Optional<Product> findByName(@Param("name")String name);
   // Page<Product> findUsingPaging(Pageable pageable);
    List<Product> findAllByPriceEquals(int price);

    @Query("SELECT p FROM Product p WHERE p.price > :threshold")
    List<Product> findProductsAbovePrice(@Param("threshold") int threshold);

    boolean existsByName(String name);
*/
}
