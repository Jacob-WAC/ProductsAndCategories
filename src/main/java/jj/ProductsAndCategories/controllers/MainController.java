package jj.ProductsAndCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jj.ProductsAndCategories.models.Category;
import jj.ProductsAndCategories.models.Product;
import jj.ProductsAndCategories.services.AppService;

@Controller
public class MainController {
private final AppService appService;
	
	public MainController(AppService appService) {
		this.appService = appService;
	}
	
	@GetMapping("/")
	public String dash() {
		return "dashboard.jsp";
	}

	@GetMapping("/productForm")
	public String productForm(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	@PostMapping("/createProduct")
	private String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}
		else {
			this.appService.createProduct(product);
			return "redirect:/product/" + product.getId();
		}
	}
	@GetMapping("/product/{id}")
	public String showProduct(@PathVariable("id") Long id ,Model model) {
		Product product = this.appService.getProductById(id);
		List<Category> category = this.appService.getAllCategories();
		model.addAttribute("categories",category);
		model.addAttribute("product",product);
	return "showProduct.jsp";
	}
	
	@PostMapping("/addCategory/{id}")
	public String addCategory(@PathVariable("id")Long productId,@RequestParam("categoryId")Long categoryId) {
		Product product = this.appService.getProductById(productId);
		Category category = this.appService.getCategoryById(categoryId);
		List<Category> currentCategories = product.getCategories();
		currentCategories.add(category);
		product.setCategories(currentCategories);
		this.appService.updateProduct(product);
		return "redirect:/product/" + productId;
	}
	
	
	
	
	@GetMapping("/categoryForm")
	public String categoryForm(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/createCategory")
	private String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}
		else {
			this.appService.createCategory(category);
			return "redirect:/category/"+ category.getId() ;
		}
	}
	@GetMapping("/category/{id}")
	public String showCategory(@PathVariable("id") Long id ,Model model) {
		Category category = this.appService.getCategoryById(id);
		List<Product> products = this.appService.getAllProducts();
		model.addAttribute("category",category);
		model.addAttribute("products",products);
	return "showCategory.jsp";
	}
	
	@PostMapping("/addProduct/{id}")
	public String addProduct(@PathVariable("id")Long categoryId,@RequestParam("productId")Long productId) {
		Product product = this.appService.getProductById(productId);
		Category category = this.appService.getCategoryById(categoryId);
		List<Category> currentCategories = product.getCategories();
		currentCategories.add(category);
		product.setCategories(currentCategories);
		this.appService.updateProduct(product);
		return "redirect:/category/" + categoryId;
	}
	
}