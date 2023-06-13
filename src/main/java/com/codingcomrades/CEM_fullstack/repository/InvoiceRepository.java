package com.codingcomrades.CEM_fullstack.repository;

import com.codingcomrades.CEM_fullstack.model.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository <Invoice,Long> {
}
