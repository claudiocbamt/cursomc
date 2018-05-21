package com.claudiocosta.cursomc.services.validadion;



import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.claudiocosta.cursomc.domain.Cliente;
import com.claudiocosta.cursomc.domain.enums.TipoCliente;
import com.claudiocosta.cursomc.dto.ClienteNewDTO;
import com.claudiocosta.cursomc.repositories.ClienteRepository;
import com.claudiocosta.cursomc.resources.exception.FieldMessage;
import com.claudiocosta.cursomc.services.validadion.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Autowired
	
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>(); 
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod())&& !BR.isValidCPF(objDto.getCpfouCnpj())) {
			list.add(new FieldMessage("CpfOuCNpj", "CPF inválido"));
			
		}
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod())&& !BR.isValidCNPJ(objDto.getCpfouCnpj())) {
			list.add(new FieldMessage("CpfOuCNpj", "CNPJ inválido"));
			
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if(aux !=null)
		{
			
			list.add(new FieldMessage("email", "Email já existente"));
		}
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldname())
			        .addConstraintViolation();
		}
		return list.isEmpty();
	}
	
}
