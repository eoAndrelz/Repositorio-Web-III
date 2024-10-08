package com.fatec.scc.services;

import java.util.List;
import java.util.Optional;
import com.fatec.model.Cliente;
import com.fatec.model.Endereco;

public interface ManterCliente {
	List<Cliente> consultaTodos();

	Optional<Cliente> consultaPorCpf(String cpf);

	Optional<Cliente> consultaPorId(Long id);

	Optional<Cliente> save(Cliente cliente);

	void delete(Long id);

	Optional<Cliente> atualiza(Long id, Cliente cliente);

	Endereco obtemEndereco(String cep);
}
