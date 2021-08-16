package jj.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jj.ProductsAndCategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	public List<Category> findAll();
}
