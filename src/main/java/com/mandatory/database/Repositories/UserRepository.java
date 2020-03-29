package com.mandatory.database.Repositories;

import com.mandatory.database.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>
{
    UserEntity getUserEntityByUserId(Long userId);
}
