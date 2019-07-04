package pl.kuba565.RepositoryInfo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kuba565.RepositoryInfo.model.RepositoryInfo;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;
import pl.kuba565.RepositoryInfo.service.GithubRepositoryInfoGetter;
import pl.kuba565.RepositoryInfo.service.RepositoryInfoDTOToRepositoryInfoTransformer;
import pl.kuba565.RepositoryInfo.service.RepositoryInfoMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/")
@Validated
public class RepositoryInfoController {
    private final GithubRepositoryInfoGetter githubRepositoryInfoGetter;
    private final RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer;
    private final RepositoryInfoMapper repositoryInfoMapper;

    public RepositoryInfoController(
            GithubRepositoryInfoGetter githubRepositoryInfoGetter,
            RepositoryInfoMapper repositoryInfoMapper,
            RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer
    ) {
        this.githubRepositoryInfoGetter = githubRepositoryInfoGetter;
        this.repositoryInfoMapper = repositoryInfoMapper;
        this.repositoryInfoDTOToRepositoryInfoTransformer = repositoryInfoDTOToRepositoryInfoTransformer;
    }

    @GetMapping("repositories/{owner}/{repository-name}")
    public ResponseEntity<RepositoryInfo> getRepository(@PathVariable(value = "owner") @NotBlank String owner, @PathVariable(value = "repository-name") @NotBlank String repositoryName) {
        RepositoryInfoDTO repositoryInfoDTO = githubRepositoryInfoGetter.getRepository(owner, repositoryName);

//        RepositoryInfo repositoryInfo = repositoryInfoMapper.mapRepositoryInfo(repositoryInfoDTO);
        RepositoryInfo repositoryInfo = repositoryInfoDTOToRepositoryInfoTransformer.apply(repositoryInfoDTO);


        return ResponseEntity.ok(repositoryInfo);
    }


}
