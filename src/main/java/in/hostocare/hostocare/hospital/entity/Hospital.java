package in.hostocare.hostocare.hospital.entity;

import in.hostocare.hostocare.common.entity.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hospital")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hospital {
    
    @Id
    @Column(name = "hospital_id", nullable = false)
    private String hospitalId;
    
    @Column(name = "hospital_name", nullable = false)
    private String hospitalName;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;
    
}
