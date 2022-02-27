package com.cidenet_shop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cidenet_shop.app.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {
	
	@Query(value = "select * from product where id_product = ?", nativeQuery = true)
	public List<Product> FindByIdProduct(Long idProduct);
	
	@Query(value = "SELECT PR.* FROM product PR\r\n"
			+ "INNER JOIN product_id_color PRCO ON PR.id_product = PRCO.product_id_product\r\n"
			+ "INNER JOIN product_color CO ON PRCO.id_color_id_color = CO.id_color WHERE CO.id_color = ?;", nativeQuery = true)
	public List<Product> findByColor(Long idColor);
	
	@Query(value = "select * from product where category = ?", nativeQuery = true)
	public List<Product> findByCategory(String category);
	
	@Query(value = "select * from product where brand = ?", nativeQuery = true)
	public List<Product> findByBrand(String brand);
	
	@Query(value = "select * from product where size = ?", nativeQuery = true)
	public List<Product> findBySize(String size);
	
	@Query(value = "select * from product where price = ?", nativeQuery = true)
	public List<Product> findByPrice(int price);

	
}
