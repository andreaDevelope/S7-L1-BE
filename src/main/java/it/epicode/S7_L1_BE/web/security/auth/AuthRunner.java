package it.epicode.S7_L1_BE.web.security.auth;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;
//@Component
public class AuthRunner implements ApplicationRunner {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Creazione dell'utente admin se non esiste
        Optional<AppUser> adminUser = appUserService.findByUsername("admin");
        if (adminUser.isEmpty()) {
            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.setNome("userNormal");
            registerRequest.setCognome("userCognome");
            registerRequest.setUsername("userName");
            registerRequest.setPassword("adminpwd");
            registerRequest.setEmail("admin@email");




            appUserService.registerUser(registerRequest, Set.of(Role.ROLE_ADMIN));
        }

        // Creazione dell'utente user se non esiste
        Optional<AppUser> normalUser = appUserService.findByUsername("user");
        if (normalUser.isEmpty()) {
            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.setNome("userNormal");
            registerRequest.setCognome("userCognome");
            registerRequest.setUsername("userName1");
            registerRequest.setPassword("adminpwd");
            registerRequest.setEmail("admin1@email");
        }
    }


}
