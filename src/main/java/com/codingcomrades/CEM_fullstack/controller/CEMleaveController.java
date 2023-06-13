package com.codingcomrades.CEM_fullstack.controller;

import com.codingcomrades.CEM_fullstack.exception.CEMleaveNotFoundException;

import com.codingcomrades.CEM_fullstack.model.CEMleave;

import com.codingcomrades.CEM_fullstack.repository.CEMleaveRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")

public class CEMleaveController {

    @Autowired

    private CEMleaveRepository cemleaveRepository;

    @PostMapping("/leave")
    CEMleave newCEMleave(@RequestBody CEMleave newCEMleave){

        return cemleaveRepository.save( newCEMleave);
    }

    @GetMapping("/leaves")
    List<CEMleave> getAllCEMleave() {

        return cemleaveRepository.findAll();
    }

    @GetMapping("/leave/{id}")
    CEMleave getCEMleaveById(@PathVariable Long id) {
        return cemleaveRepository.findById(id)
                .orElseThrow(() -> new CEMleaveNotFoundException(id));
    }

    @PutMapping("/leave/{id}")
    CEMleave updateCEMleave(@RequestBody CEMleave newCEMleave, @PathVariable Long id) {
        return cemleaveRepository.findById(id)
                .map(cemleave -> {

                    cemleave.setEid(newCEMleave.getEid());

                    cemleave.setLeavetype(newCEMleave.getLeavetype());
                    cemleave.setStartdate(newCEMleave.getStartdate());
                    cemleave.setEnddate(newCEMleave.getEnddate());
                    cemleave.setLeavestatus(newCEMleave.getLeavestatus());
                    cemleave.setNoOfDays(newCEMleave.getNoOfDays());
                    return cemleaveRepository.save(cemleave);
                }).orElseThrow(() -> new CEMleaveNotFoundException(id));
    }
    @PutMapping("/leave/{id}/{leaveStatus}")
    CEMleave updateCEMleaveStatus( @PathVariable Long id,@PathVariable String leaveStatus) {
        return cemleaveRepository.findById(id)
                .map(cemleave -> {
                    cemleave.setLeavestatus(leaveStatus);
                    return cemleaveRepository.save(cemleave);
                }).orElseThrow(() -> new CEMleaveNotFoundException(id));
    }

    @DeleteMapping("/leave/{id}")
    String deleteCEMleave(@PathVariable Long id){
        if(!cemleaveRepository.existsById(id)){
            throw new CEMleaveNotFoundException(id);
        }
        cemleaveRepository.deleteById(id);
        return  "CEMleave with id "+id+" has been deleted success.";
    }




}
