package pl.kuba565.RepositoryInfo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kuba565.RepositoryInfo.model.RepositoryInfo;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;
import pl.kuba565.RepositoryInfo.service.GithubRepositoryGetter;

@RestController
@RequestMapping("/")
public class RepositoryInfoController {
    private final GithubRepositoryGetter githubRepositoryGetter;

    public RepositoryInfoController(GithubRepositoryGetter githubRepositoryGetter) {
        this.githubRepositoryGetter = githubRepositoryGetter;
    }

    @GetMapping("repositories/{owner}/{repository-name}")
    public ResponseEntity<RepositoryInfo> getRepository(@PathVariable(value = "owner") String owner, @PathVariable(value = "repository-name") String repositoryName) {
        RepositoryInfoDTO repositoryInfoDTO = githubRepositoryGetter.getRepository(owner, repositoryName); // TODO: USE DTO

        RepositoryInfo repositoryInfo = mapRepositoryInfo(repositoryInfoDTO);

        return ResponseEntity.ok(repositoryInfo);
    }

    private RepositoryInfo mapRepositoryInfo(RepositoryInfoDTO input) {

        return RepositoryInfo.builder()
                .cloneUrl(input.getClone_url())
                .description(input.getDescription())
                .createdAt(input.getCreated_at())
                .fullName(input.getFull_name())
                .stars(input.getStargazers_count())
                .build();
    }
}
