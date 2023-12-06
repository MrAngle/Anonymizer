package com.lipsoft.anonymize.code.service.database;

import com.lipsoft.anonymize.code.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    final AddressRepository addressRepository;

    @Override
    public void removeAddressById(Long id) {
        addressRepository.deleteById(id);
    }
}
