package pl.kuba565.repositoryInfo.service;

import pl.kuba565.repositoryInfo.exception.ValidationException;
import pl.kuba565.repositoryInfo.model.RepositoryInfo;
import pl.kuba565.repositoryInfo.model.RepositoryRequest;


public interface RepositoryInfoGetter {
    RepositoryInfo getRepository(RepositoryRequest repositoryRequest) throws ValidationException;
}
