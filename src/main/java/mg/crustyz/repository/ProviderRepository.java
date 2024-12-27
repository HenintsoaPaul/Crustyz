package mg.crustyz.repository;

import mg.crustyz.entity.supply.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
}
