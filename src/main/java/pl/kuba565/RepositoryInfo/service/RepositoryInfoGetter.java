package pl.kuba565.RepositoryInfo.service;

import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;

public interface RepositoryInfoGetter {
    RepositoryInfoDTO getRepository(String owner, String repositoryName);
}
