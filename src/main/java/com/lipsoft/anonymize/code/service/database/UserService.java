package com.lipsoft.anonymize.code.service.database;

import com.lipsoft.anonymize.code.dto.AppUserDTO;
import com.lipsoft.anonymize.code.dto.AppUserResponseDTO;
import com.lipsoft.anonymize.code.entity.UserEntity;

import java.util.List;
import java.util.Set;


public interface UserService {

    void saveUser(final AppUserDTO userEntity);

    UserEntity getUserById(final Long id);
    List<AppUserResponseDTO> getAllAppUsers();

    void removeById(Long id);


//    @Transactional(isolation = Isolation.READ_COMMITTED)
//    public void doSomething() {
//        // Twoja logika biznesowa
//    }

}
