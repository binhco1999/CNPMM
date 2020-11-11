package com.macia.HRs.repository;
import com.macia.HRs.entity.User_Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivityRepository extends JpaRepository<User_Activity, Integer> {
}

