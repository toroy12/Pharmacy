package SearchPharmacy.pharmacy.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import SearchPharmacy.pharmacy.entity.Pharmacy;
import SearchPharmacy.pharmacy.repository.PharmacyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PharmacyRepositoryService {
	private final PharmacyRepository pharmacyRepository;
	
	@Transactional
	public void updateAddress(Long id, String address) {
		Pharmacy entity = pharmacyRepository.findById(id).orElse(null);
		
		if(Objects.isNull(entity)) {
			log.error("[PharmacyRepositoryService updateAddress] not found id: {}", id);
			return;
		}
		
		entity.changePharmacyAddress(address);
	}
}
