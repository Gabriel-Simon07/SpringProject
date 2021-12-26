package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {

	private FuncionarioRepository funcionarioRepository;
	private Boolean system = true;

	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {
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
		// System.out.println("Informe a data de nascimento do funcionário:");
		// String data = scanner.nexta

		// funcionario.setContratacao(contratacao);
		funcionario.setSalario(salario);
		funcionario.setCpf(cpf);
		funcionario.setNome(nome);
		funcionarioRepository.save(funcionario);
		System.out.println("Funcionário salvo com sucesso!");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Atualizar:\n");
		System.out.println("Id do funcionário: ");
		Integer id = scanner.nextInt();
		System.out.println("Nome do funcionário: ");
		String nome = scanner.next();
		System.out.println("Salário do funcionário: ");
		Double salario = scanner.nextDouble();
		System.out.println("Cpf do funcionário: ");
		String cpf = scanner.next();
		// System.out.println("Data de nascimento do funcionário:");
		// String data = scanner.nexta

		Funcionario funcionario = new Funcionario();

		funcionario.setId(id);
		funcionario.setNome(nome);
		funcionario.setSalario(salario);
		funcionario.setCpf(cpf);
		// funcionario.setContratacao(data);

		funcionarioRepository.save(funcionario);
		System.out.println("Registro atualizado com sucesso!");
	}

	private void visualizar() {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		funcionarios.forEach(funcionario -> System.out.println(funcionario.toString()));
	}

	private void deletar(Scanner scanner) {
		System.out.println("Id do funcionário para ser deletado: ");

		Integer id = scanner.nextInt();
		funcionarioRepository.deleteById(id);

		System.out.println("Registro deletado com sucesso!");
	}
}
