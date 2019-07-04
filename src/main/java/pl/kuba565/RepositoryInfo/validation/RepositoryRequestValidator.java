package pl.kuba565.RepositoryInfo.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.kuba565.RepositoryInfo.model.RepositoryRequest;

public class RepositoryRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return RepositoryRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RepositoryRequest repositoryRequest = (RepositoryRequest) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, ((RepositoryRequest) o).getOwner(), "owner is null or whitespace");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, ((RepositoryRequest) o).getOwner(), "owner is null or whitespace");
    }
}
