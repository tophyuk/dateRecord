package com.tophyuk.dateRecord.repository;

import com.tophyuk.dateRecord.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
