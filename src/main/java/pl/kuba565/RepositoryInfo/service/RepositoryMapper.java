package pl.kuba565.RepositoryInfo.service;

import pl.kuba565.RepositoryInfo.model.RepositoryInfo;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;

public interface RepositoryMapper {
    RepositoryInfo mapRepositoryInfo(RepositoryInfoDTO input);

}
