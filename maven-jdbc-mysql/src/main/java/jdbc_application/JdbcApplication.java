package jdbc_application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.CadastroDao;

import model.Cadastro;
import model.Endereco;

public class JdbcApplication {

	public static void main(String[] args) {


		menu(inicio());
		
		

	}
	private static int inicio() {
		Scanner sc = new Scanner (System.in);
		int opcao;
		

		System.out.println("\n\nBem ao sistema de cadastro\n Alexsandro S.R");
		
		System.out.println("");
		
		System.out.println("Escolha uma opção:");
		
		System.out.println("");
		
		System.out.println("1- Incluir um novo cadastro.\n2- Alterar um cadastro.\n3- Excluir um cadastro.\n"
				+ "4- Listagem de todo o cadastro.\n5- Realizar uma busca por nome.\n6- Sair.");
		return opcao = sc.nextInt();

	}
	
	private static void menu(int opcao) {

		
			switch (opcao) {
			case 1:
				System.out.println("\nVocê selecionou incluir um novo cadastro.");

				System.out.println();

				novoCadastro();
				break;
			case 2:
				System.out.println("\nVocê selecionou alterar um cadastro.");

				System.out.println();

				alteraCadastro();
				break;
			case 3:
				System.out.println("\nVocê selecionou excluir cadastro.");

				System.out.println();

				excluiCadastro();
				break;
			case 4:
				System.out.println("\nVocê selecionou a listagem do cadastro.");

				System.out.println();

				ListaCadastro();
				break;
			case 5:
				System.out.println("\nVocê selecionou a busca por nome.");

				System.out.println();
				busca();
				break;
			case 6:
				System.out.println("\nFim do programa.");
				break;
			default:
				System.out.println("\nOpção inválida!");
			}
	}

	private static void novoCadastro() {
		Scanner sc = new Scanner(System.in);
		
		String razao_social = "", cpf_cnpj = "", email = "", obs = "", site_instragram = "",logradouro = "",
				numero = "", complemento = "", bairro = "", cidade = "", uf = "", cep = "";
		Long telefone1,telefone2;
		Character pf_pj;
		int opcao;

		CadastroDao dao = new CadastroDao();
		Cadastro cadastro = new Cadastro();
		Endereco end = new Endereco();

		System.out.println("\nVocê informe o nome para incluir no cadastro:");
		razao_social = sc.next();
		
		if(!(dao.existsByNome(razao_social))) {
			
			cadastro.setRazao_social(razao_social);
			
			System.out.println("\nInforme o telefone 1.");
			telefone1 = sc.nextLong();
			cadastro.setTelefone1(telefone1);;
			
			System.out.println("\nInforme o telefone 2. ");
			telefone2 = sc.nextLong();
			cadastro.setTelefone2(telefone2);
						
			System.out.println("\nInforme se é pessoa física ou jurídica com (F) de física ou (J) judiríca. ");
			pf_pj = sc.next().charAt(0);
			cadastro.setPf_pj(pf_pj);

			System.out.println("\nInforme cpf ou cnpj. ");
			cpf_cnpj = sc.next();
			cadastro.setCpf_cnpj(cpf_cnpj);
			
			System.out.println("\nInforme seu o e-mail. ");
			email = sc.next();
			cadastro.setEmail(email);
			
			System.out.println("\nInforme suas observações.");
			obs = sc.next();
			cadastro.setObservacoes(obs);

			System.out.println("\nInforme seu site ou instagram.");
			site_instragram = sc.next();
			cadastro.setSite_instagram(site_instragram);
			
			System.out.println("\nInforme o seu logradouro.");
			logradouro = sc.next();
			end.setLogradouro(logradouro);
			
			System.out.println("\nInforme o número.");
			numero = sc.next();
			end.setNumero(numero);
			
			System.out.println("\nInforme o complemento.");
			complemento = sc.next();
			end.setComplemento(complemento);
			
			System.out.println("\nInforme o Bairro.");
			bairro = sc.next();
			end.setBairro(bairro);
			
			System.out.println("\nInforme a cidade.");
			cidade = sc.next();
			
			end.setCidade(cidade);
			
			System.out.println("\nInforme a sigla do estado.");
			uf = sc.next();
			end.setUf(uf);
			cadastro.setEndereco(end);
			
			System.out.println("Cadastro incluído com sucesso!");
		}
		else {
			System.out.println("\nO nome "+ razao_social+ " já existe!\nDeseja incluir o nome mesmo assim?\n\n1-Sim  2-Não");
				opcao = sc.nextInt();
				
				if (opcao == 1) {
					
					cadastro.setRazao_social(razao_social);
					
					System.out.println("\nO nome foi incluído!\n\nAgora...\n");

					cadastro.setRazao_social(razao_social);
					
					System.out.println("\nInforme se é pessoa física ou jurídica com (F) de física ou (J) judiríca. ");
					telefone1 = sc.nextLong();
					cadastro.setTelefone1(telefone1);
					
					System.out.println("\nInforme se é pessoa física ou jurídica com (F) de física ou (J) judiríca. ");
					telefone2 = sc.nextLong();
					cadastro.setTelefone2(telefone2);
								
					System.out.println("\nInforme se é pessoa física ou jurídica com (F) de física ou (J) judiríca. ");
					pf_pj = sc.next().charAt(0);
					cadastro.setPf_pj(pf_pj);

					System.out.println("\nInforme cpf ou cnpj. ");
					cpf_cnpj = sc.next();
					cadastro.setCpf_cnpj(cpf_cnpj);
					
					System.out.println("\nInforme seu o e-mail. ");
					email = sc.next();
					cadastro.setEmail(email);
					
					System.out.println("\nInforme suas observações.");
					obs = sc.next();
					cadastro.setObservacoes(obs);

					System.out.println("\nInforme seu site ou instagram.");
					site_instragram = sc.next();
					cadastro.setSite_instagram(site_instragram);
					
					System.out.println("\nInforme o seu logradouro.");
					logradouro = sc.next();
					end.setLogradouro(logradouro);
					
					System.out.println("\nInforme o número.");
					numero = sc.next();
					end.setNumero(numero);
					
					System.out.println("\nInforme o complemento.");
					complemento = sc.next();
					end.setComplemento(complemento);
					
					System.out.println("\nInforme o Bairro.");
					bairro = sc.next();
					end.setBairro(bairro);
					
					System.out.println("\nInforme a cidade.");
					cidade = sc.next();
					
					end.setCidade(cidade);
					
					System.out.println("\nInforme a sigla do estado.");
					uf = sc.next();
					end.setUf(uf);
					cadastro.setEndereco(end);
					
					System.out.println("Cadastro incluído com sucesso!");

					System.out.println("\nCadastro incluído com sucesso!");
				}
		}

	}
	
	private static void alteraCadastro() {
		Scanner sc = new Scanner(System.in);
		CadastroDao dao = new CadastroDao();
		Cadastro cadastro = new Cadastro();

		String nome = "";
		Long telefone;
		int opcao = 0;
		Integer id;

		System.out.println("informe o ID que deseja alterar:");
		id = sc.nextInt();

		if (dao.buscarId(id) != null) { 
			cadastro = dao.buscarId(id);
			
			System.out.println();
			
			System.out.println("O que você deseja alterar?\n\n1- Nome: | 2- Telefone ");
			
			opcao = sc.nextInt();
			

			switch (opcao) {
			case 1:
				System.out.println("Informe o novo nome:");
				nome = sc.next();
				cadastro.setRazao_social(nome);
				
				dao.alterar(cadastro);
				
				System.out.println();
				System.out.println("Nome alterado com sucesso!");
				break;
			case 2:
				System.out.println("Informe o novo telefone:");
				telefone = sc.nextLong();
				cadastro.setTelefone1(telefone);
				
				dao.alterar(cadastro);
				
				System.out.println();
				System.out.println("Telefone alterado com sucesso!");
				break;
			case 3:
				System.out.println("Informe o novo nome:");
				nome = sc.next();
				cadastro.setRazao_social(nome);

				System.out.println();

				System.out.println("Informe o novo telefone:");
				telefone = sc.nextLong();
				cadastro.setTelefone1(telefone);
				System.out.println();
				
				dao.alterar(cadastro);
				
				System.out.println("Dados alterados com sucesso!");
				break;

			default:
				System.out.println("Opção inválida!");
			}
		}
		 else 
			 System.out.println("Este ID: "+ id+ " não existe!");

	}

	private static void excluiCadastro() {
		Scanner sc = new Scanner(System.in);
		CadastroDao dao = new CadastroDao();
		Cadastro cadastro = new Cadastro();

		System.out.println("Informe o ID do cadastro que deseja excluir:");
		Integer id = sc.nextInt();
		
		if (dao.buscarId(id) != null) { 
		dao.excluir(id);
		System.out.println("Cadastro excluído com sucesso!");
		}
		else 
			System.out.println("Este ID: "+ id+ " não existe!");
	}

	private static void ListaCadastro() {
		CadastroDao dao = new CadastroDao();

		List<Cadastro> lista = dao.listar();

		for (Cadastro i : lista) {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("ID: %d | Razao_social: %s | Tipo de pessoa: %s | Telefone: %d\n | Uf %s\n", i.getId(), i.getRazao_social(),
					i.getPf_pj(), i.getTelefone1(), i.getEndereco().getUf()));
			System.out.println(sb.toString());
		}
	}

	private static void busca(){
		CadastroDao dao = new CadastroDao();
		Scanner sc = new Scanner(System.in);
		String nome = "";
		List<Cadastro> listaEncontrados = new ArrayList<Cadastro>();
		
		System.out.println("Informe o nome que deseja pesquisar:");
			nome = sc.next();
			
		System.out.println();
			
			if (dao.buscarNome(nome) !=null) {
				listaEncontrados = dao.busca(nome);
				
				for (Cadastro i : listaEncontrados) {
					StringBuilder sb = new StringBuilder();
					sb.append(String.format("ID: %d | Nome: %s | Telefone: %d\n", i.getId(), i.getRazao_social(),
							i.getTelefone1()));
					System.out.println(sb.toString());
				}
			}
			
			else
				System.out.println("Nome: "+ nome+ " não foi localizado!");
	}
}
