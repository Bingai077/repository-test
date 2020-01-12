package cn.bingai.practice01.demo03.project3pro.junit;


import cn.bingai.practice01.demo03.project3pro.domain.Employee;
import cn.bingai.practice01.demo03.project3pro.service.NameListService;
import cn.bingai.practice01.demo03.project3pro.service.TeamException;
import org.junit.Test;

import java.util.Arrays;

public class NameListServiceTest {

    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] allEmployees = service.getAllEmployees();
        for (int i = 0; i < allEmployees.length; i++) {
            System.out.println(allEmployees[i] + "\t");
        }
    }

    @Test
    public void getEmployee(){
        NameListService service = new NameListService();
        int id = 12;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

}
