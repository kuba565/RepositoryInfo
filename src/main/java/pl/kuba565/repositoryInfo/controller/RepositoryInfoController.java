package pl.kuba565.repositoryInfo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kuba565.repositoryInfo.model.RepositoryInfo;
import pl.kuba565.repositoryInfo.model.RepositoryRequest;
import pl.kuba565.repositoryInfo.service.GithubRepositoryInfoGetter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/")
@Validated
public class RepositoryInfoController {
    private final GithubRepositoryInfoGetter githubRepositoryInfoGetter;

    public RepositoryInfoController(
            GithubRepositoryInfoGetter githubRepositoryInfoGetter
    ) {
        this.githubRepositoryInfoGetter = githubRepositoryInfoGetter;
    }

    @GetMapping("repositories/{owner}/{repository-name}")
    public ResponseEntity<RepositoryInfo> getRepository(@PathVariable(value = "owner") @NotBlank @NotNull String owner,
                                                        @PathVariable(value = "repository-name") @NotNull @NotBlank String repositoryName) {
        RepositoryRequest repositoryRequest = new RepositoryRequest(owner, repositoryName);
        RepositoryInfo repositoryInfo = githubRepositoryInfoGetter.getRepository(repositoryRequest);

        return ResponseEntity.ok(repositoryInfo);
    }


}
