package com.bridgelabz.lmscandidatehiringcandidateservice.repository;

import com.bridgelabz.lmscandidatehiringcandidateservice.model.HiringCandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HiringCandidateRepository extends JpaRepository<HiringCandidateModel, Long> {
}
