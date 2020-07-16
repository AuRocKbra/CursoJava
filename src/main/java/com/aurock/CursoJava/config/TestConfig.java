package com.aurock.CursoJava.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aurock.CursoJava.entities.User;
import com.aurock.CursoJava.repositories.UserRepository;

@Configuration //Define a classe como de configuração
@Profile("test") //Permite vincular a classe ao perfil
public class TestConfig implements CommandLineRunner{
	/*
	 * Classe responsável por realizar injeção de dependencia para uma entidade, no caso a entidade User.
	 * A implementação do CommandLineRunner permite a execução da classe no momento na inicialização da aplicação
	 * */
	
	@Autowired //Perimite associar a instancia do reposítorio User
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1,u2));//Realiza o dataseeding 
	}
	
	
}
