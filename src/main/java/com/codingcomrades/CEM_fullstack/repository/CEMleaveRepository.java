package com.codingcomrades.CEM_fullstack.repository;

import com.codingcomrades.CEM_fullstack.model.CEMleave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CEMleaveRepository extends JpaRepository <CEMleave,Long> {
}
