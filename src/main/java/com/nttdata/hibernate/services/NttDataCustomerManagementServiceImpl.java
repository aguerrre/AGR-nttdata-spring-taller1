package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nttdata.hibernate.persistence.NttDataCustomer;
import com.nttdata.hibernate.persistence.NttDataCustomerDaoI;

/**
 * Taller 1 - Spring - FPDual
 * 
 * Implementación del servicio de Clientes.
 * 
 * @author aguerrre
 *
 */
@Service
@Transactional
public class NttDataCustomerManagementServiceImpl implements NttDataCustomerManagementServiceI {

	/** DAO: NTTDATA_TS1_CUSTOMER */
	@Autowired
	private NttDataCustomerDaoI customerDao;

	@Override
	public void insertNewCustomer(NttDataCustomer newCustomer) {

		// Verificación de nulidad e inexistencia.
		if (newCustomer != null && newCustomer.getCustomerId() == null) {

			// Insercción del nuevo cliente.
			customerDao.insert(newCustomer);
		}

	}

	@Override
	public void updateCustomer(NttDataCustomer updatedCustomer) {

		// Verificación de nulidad e inexistencia.
		if (updatedCustomer != null && updatedCustomer.getCustomerId() != null) {

			// Actualización del nuevo cliente.
			customerDao.update(updatedCustomer);
		}

	}

	@Override
	public void deleteCustomer(NttDataCustomer deletedCustomer) {

		// Verificación de nulidad e inexistencia.
		if (deletedCustomer != null && deletedCustomer.getCustomerId() != null) {

			// Borrado del nuevo cliente.
			customerDao.delete(deletedCustomer);
		}

	}

	@Override
	public NttDataCustomer searchById(Long customerId) {

		// Resultado.
		NttDataCustomer customer = null;

		// Verificación de nulidad.
		if (customerId != null) {

			// Obtención del cliente por ID.
			customer = customerDao.searchById(customerId);
		}

		return customer;

	}

	@Override
	public List<NttDataCustomer> searchAll() {

		// Resultado.
		List<NttDataCustomer> customersList = new ArrayList<NttDataCustomer>();

		// Obtención de clientes.
		customersList = customerDao.searchAll();

		return customersList;

	}

	@Override
	public List<NttDataCustomer> searchByFullName(String name, String surname1, String surname2) {

		// Resultado.
		List<NttDataCustomer> customersList = new ArrayList<NttDataCustomer>();

		// Verificación de nulidad.
		if (StringUtils.hasText(name) && StringUtils.hasText(surname1) && StringUtils.hasText(surname2)) {

			// Obtención del cliente por nombre completo.
			customersList = customerDao.searchByCustomerFullName(name, surname1, surname2);
		}

		return customersList;

	}

}
