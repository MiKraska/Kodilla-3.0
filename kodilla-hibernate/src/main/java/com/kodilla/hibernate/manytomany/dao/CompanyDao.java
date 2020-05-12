package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import javassist.bytecode.stackmap.TypeData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query(nativeQuery = true)
    List<Company> retrieveCompaniesBeginsFrom(@Param("COMPANY_NAME") String companyName);

    @Query
    List<Company> retrieveCompaniesWithFragment(@Param("PART_OF_NAME") String partOfName);
}
