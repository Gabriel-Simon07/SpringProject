package br.com.alura.spring.data.service;

import java.util.Scanner;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

public class CrudFuncionarioService {

	private FuncionarioRepository funcionarioRepository;
	private Boolean system = true;

	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void secundario(Scanner scanner) {
		while (system) {
			System.out.println("Qual ação de funcionário desejar fazer : ");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
			}
		}
	}
	
	private void salvar(Scanner scanner) {
		Funcionario funcionario = new Funcionario();
		System.out.println("Informe o nome do funcionário: ");
		String nome = scanner.next();
		System.out.println("Informe o cpf do funcionário:");
		String cpf = scanner.next();
		System.out.println("Informe o salário do funcionário:");
		Double salario = scanner.nextDouble();
		
		funcionario.setSalario(salario);
		funcionario.setCpf(cpf);
		funcionario.setNome(nome);
		funcionarioRepository.save(funcionario);
	}
}
