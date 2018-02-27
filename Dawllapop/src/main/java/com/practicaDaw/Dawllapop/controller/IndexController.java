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
import com.practicaDaw.Dawllapop.Entities.Friend_request;
import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Entities.OfferEnum;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.ImageManager.Image;
import com.practicaDaw.Dawllapop.Repository.AssessmentRepository;
import com.practicaDaw.Dawllapop.Repository.CategoryRepository;
import com.practicaDaw.Dawllapop.Repository.Friend_RequestRepository;
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
	@Autowired 
	private Friend_RequestRepository fRequestRepo;
	
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
		String img1 = "image-0.jpg";
		String img2 = "image-1.jpg";
		
		// Users Creation
		User u = new User("Alvaro", "varo@hotmail.com", "Móstoles","", "password",677654565, new Date(), true, "ROLE_ADMIN");
		userRepository.save(u);
		User u2 = new User("Juanma", "juanma@hotmail.com", "Alcorcón","", "password",45678900,new Date(), true);
		userRepository.save(u2);
		User u3 = new User("David", "david.r.3.a@gmail.com", "Alcorcon", "", "a", 612595959, new Date(), true);
		userRepository.save(u3);
		
		// Category Creation
		Category c1 = new Category("Electronica");
		c_repository.save(c1);
		Category c2 = new Category("Inmobiliaria");
		c_repository.save(c2);
		Category c3 = new Category("Deportes_y_ocio");
		c_repository.save(c3);
		Category c4 = new Category("Videojuegos");
		c_repository.save(c4);
		Category c5 = new Category("Moda");
		c_repository.save(c5);


		// product Creation
		Product p1 = new Product("Macbook Pro 2017",
				"Es mas rapido y potente que antes, pero mas fino y ligero que nunca. Tiene la pantalla con mas color y brillo jamas vista en un portatil Mac. Y viene con la Touch Bar.",
				"new", especificaciones, tags, 1900, false, "21/02/2018");
		p1.setCategory(c1);
		p1.setUser(u);
		
		
		p1.addImage("image-0.jpg");
		p_repository.save(p1);

		Product p2 = new Product("Escritorio",
				"Escritorio de mesa con gran capacidad de\r\n" + "								espacio", "new",
				especificaciones, tags, 800, false, "21/02/2018");
		p2.setCategory(c2);
		p2.setUser(u);
		p2.addImage("image-0.jpg");

		p_repository.save(p2);

		Product p3 = new Product("Escritorio Pequeño",
				"Escritorio de mesa para habitaciones\r\n" + "								pequeñas", "new",
				especificaciones, tags, 300, false, "21/02/2018");
		p3.setCategory(c2);
		p3.setUser(u);
		p3.addImage("image-0.jpg");

		p_repository.save(p3);
		Product p4 = new Product("Nokia 8998", "Vendo movil en buen estado, y con bateria nueva", "not_new",
				especificaciones, tags, 530, false, "21/02/2018");
		p4.setCategory(c1);
		p4.setUser(u);
		p4.addImage("image-0.jpg");

		p_repository.save(p4);
		Product p5 = new Product("xiaomi mi band 2", "Incluye la pulsera de metal en vez de la de plastico", "not_new",
				especificaciones, tags, 300, false, "21/02/2018");
		p5.setCategory(c1);
		p5.setUser(u);
		p5.addImage("image-0.jpg");

		p_repository.save(p5);
		Product p6 = new Product("Samsung galxy s9", "Me toco en un sorteo y no lo quiero", "new", especificaciones,
				tags, 1100, false, "21/02/2018");
		p6.setCategory(c1);
		p6.setUser(u);
		p6.addImage("image-0.jpg");

		p_repository.save(p6);
		Product p7 = new Product("Zapatillas New Balance 365 ", "Sólo me las he puesto 3 veces muy cómodas", "not_new",
				especificaciones, tags, 120, false, "21/02/2018");
		p7.setCategory(c5);
		p7.setUser(u2);
		p7.addImage("image-0.jpg");

		p_repository.save(p7);
		Product p8 = new Product("Play Station 4", "Me la regalaron y no la necesito esta completamente nueva", "new",
				especificaciones, tags, 400, false, "21/02/2018");
		p8.setCategory(c4);
		p8.setUser(u2);
		p8.addImage("image-0.jpg");

		p_repository.save(p8);
		Product p9 = new Product("Ratón inalámbrico Razer",
				"Solo lo he usado un mes, tiene el precinto y sus complementos", "new", especificaciones, tags, 35,
				 false, "21/02/2018");
		p9.setCategory(c1);
		p9.setUser(u2);
		p9.addImage("image-0.jpg");

		p_repository.save(p9);
		Product p10 = new Product("Camiseta Hollyster",
				"Nueva sin estrenar muy bonita de\r\n" + "								espacio", "new",
				especificaciones, tags, 15, false, "21/02/2018");
		p10.setCategory(c5);
		p10.setUser(u2);
		p10.addImage("image-0.jpg");

		p_repository.save(p10);
		Product p11 = new Product("Fallout 4",
				"Funciona a la perfeccion es de play 3\r\n" + "								pequeñas", "not_new",
				especificaciones, tags, 10, false, "21/02/2018");
		p11.setCategory(c4);
		p11.setUser(u2);
		p11.addImage("image-0.jpg");

		p_repository.save(p11);
		Product p12 = new Product("Shadow of mordor", "Nuevo es de ordenador", "new", especificaciones, tags, 45,
				 false, "21/02/2018");
		p12.setCategory(c4);
		p12.setUser(u2);
		p12.addImage("image-0.jpg");

		p_repository.save(p12);
		Product p13 = new Product("Iphone 8", "Me cambio a android y no lo quiero", "not_new", especificaciones, tags,
				850, false, "21/02/2018");
		p13.setCategory(c1);
		p13.setUser(u2);
		p13.addImage("image-0.jpg");

		p_repository.save(p13);
		Product p14 = new Product("xBox 360", "Incluye 3 mandos", "not_new", especificaciones, tags, 264,
				false, "21/02/2018");
		p14.setCategory(c5);
		p14.setUser(u2);
		p14.addImage("image-0.jpg");

		p_repository.save(p14);
		
		for(int i=0; i<10; i++) {
		Product p = new Product("Macbook Pro 2017",
				"Es mas rapido y potente que antes, pero mas fino y ligero que nunca. Tiene la pantalla con mas color y brillo jamas vista en un portatil Mac. Y viene con la Touch Bar.",
				"new", especificaciones, tags, 1500, false, "21/02/2018");
		p.setCategory(c1);
		p.setUser(u3);
		p_repository.save(p);
		}

		// Users search for offers
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
		Assessment assess2 = new Assessment("Gran vendedor, mejor persona", 3, u3, user1, new Date());
		assessmentRepo.save(assess2);
		
		//Friend request creation
		Friend_request fRequest1 = new Friend_request("Hola", u, u2, "accepted");
		fRequestRepo.save(fRequest1);
		Friend_request fRequest2 = new Friend_request("Hola", u3, u2);
		fRequestRepo.save(fRequest2);
		
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
