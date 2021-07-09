package application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.exceptions.CampoObrigatorioException;
import application.exceptions.RegistroNaoLocalizadoException;
import application.model.Cadastro;
import application.repository.CadastroRepository;



@Service
public class CadastroService {
	@Autowired
	private CadastroRepository repository;
	
	public void incluir(Cadastro cadastro) {
		//TRATAR CADA CENÁRIO COM AS RESPECTIVAS CONSIDERAÇÕES
		if(cadastro.getCpf() == null)
			throw new CampoObrigatorioException("CPF");
		
		repository.save(cadastro);
		
	}
	public Cadastro buscar(Integer id) throws RegistroNaoLocalizadoException {
		Optional<Cadastro> opt = repository.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
		 throw new RegistroNaoLocalizadoException("Cadastro", id);
		
	}
}
