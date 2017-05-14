package SWEProjectphase2.Service;

import org.springframework.data.repository.CrudRepository;

import SWEProjectphase2.Model.Student;



public interface StudentRepository  extends CrudRepository<Student,String> {

}
