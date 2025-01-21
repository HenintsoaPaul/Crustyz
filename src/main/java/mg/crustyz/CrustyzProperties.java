package mg.crustyz;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties( prefix = "app" )
public class CrustyzProperties {
    private int idMvtSortie;
    private int idMvtEntree;
    private double tauxCommission;
}
