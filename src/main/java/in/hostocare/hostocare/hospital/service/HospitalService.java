package in.hostocare.hostocare.hospital.service;

import in.hostocare.hostocare.hospital.entity.Hospital;
import in.hostocare.hostocare.hospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    public Hospital getHospitalById(String id) {
        Hospital hospital = hospitalRepository.findHospitalWithAddress(id);
        if (hospital == null) {
            throw new RuntimeException("Hospital not found with id: " + id);
        }
        return hospital;
    }
}
