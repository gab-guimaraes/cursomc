package com.johnwick.cursomc.service.validation;

import com.johnwick.cursomc.domain.Cliente;
import com.johnwick.cursomc.domain.enums.TipoCliente;
import com.johnwick.cursomc.dto.ClienteNewDTO;
import com.johnwick.cursomc.repositories.ClienteRepository;
import com.johnwick.cursomc.resources.exceptions.FieldMessage;
import com.johnwick.cursomc.service.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository repo;

    @Override
    public void initialize(ClienteInsert ann) {
    }
    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCpf(objDto.getCpfOuCnpj()))  {
            list.add(new FieldMessage("cpfOuCnpj","invalido"));
        }

        if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCnpj(objDto.getCpfOuCnpj()))  {
            list.add(new FieldMessage("cpfOuCnpj","invalido"));
        }

        Cliente aux = repo.findByEmail(objDto.getEmail());
        if (aux != null) {
            list.add(new FieldMessage("email","Email ja existente"));
        }

// inclua os testes aqui, inserindo erros na lista
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}