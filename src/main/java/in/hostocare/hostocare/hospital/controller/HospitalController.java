package in.hostocare.hostocare.hospital.controller;

import in.hostocare.hostocare.hospital.entity.Hospital;
import in.hostocare.hostocare.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hospital/")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping("{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable("id") String id) {
        Hospital hospital = hospitalService.getHospitalById(id);
        return ResponseEntity.ok(hospital);
    }



}
