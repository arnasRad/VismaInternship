package com.arnasrad.vismainternship.mapper.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.CitizenshipDTO;
import com.arnasrad.vismainternship.model.entity.customer.Citizenship;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CitizenshipMapper {

    public CitizenshipDTO mapToDTO(Citizenship entity) {
        return new CitizenshipDTO(entity.getCountryOfCitizenship());
    }

    public Citizenship mapToEntity(CitizenshipDTO dto) {
        return new Citizenship(dto.getCountryOfCitizenship());
    }

    public List<CitizenshipDTO> mapToDTOArray(List<Citizenship> citizenships) {
        List<CitizenshipDTO> citizenshipDTOS = new ArrayList<>();

        for (Citizenship citizenship : citizenships) {
            citizenshipDTOS.add(mapToDTO(citizenship));
        }

        return citizenshipDTOS;
    }

    public List<Citizenship> mapToEntityList(List<CitizenshipDTO> citizenshipDTOS) {
        List<Citizenship> citizenships = new ArrayList<>();

        for(CitizenshipDTO citizenshipDTO : citizenshipDTOS) {
            citizenships.add(mapToEntity(citizenshipDTO));
        }

        return citizenships;
    }
}
