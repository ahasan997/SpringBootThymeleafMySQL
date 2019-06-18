package men.ahasan.spring_mysql_thymeleaf_jpa_crud.repository;

import men.ahasan.spring_mysql_thymeleaf_jpa_crud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
