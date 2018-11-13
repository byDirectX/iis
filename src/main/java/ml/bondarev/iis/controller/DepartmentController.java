package ml.bondarev.iis.controller;

import ml.bondarev.iis.model.Department;
import ml.bondarev.iis.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public List<Department> getListDepartments() {
        return departmentService.getListDepartment();
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public void addDepartment(@ModelAttribute Department department) {
        if (department.getId() == 0) {
            departmentService.addDepartment(department);
            log.info("Department added successfully");
        } else {
            departmentService.updateDepartment(department);
            log.info("Department update successfully");
        }
    }

    @RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE)
    public void removeDepartment(@PathVariable("id") int id) {
        departmentService.removeDepartment(id);

        log.info("Department remove successfully");
    }

    @RequestMapping(value = "/department/{id}", method = RequestMethod.PUT)
    public Department getOneDepartment(@PathVariable("id") int id) {
        log.info("Department for edit issued successfully");

        return departmentService.getDepartmentById(id);
    }
}
