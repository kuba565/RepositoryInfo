package pl.kuba565.repositoryInfo.service;

import pl.kuba565.repositoryInfo.model.RepositoryInfo;
import pl.kuba565.repositoryInfo.model.RepositoryInfoDTO;

import java.util.function.Function;

public class RepositoryInfoDTOToRepositoryInfoTransformer implements Function<RepositoryInfoDTO, RepositoryInfo> {
    @Override
    public RepositoryInfo apply(RepositoryInfoDTO repositoryInfoDTO) {
        if (repositoryInfoDTO != null) {

            return RepositoryInfo.builder()
                    .cloneUrl(repositoryInfoDTO.getClone_url())
                    .description(repositoryInfoDTO.getDescription())
                    .createdAt(repositoryInfoDTO.getCreated_at())
                    .fullName(repositoryInfoDTO.getFull_name())
                    .stars(repositoryInfoDTO.getStargazers_count())
                    .build();
        }
        return null;
    }
}
