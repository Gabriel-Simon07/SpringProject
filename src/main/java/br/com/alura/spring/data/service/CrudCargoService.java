package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {

	private final CargoRepository cargoRepository;
	private Boolean system = true;
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual ação de cargo desejar fazer : ");
			System.out.println("2 - Sair");
			System.out.println("1 - Atualizar");
			System.out.println("2 - Salvar");
			
			int action = scanner.nextInt();
			
			switch(action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			default:
				system = false;
			}
		}
		
	}
	
	 private void salvar(Scanner scanner) {
		 System.out.println("Informe uma descrição do cargo: ");
		 String descricao = scanner.next();
		 Cargo cargo = new Cargo();
		 
		 cargo.setDescricao(descricao); 
		 cargoRepository.save(cargo);
		 System.out.println("Cargo salvo com sucesso!");
		 
	 }
	 
	 private void atualizar(Scanner scanner) {
		 System.out.println("Informe o id para atualizar :");
		 Integer id = scanner.nextInt();
		 System.out.println("Informe a nova descrição para atualizar :");
		 String descricao = scanner.next();
		 
		 Cargo cargo = new Cargo();
		 
		 cargo.setId(id);
		 cargo.setDescricao(descricao);
		 
		 cargoRepository.save(cargo);
		 System.out.println("Registro atualizado com sucesso!");
	 }
	
}
