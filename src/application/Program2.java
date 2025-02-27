package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
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
    }
}
