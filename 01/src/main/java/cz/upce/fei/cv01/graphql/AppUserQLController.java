package cz.upce.fei.cv01.graphql;

import cz.upce.fei.cv01.domain.AppUser;
import cz.upce.fei.cv01.dto.AppUserDto;
import cz.upce.fei.cv01.errors.ResourceNotFoundException;
import cz.upce.fei.cv01.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

/*
* N+1 problém spočívá v dotazování, kdy při získávání dat z více tabulek dochází k opakovanému
* dotazování na stejné záznamy
*
* Anotací @BatchMapping je možné tento problém řešit. Anotace umožňuje seskupit více
* dotazů do jediného dotazu, což výrazně snižuje počet dotazů na DB
*
* GraphQL Subscription je mechanismus, který umožnuje klientovi se přihlásit k odběru dat
* a přijímat aktuílní informace v reálném čase
*
* A: Komunikace probíhá tak, že klient (příjemce) se přihlásí k odběru a server mu posílá poté
* odpovědi, které tomuto typu žádosti odpovídají
*
* B: @GraphQLSubscription
*
* C: Chatová aplikace, kde můžeme dostávat notifiakce o nových zprávách
*    E-SHOP můžeme se přihlásit k odběru notifikací při změně ceny produktu
*
* D: Je to protokol, který umožnuje dvěma stranám navázat trvalé spojení pro obousměrnou
*     komunikaci. GrahQL využívá web socket k odesílání notifikací.
*
* */

@Controller
@AllArgsConstructor
public class AppUserQLController {

    private final AppUserService appUserService;

    @QueryMapping
    public AppUserDto appUser(@Argument final Long id) throws ResourceNotFoundException {
        return appUserService.findById(id).toDto();
    }

    @MutationMapping
    public AppUserDto createAppUser(@Argument String username, @Argument String password){
        AppUser appUser = appUserService.create(new AppUser(username, password, false, LocalDateTime.now(), LocalDateTime.now()));
        return appUser.toDto();
    }
}
