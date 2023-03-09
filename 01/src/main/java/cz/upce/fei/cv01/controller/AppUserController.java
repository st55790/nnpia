package cz.upce.fei.cv01.controller;

import cz.upce.fei.cv01.domain.AppUser;
import cz.upce.fei.cv01.dto.AppUserCreateDto;
import cz.upce.fei.cv01.dto.AppUserDto;
import cz.upce.fei.cv01.dto.AppUserResponseEntityDto;
import cz.upce.fei.cv01.service.AppUserService;
import cz.upce.fei.cv01.errors.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app-user")
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping("")
    public List<AppUser> findAll(){
        return appUserService.findAppUserByActiveEquals(true);
    }

    @GetMapping("/{id}")
    public ResponseEntity getInfoAboutAppUser(@PathVariable Long id) throws ResourceNotFoundException {
        var result = appUserService.findById(id);

        return ResponseEntity.ok(toDto(result));
    }

    @PostMapping("/")
    public ResponseEntity createAppUser(@RequestBody @Validated AppUserCreateDto dto){
        var result = appUserService.create(toEntity(dto));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toDto(result));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAppUser(@PathVariable Long id, @RequestBody final AppUserResponseEntityDto dto) throws ResourceNotFoundException {
        appUserService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAppUser(@PathVariable Long id){
        appUserService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private static AppUser toEntity(AppUserCreateDto dto){
        return new AppUser(
                dto.getUsername(),
                dto.getPassword(),
                dto.getActive(),
                dto.getCreationDate(),
                dto.getUpdateDate()
        );
    }

    //DTO budou využívány v semestrální práci, můžeme použít ale Mapper
    private static AppUserDto toDto(final AppUser appUser){
        return new AppUserDto(
                appUser.getId(),
                appUser.getUsername(),
                appUser.getPassword(),
                appUser.getActive(),
                appUser.getCreationDate(),
                appUser.getUpdateDate()
        );
    }
}
