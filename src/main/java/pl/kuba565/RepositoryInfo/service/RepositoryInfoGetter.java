package pl.kuba565.RepositoryInfo.service;

import pl.kuba565.RepositoryInfo.exception.ValidationException;
import pl.kuba565.RepositoryInfo.model.RepositoryInfo;
import pl.kuba565.RepositoryInfo.model.RepositoryRequest;


public interface RepositoryInfoGetter {
    RepositoryInfo getRepository(RepositoryRequest repositoryRequest) throws ValidationException;
}
