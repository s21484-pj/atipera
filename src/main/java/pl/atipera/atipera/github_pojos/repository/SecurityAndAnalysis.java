package pl.atipera.atipera.github_pojos.repository;

import lombok.Data;

@Data
public class SecurityAndAnalysis {
    private AdvancedSecurity advanced_security;
    private DependabotSecurityUpdates dependabot_security_updates;
    private SecretScanning secret_scanning;
    private SecretScanningPushProtection secret_scanning_push_protection;
}
