package in.hostocare.hostocare.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.hostocare.hostocare.hospital.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, String> {

    @Query("""
                SELECT h FROM Hospital h
                JOIN FETCH h.address
                WHERE h.hospitalId = :id
            """)
    Hospital findHospitalWithAddress(@Param("id") String id);

}
