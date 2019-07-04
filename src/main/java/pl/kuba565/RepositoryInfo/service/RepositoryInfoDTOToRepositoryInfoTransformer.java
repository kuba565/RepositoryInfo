package pl.kuba565.RepositoryInfo.service;

import org.springframework.stereotype.Service;
import pl.kuba565.RepositoryInfo.model.RepositoryInfo;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;

import java.util.function.Function;

@Service
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
