package com.employee.employee4.service;

import com.employee.employee4.dto.EmployeeDto;
import com.employee.employee4.entity.Departement;
import com.employee.employee4.entity.Employee;
import com.employee.employee4.entity.Riwayatpend;
import com.employee.employee4.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    /*
    List<EmployeeDto> getAllEmployees();
    void createEmployee(EmployeeDto employee);

    EmployeeDto getEmployeeById(Long employeeId);

    void updateEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long employeeId);

     */
    //menampilkan semua data karyawan
    List<Employee> getAllEmployees();
    //menyimpan perubahan atau pembuatan data karyawan
    void saveEmployee(Employee employee);

    //menampilkan data karyawan ( per orang )
    Employee getEmployeeById(long id);

    // Menghapus data
    void deleteEmployeeById(long id);

    //Menampilkan data karyawan ( per orang , Optional untuk menghindari null value error,
    // data masih bisa ditampilkan walaupun ada null value )
    Optional<Employee> getKaryawanById(long id);




}
