package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private final CrudFuncionarioService crudFuncionarioService;
	
	private Boolean system = true;
	
	public SpringDataApplication (CrudCargoService cargoService, CrudFuncionarioService crudFuncionarioService) {
		this.cargoService = cargoService;
		this.crudFuncionarioService = crudFuncionarioService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual a ação a fazer : ");
			System.out.println("0 para SAIR");
			System.out.println("1 para Cargo");
			System.out.println("2 para Funcionário");
			
			Integer action = scanner.nextInt();
			if (action == 1) {
				cargoService.inicial(scanner);				
			}
			if (action == 2) {
				cargoService.inicial(scanner);				
			} else {
				system = false;
			}
		}
		
	}

}
