package com.gestionemployes.api.service;

import com.gestionemployes.api.model.Periode;
import com.gestionemployes.api.repository.PeriodeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class PeriodeService {

    @Autowired
    private PeriodeRepository periodeRepository;

    public Optional<Periode> getPeriode(final Long id) {
        return periodeRepository.findById(id);
    }

    public Iterable<Periode> getPeriodes() {
        return periodeRepository.findAll();
    }

    public void deletePeriode(final Long id) {
        periodeRepository.deleteById(id);
    }

    public Periode savePeriode(Periode periode) {
        Periode savedPeriode = periodeRepository.save(periode);
        return periode;
    }
}
