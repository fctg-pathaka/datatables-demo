package com.datatables.demo;


import com.datatables.demo.beans.Datatables;
import com.datatables.demo.exceptions.DatatablesDemoException;
import com.datatables.demo.repositories.DatatablesRepo;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatatablesService {
    @Autowired
    private DatatablesRepo DatatablesRepo;

    public Datatables saveDatatables(Datatables form) {
        try {
            if (NumberUtils.isDigits(String.valueOf(form.getId()))) {
                form.setUpdatedStamp(LocalDateTime.now());
            } else {
                form.setCreatedStamp(LocalDateTime.now());
            }
            return DatatablesRepo.save(form);
        } catch (DatatablesDemoException e) {
            return new Datatables();
        }
    }

    public DataTablesOutput<Datatables> getPaginatedDatatables(DataTablesInput input) {
        return DatatablesRepo.findAll(input);
    }

    public Optional<Datatables> getDatatablesById(Long id) {
        return DatatablesRepo.findById(id);
    }

    public void deleteById(Long id) {
        DatatablesRepo.deleteById(id);
    }

    public List<Datatables> fetchAllDatatables() {
        return Streamable.of(DatatablesRepo.findAll()).toList();
    }
}
