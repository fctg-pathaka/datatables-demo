package com.datatables.demo.repositories;

import com.datatables.demo.beans.Datatables;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface DatatablesRepo extends DataTablesRepository<Datatables, Long> {
}
