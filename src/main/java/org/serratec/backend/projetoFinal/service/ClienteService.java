package org.serratec.backend.projetoFinal.service;


import java.util.List;
import java.util.Optional;




import org.serratec.backend.projetoFinal.repository.ClienteRepository;
import org.serratec.backend.projetoFinal.domain.Cliente;
import org.serratec.backend.projetoFinal.dto.ClienteDto;
import org.serratec.backend.projetoFinal.mail.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private MailConfig mailConfig;
	
	
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	
	public List<ClienteDto> findAll(){
		List<Cliente> clientes = clienteRepository.findAll();
		return ClienteDto.convert(clientes);
		
	}
	
	
	public Cliente buscarCliente(Long id){
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return cliente.get();
		}
		
		return null;
	}
	
	public Cliente inserir( Cliente cliente){
		
		cliente = clienteRepository.save(cliente);
		
		mailConfig.sendEmail(cliente.getEmail(), "Cadastro Efetuado", cliente.toString());
		return cliente;
	}
	
	public Cliente atualizar( Long id, Cliente cliente){
		Optional<Cliente> cliente1 = clienteRepository.findById(id);
		if(cliente1.isPresent()) {
			
			if(null != cliente.getTelefone()) {
				cliente1.get().setTelefone(cliente.getTelefone());
			}
			if(null !=cliente.getCpf()) {
				cliente1.get().setCpf(cliente.getCpf());
			}
			if(null !=cliente.getNomeCompleto()) {
				cliente1.get().setNomeCompleto(cliente.getNomeCompleto());
			}
			if(null !=cliente.getEmail()) {
				cliente1.get().setEmail(cliente.getEmail());
			}
			if(null !=cliente.getEndereco()) {
				cliente1.get().setEndereco(cliente.getEndereco());
			}
			if(null !=cliente.getDataNascimento()) {
				cliente1.get().setDataNascimento(cliente.getDataNascimento());
			}
			if(null !=cliente.getNomeUsuario()) {
				cliente1.get().setNomeUsuario(cliente.getNomeUsuario());
			}
			if(null !=cliente.getSenha()) {
				cliente1.get().setSenha(cliente.getSenha());
			}
		}
		else {
			return null;
		}
			return clienteRepository.save(cliente1.get());
		}
	
	public boolean delete(Long id){
		
		if(!clienteRepository.existsById(id)) {
			return false;
		}
		clienteRepository.deleteById(id);
		return true;
	}
	
}
