package pl.kuba565.RepositoryInfo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kuba565.RepositoryInfo.model.RepositoryInfo;
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
        RepositoryInfo repositoryInfo = githubRepositoryGetter.getRepository(owner, repositoryName); // TODO: USE DTO

        return ResponseEntity.ok(repositoryInfo);
    }
}
