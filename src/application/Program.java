package application;

import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import java.util.List;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(4);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New ID = " + newSeller.getId());
        System.out.println(newSeller); // No ToString() ele imprime a data completa

        System.out.println("=== TEST 5: seller update ===");
        // Na primeira vez que testei, deu DbException (tinha errado na SQL syntax), porém o interessante foi que, tudo
        // antes da exceção foi executado, nesse tipo de caso, teriamos que usar o commit/rollback?
        seller = sellerDao.findById(10);
        seller.setName("Martha Waine");
        seller.setEmail("martha@gmail.com");
        seller.setBirthDate(new Date());
        seller.setBaseSalary(3000.0);
        // seller.setDepartment(department); Department só recebe objeto, porém como só quero atualizar os dados, não mexerei no departamento
        sellerDao.update(seller);
        System.out.println("Sucess! Update completed.");

        System.out.println("=== TEST 6: seller delete ===");
        System.out.println("Enter ID for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Sucess! Seller deleted.");

        sc.close();
    }
}
