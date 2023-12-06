package dev.reilley.shared;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface PersistentObjectRepository<T extends PersistentObject> extends JpaRepository<T, Long> {
    Optional<T> findByUuid(UUID uuid);

    boolean existsByUuid(UUID uuid);
}
