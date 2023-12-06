package com.lipsoft.anonymize.code.service.database;

import com.lipsoft.anonymize.code.dto.AppUserDTO;
import com.lipsoft.anonymize.code.dto.AppUserResponseDTO;
import com.lipsoft.anonymize.code.entity.AddressEntity;
import com.lipsoft.anonymize.code.entity.UserEntity;
import com.lipsoft.anonymize.code.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    @Override
    public void saveUser(AppUserDTO appUserDTO) {
        UserEntity userEntity = UserEntity.builder()
                .username(appUserDTO.username())
                .email(appUserDTO.email())
                .addressEntities(Set.of(AddressEntity.builder().address("test").build()))
                .build();


        userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return null;
    }

    @Override
    public List<AppUserResponseDTO> getAllAppUsers() {
        List<UserEntity> allUsers = userRepository.findAll();

        return allUsers.stream().map(x -> new AppUserResponseDTO(x.getId(), x.getUsername(),
                x.getEmail(), x.getAddressEntities().stream().findFirst().orElseGet(() -> new AddressEntity()).getAddress())
        ).collect(Collectors.toList());
    }

    @Override
    public void removeById(Long id) {
        userRepository.deleteById(id);
    }

}
