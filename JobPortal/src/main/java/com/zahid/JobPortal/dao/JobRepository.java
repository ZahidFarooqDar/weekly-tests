package com.zahid.JobPortal.dao;

import com.zahid.JobPortal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    @Modifying
    @Query(value = "UPDATE Job j SET j.title = :title, j.salary = :salary WHERE j.id = :id")
    int updateJob(@Param("id") Long id, @Param("title") String title, @Param("salary") Double salary);

    @Modifying
    @Query(value = "DELETE FROM Job j WHERE j.id = :id")
    int deleteJob(@Param("id") Long id);
}
