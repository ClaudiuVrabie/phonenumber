package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.model.dto.*;
import com.siit.hospital_manager.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientDto> findAll(){
        return patientService.findAll();
    }

    @GetMapping("{id}")
    public PatientDto findById(@PathVariable("id") Integer id) {
        return patientService.findById(id);
    }

    @PostMapping
    public void createPatient(@RequestBody @Valid CreatePatientDto createPatientDto){
        patientService.createPatient(createPatientDto);
    }

    @PatchMapping
    public void updatePatient(@RequestBody @Valid UpdatePatientDto updatePatientDto){
        patientService.updatePatient(updatePatientDto);
    }

}
