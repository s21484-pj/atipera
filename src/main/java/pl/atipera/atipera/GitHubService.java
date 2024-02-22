package pl.atipera.atipera;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.atipera.atipera.dto.BranchDTO;
import pl.atipera.atipera.github_pojos.branch.Branch;
import pl.atipera.atipera.github_pojos.repository.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GitHubService {

    private final RestTemplate restTemplate;

    public List<GitHubResponse> getGitHubUserInfo(String username) {
        List<GitHubResponse> gitHubResponseList = new ArrayList<>();
        List<Repository> repositories = getUserRepositoriesWithoutForks(username);
        for (Repository repository : repositories) {
            List<BranchDTO> branchDTOs = getBranchInfo(username, repository.getName());
            GitHubResponse gitHubResponse = new GitHubResponse();
            gitHubResponse.setRepositoryName(repository.getName());
            gitHubResponse.setOwnerLogin(repository.getOwner() != null ? repository.getOwner().getLogin() : null);
            gitHubResponse.setBranchDTOs(branchDTOs);
            gitHubResponseList.add(gitHubResponse);
        }
        return gitHubResponseList;
    }

    private List<Repository> getUserRepositoriesWithoutForks(String username) {
        List<Repository> repositories = new ArrayList<>();
        String url = "https://api.github.com/users/" + username + "/repos";
        HttpEntity<String> httpEntity = getHttpEntity();
        try {
            ResponseEntity<Repository[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Repository[].class);
            if (response.getBody() != null) {
                Arrays.stream(response.getBody())
                        .filter(repo -> !repo.isFork())
                        .forEach(repositories::add);
            }
        } catch (RestClientException exception) {
            throw new RestClientException("User " + username + " does not exist.");
        }
        return repositories;
    }

    private List<BranchDTO> getBranchInfo(String owner, String repo) {
        List<BranchDTO> branchDTOs = new ArrayList<>();
        String url = "https://api.github.com/repos/" + owner + "/" + repo + "/branches";
        HttpEntity<String> httpEntity = getHttpEntity();
        ResponseEntity<Branch[]> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Branch[].class);
        if (response.getBody() != null) {
            Arrays.stream(response.getBody())
                    .forEach(branch -> {
                BranchDTO branchDTO = new BranchDTO();
                branchDTO.setName(branch.getName());
                branchDTO.setSha(branch.getCommit() != null ? branch.getCommit().getSha() : null);
                branchDTOs.add(branchDTO);
            });
        }
        return branchDTOs;
    }

    private HttpEntity<String> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        return new HttpEntity<>(headers);
    }
}
