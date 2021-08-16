package jj.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jj.ProductsAndCategories.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	public List<Product> findAll();
	
	
	
	
}
