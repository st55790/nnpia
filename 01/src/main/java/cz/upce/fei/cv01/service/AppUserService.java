package cz.upce.fei.cv01.service;

import cz.upce.fei.cv01.domain.AppUser;
import cz.upce.fei.cv01.dto.AppUserResponseEntityDto;
import cz.upce.fei.cv01.errors.ResourceNotFoundException;
import cz.upce.fei.cv01.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUser findByName(String username){
        return appUserRepository.findAppUserByUsername(username);
    }

    @Transactional()
    public AppUser findById(final Long id) throws ResourceNotFoundException {
        var appUser = appUserRepository.findById(id);

        if (appUser.isEmpty()){
            throw new ResourceNotFoundException();
        }

        return appUser.get();
    }

    @Transactional()
    public List<AppUser> findAppUserByActiveEquals(boolean b) {
        return appUserRepository.findAppUserByActiveEquals(b);
    }

    @Transactional
    public AppUser create(final AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Transactional
    public void delete(Long id){
        appUserRepository.deleteAppUserById(id);
    }

    @Transactional
    public void update(Long id, AppUserResponseEntityDto dto) throws ResourceNotFoundException {
        var item = findById(id);
        appUserRepository.save(new AppUser(
                id,
                dto.getUsername(),
                dto.getPassword(),
                dto.getActive(),
                dto.getCreationDate(),
                dto.getUpdateDate()
        ));
    }
}
