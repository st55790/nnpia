package cz.upce.fei.cv01.repository;

import cz.upce.fei.cv01.domain.AppUser;
import cz.upce.fei.cv01.domain.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Long> {
    List<AppUser> findAppUserByActiveEquals(Boolean active);

    @Query("SELECT appUser FROM AppUser appUser inner join appUser.roles role where role = :role")
    List<AppUser> findAppUserByRolesEquals(Role role);
}
