package pl.kuba565.repositoryInfo.service;

import pl.kuba565.repositoryInfo.model.RepositoryInfo;
import pl.kuba565.repositoryInfo.model.RepositoryInfoDTO;

public interface RepositoryMapper {
    RepositoryInfo mapRepositoryInfo(RepositoryInfoDTO input);

}
