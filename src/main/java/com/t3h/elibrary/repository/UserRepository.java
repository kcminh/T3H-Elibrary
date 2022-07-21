package com.t3h.elibrary.repository;

import com.t3h.elibrary.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {
    UserInfo getByEmail(String email);
    UserInfo getByUserId(int userId);
    @Query(value = "SELECT ui.* FROM users_information ui WHERE ui.user_type LIKE ?1", nativeQuery = true)
    List<UserInfo> listAllStudent(String student);

    @Query(value = "SELECT ui.* FROM users_information ui WHERE ui.username LIKE ?1", nativeQuery = true)
    UserInfo getStudentByUsername(String username);
    List<UserInfo> findByUsernameLikeIgnoreCase(String username);
}
