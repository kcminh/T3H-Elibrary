package com.t3h.elibrary.elb09;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReporsitory extends JpaRepository<UserInfo, Integer> {
    public UserInfo getByEmail(String email);
}
