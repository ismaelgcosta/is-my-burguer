package br.com.ismyburguer.core.validation;

import br.com.ismyburguer.core.adapter.ExistsByIdUseCase;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.UUID;

@Component
public class DomainReferenceValidator {
    private final ApplicationContext applicationContext;
    private ExistsByIdUseCase<?> useCase;

    public DomainReferenceValidator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void validate(Class<? extends ExistsByIdUseCase> useCaseClass, String campo, UUID entityId) {
        useCase = applicationContext.getBean(useCaseClass);
        if(!useCase.existsById(entityId)) {
            throw new ConstraintViolationException(MessageFormat.format("O(a) {0} informado(a) com o Id {1} não foi encontrado(a)", campo, entityId), null);
        }
    }
}