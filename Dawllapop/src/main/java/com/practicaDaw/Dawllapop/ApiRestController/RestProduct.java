package com.practicaDaw.Dawllapop.ApiRestController;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;
import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.CategoryRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.security.UserComponent;
import com.practicaDaw.Dawllapop.services.ProductServices;

@RestController
public class RestProduct {
	@Autowired
	private ProductRepository pRepository;
	@Autowired
	private ProductServices productServices;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ProductServices pServices;
	@Autowired
	private UserRepository uRepository;
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private UserComponent userComponent;

	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deletedProduct(@PathVariable long id) {
		Product p = pRepository.findOne(id);
		if (p != null) {
			pRepository.delete(p);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	//@JsonView(Product.BasicInformation.class)
	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable long id) {
		Product product = pRepository.findOne(id);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@JsonView(Product.BasicInformation.class)
	@RequestMapping(value = "/api/products/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getUserProducts(@PathVariable("id") long id) {
		User user = uRepository.getOne(id);
		if (user != null) {
			List<Product> products = pServices.getAllProductsByUser(user.getId());
			return new ResponseEntity<>(products, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/api/products/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		if (pRepository.findByNameIgnoreCase(product.getName()) == null) {
			pRepository.save(product);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(product, HttpStatus.IM_USED);
		}

	}

	@RequestMapping(value = "/api/products/{idUser}/{idProduct}", method = RequestMethod.PUT)
	@JsonView(Product.BasicInformation.class)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> editProduct(@PathVariable long idUser, @PathVariable long idProduct,
			HttpSession session, @RequestBody Product productUpdate) {

		Product product = pRepository.findOne(idProduct);
		User userlog = userComponent.getLoggedUser();
		User newuser = uRepository.findByName(userlog.getName());
		if (newuser.getId() == idUser) {

			if (product != null) {

				product.setId(idProduct);

				if ((productUpdate.getName()) != null) {
					product.setName(productUpdate.getName());
				} else {
					product.setName(product.getName());
				}
				if ((productUpdate.getDescription()) != null) {
					product.setDescription(productUpdate.getDescription());
				} else {
					product.setDescription(product.getDescription());
				}
				if ((productUpdate.getState()) != null) {
					product.setState(productUpdate.getState());
				} else {
					product.setState(product.getState());
				}
				if ((productUpdate.getEspecifications()) != null) {
					product.setSpecifications(productUpdate.getEspecifications());
				} else {
					product.setSpecifications(product.getEspecifications());
				}
				if ((productUpdate.getTags()) != null) {
					product.setTags(productUpdate.getTags());
				} else {
					product.setTags(product.getTags());
				}

				product.setSold(false);
				product.setPrice(productUpdate.getPrice());
				product.setDate(product.getDate());

				pRepository.saveAndFlush(product);

				return new ResponseEntity<>(product, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
    @JsonView(Product.BasicInformation.class)
	@RequestMapping(value = "/api/products/category/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getIndexProductsByCategory(@PageableDefault(size = 10) Pageable page , @PathVariable long id) {
		Category category = categoryRepo.getOne(id);
		if (category != null) {
			
			Page<Product> productsPage = productServices.getAllbyCat(page, category);
			List<Product> products = productsPage.getContent();
			
			int productPages = productsPage.getTotalPages();

			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		


			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	     @JsonView(Product.BasicInformation.class)
	     	@RequestMapping(value = "/api/products/category/filter/{id}/{state1}/{state2}", method = RequestMethod.GET)
	 	public ResponseEntity<List<Product>> getIndexProductsByCategoryNewNotNew(@PageableDefault(size = 10) Pageable page , @PathVariable long id, @PathVariable String state1, @PathVariable String state2) {
	 		Category category = categoryRepo.getOne(id);
	 		
	 		if (category != null) {
	 
	 			Page<Product> productsPage = productServices.getAllbyCatAndFilter2("0", "1000000", state1, state2, category, page);
	 			List<Product> products = productsPage.getContent();
	 
	 			System.out.println(products);
	 			
	 			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	 			
	 		} else {
	 			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 		}
	 	}
	
	@CrossOrigin(origins = "http://localhost:4200")
    @JsonView(Product.BasicInformation.class)
	@RequestMapping(value = "/api/products/category/{id}/total", method = RequestMethod.GET)
	public long getNumberOfIndexProductsByCategory(@PathVariable long id) {
		Category category = categoryRepo.getOne(id);
		if (category != null) {
			
			long numberOfProducts = productServices.getNumberOfProductsByCat(category);

			return numberOfProducts;
		
		} else {
			return 0;
		}
	}
	
    @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/api/products/", method = RequestMethod.GET)
	public ResponseEntity< Page<Product> > getIndexItems(@PageableDefault(size = 10) Pageable page) {
		return new ResponseEntity<>(productServices.getAllProducts(page),HttpStatus.OK);
	}
    
    @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/api/products/search/{search}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> searchProducts(@PathVariable String search) {
		List<Product> searchProducts = productServices.searchProductsByName(search);
		if(!searchProducts.isEmpty()) {
			return new ResponseEntity<>(searchProducts, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/api/products/all", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProducts(){
    		List<Product> products = productServices.getAllProducts();
    		if(!products.isEmpty()) {
    			return new ResponseEntity(products, HttpStatus.OK);
    		}else {
    			return new ResponseEntity(HttpStatus.NOT_FOUND);
    		}    		
    }
}
