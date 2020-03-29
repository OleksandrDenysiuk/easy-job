package com.portfolio.easyjob.bootstrap;

import com.portfolio.easyjob.domain.*;
import com.portfolio.easyjob.repository.RoleRepository;
import com.portfolio.easyjob.repository.StatusOfDocumentRepository;
import com.portfolio.easyjob.repository.TypeOfDocumentRepository;
import com.portfolio.easyjob.repository.TypesOfMessageRepository;
import com.portfolio.easyjob.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserService userService;
    private final TypesOfMessageRepository typesOfMessageRepository;
    private final TypeOfDocumentRepository typeOfDocumentRepository;
    private final StatusOfDocumentRepository statusOfDocumentRepository;

    public DataLoader(RoleRepository roleRepository,
                      UserService userService,
                      TypesOfMessageRepository typesOfMessageRepository,
                      TypeOfDocumentRepository typeOfDocumentRepository,
                      StatusOfDocumentRepository statusOfDocumentRepository) {
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.typesOfMessageRepository = typesOfMessageRepository;
        this.typeOfDocumentRepository = typeOfDocumentRepository;
        this.statusOfDocumentRepository = statusOfDocumentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Set<Role> roles = new HashSet<>();
        roleRepository.findAll().forEach(roles::add);

        int count = roles.size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData(){
        Role userRole = new Role(1L,"USER");
        roleRepository.save(userRole);

        Role employeeRole = new Role(2L,"EMPLOYEE");
        roleRepository.save(employeeRole);

        Role employerRole = new Role(3L,"EMPLOYER");
        roleRepository.save(employerRole);

        Role adminRole = new Role(4L,"ADMIN");
        roleRepository.save(adminRole);

        TypeOfMessage verifyDocTypeMessage = new TypeOfMessage(1L,"VERIFY_DOC");
        typesOfMessageRepository.save(verifyDocTypeMessage);

        TypeOfMessage resultVerifyingTypeMessage = new TypeOfMessage(2L,"VERIFY_RESULT");
        typesOfMessageRepository.save(resultVerifyingTypeMessage);

        TypeOfDocument passportTypeDocument = new TypeOfDocument(1L, "PASSPORT");
        typeOfDocumentRepository.save(passportTypeDocument);

        TypeOfDocument photoUserTypeDocument = new TypeOfDocument(2L, "PHOTO_USER");
        typeOfDocumentRepository.save(photoUserTypeDocument);

        TypeOfDocument legitimationTypeDocument = new TypeOfDocument(3L, "LEGITIMATION");
        typeOfDocumentRepository.save(legitimationTypeDocument);

        StatusOfDocument verifiedStatusOfDocument = new StatusOfDocument(1L, "VERIFIED");
        statusOfDocumentRepository.save(verifiedStatusOfDocument);

        StatusOfDocument inProgressStatusOfDocument = new StatusOfDocument(2L, "IN_PROGRESS");
        statusOfDocumentRepository.save(inProgressStatusOfDocument);

        StatusOfDocument notVerifiedStatusOfDocument = new StatusOfDocument(3L, "NOT_VERIFIED");
        statusOfDocumentRepository.save(notVerifiedStatusOfDocument);


        User userEmployee = new User();
        userEmployee.setUsername("AlexEE");
        userEmployee.setPassword("1");

        userService.create(userEmployee,"employee");

        User userEmployer = new User();
        userEmployer.setUsername("AlexER");
        userEmployer.setPassword("1");

        userService.create(userEmployer,"employer");

        User userAdmin = new User();
        userAdmin.setUsername("admin");
        userAdmin.setPassword("1");

        userService.create(userAdmin,"admin");
    }
}
