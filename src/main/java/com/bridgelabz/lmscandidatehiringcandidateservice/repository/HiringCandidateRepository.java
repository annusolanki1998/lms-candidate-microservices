package com.bridgelabz.lmscandidatehiringcandidateservice.repository;

import com.bridgelabz.lmscandidatehiringcandidateservice.model.HiringCandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Purpose: Creating repository for hiringCandidate
 * @author: Annu Kumari
 * @Param:  To save in database
 * Version: 1.0
 */

public interface HiringCandidateRepository extends JpaRepository<HiringCandidateModel, Long> {
}
