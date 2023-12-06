package com.lipsoft.anonymize.code.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Table(name = "app-user")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserEntity {

    @Id
    @SequenceGenerator(
            name = "app_user_id_sequence",
            sequenceName = "app_user_id_sequence"
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "app_user_id_sequence"
    )
    private Long id;

    private String username;

    private String email;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "user_id")
    private Set<AddressEntity> addressEntities;

    @CreationTimestamp
    @Column(name = "creation_at", nullable = false)
    private LocalDateTime createdAt;

    public static CustomUserEntity builder() {
        return new CustomUserEntity();
    }

    public static class CustomUserEntity extends UserEntityBuilder {

        @Override
        public UserEntity build() {
            UserEntity userEntity = super.build();
            userEntity.getAddressEntities().forEach(x -> x.setUserEntity(userEntity));
            return userEntity;
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UserEntity that = (UserEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
