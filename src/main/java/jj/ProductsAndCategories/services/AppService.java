package jj.ProductsAndCategories.services;

import java.util.List;



import org.springframework.stereotype.Service;

import jj.ProductsAndCategories.models.Category;
import jj.ProductsAndCategories.models.Product;
import jj.ProductsAndCategories.repositories.CategoryRepository;
import jj.ProductsAndCategories.repositories.ProductRepository;



@Service
public class AppService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	public AppService(CategoryRepository categoryRepository, ProductRepository productRepository) {

		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	
	public List<Category> getAllCategories() {
		return this.categoryRepository.findAll();
	}
	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}
	
	public Product createProduct(Product product) {
		return this.productRepository.save(product);
	}
	
	public Product getProductById(Long id) {
		return this.productRepository.findById(id).orElse(null);
	}
	
	public Category getCategoryById(Long id) {
		return this.categoryRepository.findById(id).orElse(null);
	}

	public Category createCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	public void updateProduct(Product product) {
		this.productRepository.save(product);
	}
	
	
	
	
	
}
