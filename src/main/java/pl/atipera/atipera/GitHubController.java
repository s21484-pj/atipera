package pl.atipera.atipera;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GitHubController {

    private final GitHubService gitHubService;

    @GetMapping("github/{username}")
    public ResponseEntity<List<GitHubResponse>> getGitHubUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(gitHubService.getGitHubUserInfo(username));
    }
}
