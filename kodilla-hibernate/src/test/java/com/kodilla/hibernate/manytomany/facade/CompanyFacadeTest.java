package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyFacadeTest {

    @Autowired
    private CompanyFacade companyFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void retrieveEmployeesWithFragmentTest() throws SearchExceptions {

        Employee employee1 = new Employee("Dominik", "Kowalski");
        Employee employee2 = new Employee("Marek", "Kondrad");

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        int employeeIdEmployee1 = employee1.getId();
        int employeeIdEmployee2 = employee2.getId();
        List<Employee> list = companyFacade.retrieveEmployeesWithFragment("owa");

        Assert.assertEquals(1, list.size());

        try {
            employeeDao.deleteById(employeeIdEmployee1);
            employeeDao.deleteById(employeeIdEmployee2);
        } catch (Exception e) {
            //some exception
        }
    }

    @Test
    public void retrieveCompaniesWithFragmentTest() throws SearchExceptions {

        Company Tesla = new Company("Tesla");
        Company KGHM = new Company("KGHM");

        companyDao.save(Tesla);
        companyDao.save(KGHM);
        int teslaId = Tesla.getId();
        int kghmId = KGHM.getId();
        List<Company> list = companyFacade.retrieveCompaniesWithFragment("sla");

        Assert.assertEquals(1, list.size());

        try {
            companyDao.deleteById(teslaId);
            companyDao.deleteById(kghmId);
        } catch (Exception e) {
            //some exception
        }
    }
}
