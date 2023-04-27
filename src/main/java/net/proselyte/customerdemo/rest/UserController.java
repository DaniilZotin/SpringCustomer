package net.proselyte.customerdemo.rest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.proselyte.customerdemo.dao.*;
import net.proselyte.customerdemo.model.*;
import net.proselyte.customerdemo.repo.CourseRepo;
import net.proselyte.customerdemo.repo.StudentRepo;
import net.proselyte.customerdemo.services.CustomerService;
import net.proselyte.customerdemo.services.DeveloperService;
import net.proselyte.customerdemo.services.GroupService;
import net.proselyte.customerdemo.services.OrderService;
import net.proselyte.customerdemo.services.implementations.DeveloperServiceImpl;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/api/v1/customers/")
@RequiredArgsConstructor
public class UserController {

//    @Autowired
    private final CustomerService customerService;

    private final OrderService orderService;

    private final CustomerDao customerDao;

    private final GroupDao groupDao;

    private final GroupService groupService;

    private final DeveloperService developerService;

    @GetMapping("/release")
    public String release(){
        System.out.println(customerService.getAll());
        return "Hello";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CustomerDao> getCustomers(@PathVariable("id") Long customerId){

        if(customerId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer customer = this.customerService.getById(customerId);

        if (customer == null){
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(CustomerDao.customerToCustomerDao(customer), HttpStatus.OK);//Це по старому так

    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid Customer customer){
        HttpHeaders httpHeaders = new HttpHeaders();
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.save(customer);

        return new ResponseEntity<>(customer, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "create", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid Customer customer){
        HttpHeaders httpHeaders = new HttpHeaders();

        if (customer == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.customerService.save(customer);

        return new ResponseEntity<>(customer, httpHeaders, HttpStatus.OK);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
        Customer customer = customerService.getById(id);

        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.customerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAll();

        if(customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "customerDao", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<CustomerDao>> getCustomerDao(){
        List<Customer> customers = customerService.getAll();
        List<CustomerDao> customerDaoList = customers.stream().map(CustomerDao::customerToCustomerDao).collect(Collectors.toList());
        // Це одне і те саме але різними шляхами, ми перетворили з просто кастомерів на ДАО кастомерів
//        customers.forEach(customer -> {
//            customerDaoList.add(customerDao.customerToCustomerDao(customer));
//
//        });


//        customerDao.setOrders(customer.getOrders().stream().map(OrderDao::toModel).collect(Collectors.toList()));
        //Це заготовка я вже замінив
        return new ResponseEntity<>(customerDaoList, HttpStatus.OK);
    }

    @RequestMapping(value = "createOrder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<OrderDao> createOrder(@RequestBody Order order, @RequestParam Long customerId){
        if(order == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(orderService.createOrder(order, customerId),HttpStatus.OK);
    }


    @RequestMapping(value = "allGroups", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<GroupDao>> getAllGroup(){

        List<Group> allGroups = new ArrayList<>();
        allGroups = groupService.getAll();
        List<GroupDao> allGroupsDao = new ArrayList<>();
        allGroups.forEach(group -> {
            allGroupsDao.add(GroupDao.toModel(group));
        });

        return new ResponseEntity<>( allGroupsDao, HttpStatus.OK);

    }


    @RequestMapping(value = "createGroup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Group> createGroup(@RequestBody @Valid Group group){
        HttpHeaders httpHeaders = new HttpHeaders();

        if (group == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        groupService.save(group);

        return new ResponseEntity<>(group,HttpStatus.OK);
    }


    @RequestMapping(value = "createDeveloper", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DeveloperDao> createDeveloper(@RequestBody Developer developer, @RequestParam Long groupId){
        if(developer == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(developerService.createDeveloper(developer,groupId), HttpStatus.OK);
    }

    private final CourseRepo courseRepo;

    private final StudentRepo studentRepo;


    @RequestMapping(value = "getCoursesByStudentId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<CourseDao>> getCourses(@RequestParam Long studentId){
        List<CourseDao> courses = courseRepo.findCourseByStudentsId(studentId)
                .stream().map(CourseDao::toModel).collect(Collectors.toList());

//        List<Student> students = studentRepo.findStudentsByCoursesId(1l);
//        System.out.println(students);


        return new ResponseEntity<>(courses, HttpStatus.OK);
    }




}
