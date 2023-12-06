package com.lipsoft.anonymize.code.repository;

import com.lipsoft.anonymize.code.entity.AddressEntity;
import com.lipsoft.anonymize.code.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
