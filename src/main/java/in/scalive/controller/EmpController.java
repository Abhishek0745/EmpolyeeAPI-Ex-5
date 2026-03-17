package in.scalive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.scalive.model.Emp;
import in.scalive.service.EmpService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/emps")
public class EmpController {

    private EmpService serv;

    @Autowired
    public EmpController(EmpService serv) {
        this.serv = serv;
    }

    // ADD EMPLOYEE
    @PostMapping("/add")
    public String addEmp(@RequestBody @Valid Emp empToAdd) {
        return serv.addEmp(empToAdd );
    }

    // UPDATE EMPLOYEE
    @PutMapping("/update/{empId}")
    public String updateEmp(@PathVariable Integer empId, @RequestBody Emp updatedemp) {
        return serv.updateEmp(updatedemp, empId);
    }

    // GET ALL EMPLOYEES
    @GetMapping("/{empId}")
    public Emp getEmp(@PathVariable("empId") Integer empId) {
        return serv.getEmp(empId);
        
    }
   
}