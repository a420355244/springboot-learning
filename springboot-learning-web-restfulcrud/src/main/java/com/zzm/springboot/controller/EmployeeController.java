package com.zzm.springboot.controller;

import com.zzm.springboot.dao.DepartmentDao;
import com.zzm.springboot.dao.EmployeeDao;
import com.zzm.springboot.entities.Department;
import com.zzm.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;


    // 查询所有的员工信息
    // 注：这里的参数使用的是model而不是ModelAndView
    @GetMapping("/emps")
    public String listEmps(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps" , employees);
        return "emp/list";
    }

    // 查询单个雇员
    @GetMapping("/emp/{id}")
    public String queryEmp(@PathVariable("id") Integer id, Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        return "emp/add";
    }

    // 修改员工
    @PutMapping("/emp")
    public String updateEmp(Employee emp){
        employeeDao.save(emp);
        return "redirect:/emps.html";
    }

    // 删除员工
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps.html";
    }



}
