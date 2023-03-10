package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.model.dto.CreatePatientDto;
import com.siit.hospital_manager.model.dto.PatientDto;
import com.siit.hospital_manager.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mvc/patient")
@RequiredArgsConstructor
public class PatientMVCController {

    private final PatientService patientService;
    @GetMapping("viewAll")
    public String getAllPatients(Model model){
        List<PatientDto> patientsList = patientService.findAll();
        model.addAttribute("patients", patientsList);
        return "patient/viewAll";
    }

    @PostMapping(value = "/submit")
    public String createPatient(@Valid @ModelAttribute("createPatientDto") CreatePatientDto createPatientDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            //return to error page if there are validation errors
            return "validationError";
        }
        patientService.createPatient(createPatientDto);
        model.addAttribute("createPatientDto", createPatientDto);
        return "success";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        CreatePatientDto createPatientDto = new CreatePatientDto();

        model.addAttribute("createPatientDto", createPatientDto);
        return "patient/create";
    }


}
