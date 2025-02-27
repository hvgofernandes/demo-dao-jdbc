package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1 department insert ===");
        Department newDepartment = new Department(null, "Toys");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New department = " + newDepartment.getName());
        System.out.println(newDepartment);

        System.out.println("=== TEST 2 department update ===");
        newDepartment.setName("Videogames");
        departmentDao.update(newDepartment);
        System.out.println("Sucess! Department name updated.");

        System.out.println("=== TEST 3 department delete ===");
        System.out.print("Enter department ID for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Sucess! Department deleted. ");
        sc.close();

        System.out.println("=== TEST 4 department findById ===");
        Department department2 = departmentDao.findById(2);
        System.out.println(department2);

        System.out.println("=== TEST 5 department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }
    }
}
