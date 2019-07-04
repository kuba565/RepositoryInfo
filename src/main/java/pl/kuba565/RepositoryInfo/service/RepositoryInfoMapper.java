package pl.kuba565.RepositoryInfo.service;

import org.springframework.stereotype.Service;
import pl.kuba565.RepositoryInfo.model.RepositoryInfo;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;

@Service
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

    public RepositoryInfoDTO mapRepositoryInfoToRepositoryInfoDTO(RepositoryInfo input) {
        if (input != null) {
            return RepositoryInfoDTO.builder()
                    .clone_url(input.getCloneUrl())
                    .description(input.getDescription())
                    .created_at(input.getCreatedAt())
                    .full_name(input.getFullName())
                    .stargazers_count(input.getStars())
                    .build();
        }
        return null;
    }
}
