package pl.atipera.atipera;

import lombok.Data;
import pl.atipera.atipera.dto.BranchDTO;

import java.util.List;

@Data
public class GitHubResponse {

    private String repositoryName;

    private String ownerLogin;

    private List<BranchDTO> branchDTOs;
}
