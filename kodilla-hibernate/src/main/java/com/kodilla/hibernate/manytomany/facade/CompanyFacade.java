package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class CompanyFacade {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

    public List<Company> retrieveCompaniesWithFragment(final String partOfName) throws SearchExceptions {
        LOGGER.info("Searching companies with part of name: " + partOfName);
        List<Company> result = companyDao.retrieveCompaniesWithFragment(partOfName);
        if (result.size() == 0) {
            LOGGER.error(SearchExceptions.ERR_COMPANY_NAME_NOT_FOUND);
            throw new SearchExceptions(SearchExceptions.ERR_COMPANY_NAME_NOT_FOUND);
        }
        return result;
    }

    public List<Employee> retrieveEmployeesWithFragment(final String partOfName) throws SearchExceptions {
        LOGGER.info("Searching employees with part of name: " + partOfName);
        List<Employee> result = employeeDao.retrieveEmployeesWithFragment(partOfName);
        if (result.size() == 0) {
            LOGGER.error(SearchExceptions.ERR_EMPLOYEE_NAME_NOT_FOUND);
            throw new SearchExceptions(SearchExceptions.ERR_EMPLOYEE_NAME_NOT_FOUND);
        }
        return result;
    }

}