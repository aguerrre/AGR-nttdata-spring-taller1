package com.nttdata.hibernate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;

import com.nttdata.hibernate.persistence.NttDataCustomer;
import com.nttdata.hibernate.services.NttDataCustomerManagementServiceI;

/**
 * Taller 1 - Spring - FPDual
 * 
 * Clase principal.
 * 
 * @author aguerrre
 *
 */
@SpringBootApplication
public class NttDataSpringTS1Main implements CommandLineRunner{

	/** Servicio: gestión de clientes */
	@Autowired
	private NttDataCustomerManagementServiceI customerService;

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NttDataSpringTS1Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Nuevo cliente 1.
		NttDataCustomer customer1 = new NttDataCustomer();
		customer1.setIdentityDocNumber("32165498Q");
		customer1.setName("Agustín");
		customer1.setSurName1("Guerrero");
		customer1.setSurName2("Reyes");
		customer1.setUpdatedDate(new Date());
		customer1.setUpdatedUser("aguerrre");

		// Nuevo cliente 2.
		NttDataCustomer customer2 = new NttDataCustomer();
		customer2.setIdentityDocNumber("12345678R");
		customer2.setName("Tomás");
		customer2.setSurName1("Mota");
		customer2.setSurName2("Sánchez");
		customer2.setUpdatedDate(new Date());
		customer2.setUpdatedUser("aguerrre");

		// Nuevo cliente 3.
		NttDataCustomer customer3 = new NttDataCustomer();
		customer3.setIdentityDocNumber("98765432T");
		customer3.setName("Fran");
		customer3.setSurName1("Luna");
		customer3.setSurName2("Palma");
		customer3.setUpdatedDate(new Date());
		customer3.setUpdatedUser("aguerrre");

		// Nuevo cliente 4.
		NttDataCustomer customer4 = new NttDataCustomer();
		customer4.setIdentityDocNumber("87654321F");
		customer4.setName("Juan Manuel");
		customer4.setSurName1("Jiménez");
		customer4.setSurName2("Alfaro");
		customer4.setUpdatedDate(new Date());
		customer4.setUpdatedUser("aguerrre");

		// Inserción de clientes.
		customerService.insertNewCustomer(customer1);
		customerService.insertNewCustomer(customer2);
		customerService.insertNewCustomer(customer3);
		customerService.insertNewCustomer(customer4);

		// Obtención de la lista de clientes insertados.
		System.out.println("LISTA CLIENTES INSERTADOS");
		getCustomers();

		// Obtención de cliente por ID.
		final Long searchId = 3L;
		final NttDataCustomer searchedCustomer = customerService.searchById(searchId);
		if (searchedCustomer != null) {
			System.out.println("CLIENTE BUSCADO POR ID = 3");
			System.out.println(searchedCustomer);
		} else {
			System.out.println("No se ha encontrado al cliente con el ID " + searchId);
		}

		// Obtención de cliente por nombre completo.
		final List<NttDataCustomer> customersByNameList = customerService.searchByFullName("Agustín", "Guerrero", "Reyes");
		if (!CollectionUtils.isEmpty(customersByNameList)) {
			System.out.println("Total de clientes registrados con el mismo nombre: " + customersByNameList.size());
			for (NttDataCustomer customer : customersByNameList) {
				System.out.println(customer.toString());
			}
		} else {
			System.out.println("No hay clientes con el nombre indicado.");
		}

		// Borrado del primer cliente con el nombre buscado.
		if (!CollectionUtils.isEmpty(customersByNameList)) {
			customerService.deleteCustomer(customersByNameList.get(0));
		}

		// Obtención de la lista de clientes.
		System.out.println("LISTA CLIENTES TRAS BORRAR AL ANTERIOR.");
		getCustomers();

	}

	/**
	 * Método que obtiene los clientes.
	 */
	private void getCustomers() {

		// Obtención de clientes.
		List<NttDataCustomer> customersList = customerService.searchAll();

		// Verificación de vacío.
		if (!CollectionUtils.isEmpty(customersList)) {
			System.out.println("Total de clientes registrados: " + customersList.size());
			for (NttDataCustomer customer : customersList) {
				System.out.println(customer.toString() + "\n");
			}
		}
	}

}
