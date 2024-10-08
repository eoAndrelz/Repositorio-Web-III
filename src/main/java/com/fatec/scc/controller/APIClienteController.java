package com.fatec.scc.controller;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fatec.model.Cliente;
import com.fatec.model.ClienteDTO;
import com.fatec.model.Endereco;
import com.fatec.scc.services.MantemCliente1;

@RestController
@RequestMapping("/api/v1/clientes")

public class APIClienteController {
	@Autowired
	MantemCliente1 manterCliente;
	Cliente cliente;
	Logger logger = LogManager.getLogger(this.getClass());

	@CrossOrigin // desabilita o cors do spring security  
	@PostMapping 
	public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteDTO clienteDTO, BindingResult result) {   
		cliente = new Cliente(); 
		if (result.hasErrors()) {
			logger.info(">>>>>> apicontroller validacao da entrada dados invalidos" + result.getFieldError());    
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos.");   
			}
			if (manterCliente.consultaPorCpf(clienteDTO.getCpf()).isPresent()) {
				logger.info(">>>>>> apicontroller consultaporcpf cpf ja cadastrado");    
				return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado");   
				}
				try {
					cliente.setDataNascimento(clienteDTO.getDataNascimento());
					} catch (Exception e) {
						return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());   }
				Optional<Endereco> endereco = Optional.ofNullable(manterCliente.obtemEndereco(clienteDTO.getCep()));   
				logger.info(">>>>>> apicontroller obtem endereco => " + clienteDTO.getCep());  
				if (endereco.isEmpty()) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CEP invalido");   
					}
				try {
					return ResponseEntity.status(HttpStatus.CREATED).body(manterCliente.save(clienteDTO.retornaUmCliente()));  
					} catch (Exception e) { 
						return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro não esperado ");   }  
				}		
	@CrossOrigin // desabilita o cors do spring security  
	@GetMapping 
	public ResponseEntity<List<Cliente>> consultaTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(manterCliente.consultaTodos());  
		}  
	@CrossOrigin // desabilita o cors do spring security 
	@DeleteMapping("/{id}")  
	public ResponseEntity<Object> deletePorId(@PathVariable(value = "id") Long id) { 
		Optional<Cliente> cliente = manterCliente.consultaPorId(id);
		if (cliente.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");   
			}   
		manterCliente.delete(cliente.get().getId());   
		return ResponseEntity.status(HttpStatus.OK).body("Cliente excluido");  
		}  
	@CrossOrigin // desabilita o cors do spring security 
	@PutMapping("/{id}")  
	public ResponseEntity<Object> atualiza(@PathVariable long id, @RequestBody @Valid ClienteDTO clienteDTO,    BindingResult result) {
		logger.info(">>>>>> api atualiza informações de cliente chamado");  
		if (result.hasErrors()) {
			logger.info(">>>>>> apicontroller atualiza informações de cliente chamado dados invalidos");    
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos.");   
			} 
		Optional<Cliente> c = manterCliente.consultaPorId(id);  
		if (c.isEmpty()) { 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");  
			}   Optional<Endereco> e = Optional.ofNullable(manterCliente.obtemEndereco(clienteDTO.getCep()));   
			if (e.isEmpty()) { 
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CEP não localizado.");   }
			Optional<Cliente> cliente = manterCliente.atualiza(id, clienteDTO.retornaUmCliente()); 
			return ResponseEntity.status(HttpStatus.OK).body(cliente.get());  }
	@CrossOrigin // desabilita o cors do spring security 
	@GetMapping("/{id}") 
	public ResponseEntity<Object> consultaPorId(@PathVariable Long id) { 
		logger.info(">>>>>> apicontroller consulta por id chamado");  
		Optional<Cliente> cliente = manterCliente.consultaPorId(id);
		if (cliente.isEmpty()) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
			}
		return ResponseEntity.status(HttpStatus.OK).body(cliente.get()); 
	}
	}
