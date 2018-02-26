package com.practicaDaw.Dawllapop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Entities.OfferEnum;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.ImageManager.Image;
import com.practicaDaw.Dawllapop.Repository.AssessmentRepository;
import com.practicaDaw.Dawllapop.Repository.CategoryRepository;
import com.practicaDaw.Dawllapop.Repository.OfferRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.services.OfferServices;
import com.practicaDaw.Dawllapop.services.ProductServices;
import com.practicaDaw.Dawllapop.services.UserServices;

@Controller

public class IndexController {
	// Si se abre la URL http://127.0.0.1:8080/h2-console y se configura
	// la URL JDBC con el valor jdbc:h2:mem:testdb se puede acceder a la
	// base de datos de la aplicación

	@Autowired
	private ProductRepository p_repository;
	@Autowired
	private CategoryRepository c_repository;
	@Autowired
	private ProductServices prs;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserServices userServices;
	@Autowired
	UserServices userService;
	@Autowired
	private OfferServices oss;
	@Autowired
	private OfferRepository offerRepository;
	@Autowired
	private AssessmentRepository assessmentRepo;
	
	@PostConstruct
	public void init() {

		// Example of 1 product saved on databse
		ArrayList<String[]> especificaciones = new ArrayList<>();

		ArrayList<String> tags = new ArrayList<>();
		User user = userRepository.findOne((long) 3);
		String[] a = new String[6];
		a[0] = "CPU";
		a[1] = "4,1GHZ";
		a[2] = "COMODAS";
		a[3] = "TRANSPIRABLES";
		a[4] = "MADERA";
		a[5] = "RESISTENTE";
		especificaciones.add(a);
		tags.add("mac");
		tags.add("escritorio");
		tags.add("ordenador");
		tags.add("grande");
		tags.add("fino");
		ArrayList<String> images = new ArrayList();
		String img1 = "image-0.jpg";
		String img2 = "image-1.jpg";

		images.add(img1);
		images.add(img2);

		// Category Creation
		Category c1 = new Category("Informatica");
		c_repository.save(c1);
		Category c2 = new Category("Electronica");
		c_repository.save(c2);
		Category c3 = new Category("Inmobiliaria");
		c_repository.save(c3);
		Category c4 = new Category("Ocio");
		c_repository.save(c4);
		Category c5 = new Category("Deportes");
		c_repository.save(c5);
		Category c6 = new Category("Consolas");
		c_repository.save(c6);
		Category c7 = new Category("Videojuegos");
		c_repository.save(c7);
		Category c8 = new Category("Moda");
		c_repository.save(c8);

		// product Creation
		Product p1 = new Product("Macbook Pro 2017",
				"Es mas rapido y potente que antes, pero mas fino y ligero que nunca. Tiene la pantalla con mas color y brillo jamas vista en un portatil Mac. Y viene con la Touch Bar.",
				"new", especificaciones, tags, 1500, images, false);
		p1.setCategory(c1);
		p1.setUser(user);
		p_repository.save(p1);

		Product p2 = new Product("Escritorio",
				"Escritorio de mesa con gran capacidad de\r\n" + "								espacio", "new",
				especificaciones, tags, 800, images, false);
		p2.setCategory(c3);
		p2.setUser(user);
		p_repository.save(p2);

		Product p3 = new Product("Escritorio Pequeño",
				"Escritorio de mesa para habitaciones\r\n" + "								pequeñas", "new",
				especificaciones, tags, 300, images, false);
		p3.setCategory(c3);
		p3.setUser(user);
		p_repository.save(p3);
		Product p4 = new Product("Nokia 8998", "Vendo movil en buen estado, y con bateria nueva", "not_new",
				especificaciones, tags, 530, images, false);
		p4.setCategory(c1);
		p4.setUser(user);
		p_repository.save(p4);
		Product p5 = new Product("xiaomi mi band 2", "Incluye la pulsera de metal en vez de la de plastico", "not_new",
				especificaciones, tags, 300, images, false);
		p5.setCategory(c2);
		p5.setUser(user);
		p_repository.save(p5);
		Product p6 = new Product("Samsung galxy s9", "Me toco en un sorteo y no lo quiero", "new", especificaciones,
				tags, 1100, images, false);
		p6.setCategory(c2);
		p6.setUser(user);
		p_repository.save(p6);
		Product p7 = new Product("Zapatillas New Balance 365 ", "Sólo me las he puesto 3 veces muy cómodas", "not_new",
				especificaciones, tags, 120, images, false);
		p7.setCategory(c5);
		p7.setUser(user);
		p_repository.save(p7);
		Product p8 = new Product("Play Station 4", "Me la regalaron y no la necesito esta completamente nueva", "new",
				especificaciones, tags, 400, images, false);
		p8.setCategory(c6);
		p8.setUser(user);
		p_repository.save(p8);
		Product p9 = new Product("Ratón inalámbrico Razer",
				"Solo lo he usado un mes, tiene el precinto y sus complementos", "new", especificaciones, tags, 35,
				images, false);
		p9.setCategory(c1);
		p9.setUser(user);
		p_repository.save(p9);
		Product p10 = new Product("Camiseta Hollyster",
				"Nueva sin estrenar muy bonita de\r\n" + "								espacio", "new",
				especificaciones, tags, 15, images, false);
		p10.setCategory(c8);
		p10.setUser(user);
		p_repository.save(p10);
		Product p11 = new Product("Fallout 4",
				"Funciona a la perfeccion es de play 3\r\n" + "								pequeñas", "not_new",
				especificaciones, tags, 10, images, false);
		p11.setCategory(c7);
		p11.setUser(user);
		p_repository.save(p11);
		Product p12 = new Product("Shadow of mordor", "Nuevo es de ordenador", "new", especificaciones, tags, 45,
				images, false);
		p12.setCategory(c7);
		p12.setUser(user);
		p_repository.save(p12);
		Product p13 = new Product("Iphone 8", "Me cambio a android y no lo quiero", "not_new", especificaciones, tags,
				850, images, false);
		p13.setCategory(c2);
		p13.setUser(user);
		p_repository.save(p13);
		Product p14 = new Product("xBox 360", "Incluye 3 mandos", "not_new", especificaciones, tags, 264, images,
				false);
		p14.setCategory(c6);
		p14.setUser(user);
		p_repository.save(p14);
	
		User u = new User("Alvaro", "varo@hotmail.com", "", "password", true, "Mostoles", "ROLE_ADMIN", "ROLE_USER");
		userRepository.save(u);
		User u2 = new User("Juanma", "juanma@hotmail.com", "", "password", true, "Alcorocn", "ROLE_USER");
		userRepository.save(u2);
		User user3 = new User("David", "david.r.3.a@gmail.com", "Alcorcon", "", "a", 612595959, new Date(), true,
				"ROLE_USER");
		userRepository.save(user3);

		// Users Creation
		User user1 = userService.findUser(1);
		User user2 = userService.findUser(2);
		Product p = prs.findOne(1);

		// Offers Creation
		OfferEnum offerEnum = null;
		Offer o = new Offer(60, "Quiero este precio", offerEnum.Acepted, user1, user2, p);
		offerRepository.save(o);
		Offer o2 = new Offer(700, "Te ofrezco", offerEnum.Cancel, user1, user2, p);
		offerRepository.save(o2);
		Offer o3 = new Offer(650, "toma esto, no subo mas", offerEnum.Pending, user1, user2, p);
		offerRepository.save(o3);
		
		//Assessments Creation
		Assessment assess1 = new Assessment("Gran vendedor", 4, user2, user1, new Date());
		assessmentRepo.save(assess1);
		Assessment assess2 = new Assessment("Gran vendedor, mejor persona", 3, user3, user1, new Date());
		assessmentRepo.save(assess2);
	}

	@RequestMapping("/")
	public String Categorias(Model model, Authentication http) {

		List<Product> products = prs.getAllProducts();

		model.addAttribute("products", products);
		if (http != null) {
			model.addAttribute("usuario", userRepository.findByName(http.getName()));
		}
		System.out.println(model.toString());

		return "index";
	}

	@RequestMapping("/indexSearch")
	public String indexSearch(Model model, @RequestParam("searchText") String searchText) {
		List<User> searchUsers = userServices.searchUsers(searchText);
		List<Product> searchProducts = prs.searchProductsByName(searchText);

		model.addAttribute("users", searchUsers);
		model.addAttribute("products", searchProducts);
		return "indexSearch";
	}

	@RequestMapping("/p{id}")
	public String Product(Model model, @PathVariable int id) {

		Product p = prs.findOne(id);
		model.addAttribute("product", p);

		System.out.println(p);
		return "p{id}";
	}

}
