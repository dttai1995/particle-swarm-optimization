package payroll.assembler;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;
import payroll.Employee;
import payroll.controller.EmployeeController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class EmployeeResourceAssembler implements ResourceAssembler<Employee, Resource> {
    @Override
    public Resource toResource(Employee employee) {
        return new Resource(employee, linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel());
    }
}
