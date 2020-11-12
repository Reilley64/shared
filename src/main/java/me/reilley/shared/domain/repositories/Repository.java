package me.reilley.shared.domain.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface Repository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {
    Optional<T> findByUuid(UUID uuid);

    boolean existsByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);
}
