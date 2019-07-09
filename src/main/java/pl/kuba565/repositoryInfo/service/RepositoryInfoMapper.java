package pl.kuba565.repositoryInfo.service;

import pl.kuba565.repositoryInfo.model.RepositoryInfo;
import pl.kuba565.repositoryInfo.model.RepositoryInfoDTO;

public class RepositoryInfoMapper implements RepositoryMapper {
    public RepositoryInfo mapRepositoryInfo(RepositoryInfoDTO input) {
        if (input != null) {
            return RepositoryInfo.builder()
                    .cloneUrl(input.getClone_url())
                    .description(input.getDescription())
                    .createdAt(input.getCreated_at())
                    .fullName(input.getFull_name())
                    .stars(input.getStargazers_count())
                    .build();
        }
        return null;
    }
}
