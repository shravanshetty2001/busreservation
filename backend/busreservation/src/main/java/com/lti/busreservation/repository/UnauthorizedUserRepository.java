package com.lti.busreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lti.busreservation.models.Unauthorizeduser;

public interface UnauthorizedUserRepository extends JpaRepository<Unauthorizeduser,Integer> {

}
