package pl.kuba565.RepositoryInfo.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import pl.kuba565.RepositoryInfo.client.HttpClient;
import pl.kuba565.RepositoryInfo.exception.ValidationException;
import pl.kuba565.RepositoryInfo.model.RepositoryInfo;
import pl.kuba565.RepositoryInfo.model.RepositoryRequest;
import pl.kuba565.RepositoryInfo.util.UrlUtil;
import pl.kuba565.RepositoryInfo.validation.RepositoryRequestValidator;

import java.util.List;

@Service
public class GithubRepositoryInfoGetter implements RepositoryInfoGetter {
    private HttpClient httpClient;
    private RepositoryRequestValidator repositoryRequestValidator;
    private RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer;

    public GithubRepositoryInfoGetter(HttpClient httpClient,
                               RepositoryRequestValidator repositoryRequestValidator,
                               RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer) {
        this.httpClient = httpClient;
        this.repositoryRequestValidator = repositoryRequestValidator;
        this.repositoryInfoDTOToRepositoryInfoTransformer = repositoryInfoDTOToRepositoryInfoTransformer;
    }

    public RepositoryInfo getRepository(RepositoryRequest repositoryRequest) {
        List<ObjectError> errors = validate(repositoryRequest);
        if (errors.size() > 0) {
            throw new ValidationException(errors);
        } else {
            return repositoryInfoDTOToRepositoryInfoTransformer.apply(httpClient.get(UrlUtil.getUrl(repositoryRequest)));
        }
    }

    private List<ObjectError> validate(RepositoryRequest repositoryRequest) {
        Errors errors = new BeanPropertyBindingResult(repositoryRequest, "repositoryRequest");
        repositoryRequestValidator.validate(repositoryRequest, errors);

        return errors.getAllErrors();
    }
}
