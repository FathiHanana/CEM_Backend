package com.codingcomrades.CEM_fullstack.controller;

import com.codingcomrades.CEM_fullstack.exception.InvoiceNotFoundException;

import com.codingcomrades.CEM_fullstack.model.Invoice;

import com.codingcomrades.CEM_fullstack.repository.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class InvoiceController {

    @Autowired

    private InvoiceRepository invoiceRepository;



    @PostMapping("/invoice")
    Invoice newInvoice(@RequestBody  Invoice newInvoice){

        return invoiceRepository.save( newInvoice);
    }

    @GetMapping("/invoices")
    List<Invoice> getAllInvoice() {

        return invoiceRepository.findAll();
    }

    @GetMapping("/invoice/{id}")
    Invoice getInvoiceById(@PathVariable Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException(id));
    }

    @PutMapping("/invoice/{id}")
    Invoice updateInvoice(@RequestBody Invoice newInvoice, @PathVariable Long id) {
        return invoiceRepository.findById(id)
                .map(invoice -> {

                    invoice.setOwnerid(newInvoice.getOwnerid());
                    invoice.setCreateddate(newInvoice.getCreateddate());
                    invoice.setDuedate(newInvoice.getDuedate());
                    invoice.setTotal(newInvoice.getTotal());
                    invoice.setDiscount(newInvoice.getDiscount());
                    invoice.setNetamount(newInvoice.getNetamount());



                    return invoiceRepository.save(invoice);
                }).orElseThrow(() -> new InvoiceNotFoundException(id));

                }


    @DeleteMapping("/invoice/{id}")
    String deleteInvoice(@PathVariable Long id){
        if(!invoiceRepository.existsById(id)){
            throw new InvoiceNotFoundException(id);
        }
        invoiceRepository.deleteById(id);
        return  "Invoice with id "+id+" has been deleted success.";
    }
    }

