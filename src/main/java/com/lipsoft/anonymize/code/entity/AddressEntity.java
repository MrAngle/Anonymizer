package com.lipsoft.anonymize.code.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "app-address")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AddressEntity {

    @Id
    @SequenceGenerator(
            name = "app_address_id_sequence",
            sequenceName = "app_address_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "app_address_id_sequence"
    )
    private Long id;

    private String address;

    public void setUserEntity(UserEntity userEntity) {
        if (this.userEntity == null) {
            this.userEntity = userEntity;
        }
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
