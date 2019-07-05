package pl.kuba565.RepositoryInfo.validation;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.kuba565.RepositoryInfo.model.RepositoryRequest;

@Service
public class RepositoryRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return RepositoryRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owner", "owner is null or whitespace");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repositoryName", "repositoryName is null or whitespace");
    }
}
