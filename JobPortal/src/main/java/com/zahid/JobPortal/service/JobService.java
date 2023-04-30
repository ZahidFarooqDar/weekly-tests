package com.zahid.JobPortal.service;

import com.zahid.JobPortal.dao.JobRepository;
import com.zahid.JobPortal.model.Job;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Job not found with id " + id));
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(Long id, Job job) {
        Job existingJob = jobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Job not found with id " + id));

        existingJob.setTitle(job.getTitle());
        existingJob.setDescription(job.getDescription());
        existingJob.setLocation(job.getLocation());
        existingJob.setSalary(job.getSalary());
        existingJob.setCompanyName(job.getCompanyName());
        existingJob.setEmployerName(job.getEmployerName());
        existingJob.setJobType(job.getJobType());
        existingJob.setAppliedDate(job.getAppliedDate());

        return jobRepository.save(existingJob);
    }

    public void deleteJob(Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Job not found with id " + id));
        jobRepository.delete(job);
    }

    //custom query
    @Transactional
    public int updateJob(Long id, String title, Double salary) {
        return jobRepository.updateJob(id, title, salary);
    }

    //custom query
    @Transactional
    public int deleteJobCustom(Long id) {
        return jobRepository.deleteJob(id);
    }

}

