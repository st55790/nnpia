package cz.upce.fei.cv01.controller;

import cz.upce.fei.cv01.domain.AppUser;
import cz.upce.fei.cv01.domain.Role;
import cz.upce.fei.cv01.repository.AppUserRepository;
import cz.upce.fei.cv01.repository.RoleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app-user")
public class AppUserController {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    public AppUserController(AppUserRepository appUserRepository, RoleRepository roleRepository) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("")
    public List<AppUser> findAll(){
        return appUserRepository.findAppUserByActiveEquals(true);
    }

    @GetMapping("/{roleId}")
    public List<AppUser> findAllUserByRole(@PathVariable Integer roleId){
        Role role = roleRepository.getRoleById(roleId.longValue());
        return appUserRepository.findAppUserByRolesEquals(role);
    }
}
