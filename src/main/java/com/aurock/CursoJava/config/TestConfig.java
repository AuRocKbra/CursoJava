package com.aurock.CursoJava.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aurock.CursoJava.entities.Category;
import com.aurock.CursoJava.entities.Order;
import com.aurock.CursoJava.entities.User;
import com.aurock.CursoJava.entities.enuns.OrderStatus;
import com.aurock.CursoJava.repositories.CategoryRepository;
import com.aurock.CursoJava.repositories.OrderRepository;
import com.aurock.CursoJava.repositories.UserRepository;

@Configuration //Define a classe como de configuração
@Profile("test") //Permite vincular a classe ao perfil
public class TestConfig implements CommandLineRunner{
	/*
	 * Classe responsável por realizar injeção de dependencia para uma entidade.
	 * A implementação do CommandLineRunner permite a execução da classe no momento na inicialização da aplicação
	 * */
	
	@Autowired //Perimite associar a instancia do reposítorio User
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1,OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2,OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1,OrderStatus.WAITING_PAYMENT);
		
		
		
		userRepository.saveAll(Arrays.asList(u1,u2));//Realiza o dataseeding
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
	}
	
	
}
