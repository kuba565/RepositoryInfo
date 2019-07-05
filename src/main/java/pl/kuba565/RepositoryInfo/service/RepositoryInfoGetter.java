package pl.kuba565.RepositoryInfo.service;

import pl.kuba565.RepositoryInfo.exception.ValidationException;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;
import pl.kuba565.RepositoryInfo.model.RepositoryRequest;


public interface RepositoryInfoGetter {
    RepositoryInfoDTO getRepository(RepositoryRequest repositoryRequest) throws ValidationException;
}
