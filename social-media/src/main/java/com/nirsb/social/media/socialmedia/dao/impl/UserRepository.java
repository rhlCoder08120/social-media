package com.nirsb.social.media.socialmedia.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nirsb.social.media.socialmedia.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
