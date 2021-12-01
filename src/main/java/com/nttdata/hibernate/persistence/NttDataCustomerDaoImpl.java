package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Taller 1 - Spring - FPDual
 * 
 * Implementación DAO Tabla NTTDATA_TS1_CUSTOMER
 * 
 * @author aguerrre
 *
 */
@Repository
@Transactional
public class NttDataCustomerDaoImpl implements NttDataCustomerDaoI {

	/** Manejador de entidades */
	@Autowired
	private EntityManager entityManager;

	@Override
	public void insert(NttDataCustomer newCustomer) {

		// Obtención de sesión.
		Session currentSession = entityManager.unwrap(Session.class);

		// Insercción.
		currentSession.save(newCustomer);

		// Cierre de sesión.
		currentSession.close();

	}

	@Override
	public void update(NttDataCustomer updCustomer) {

		// Obtención de sesión.
		Session currentSession = entityManager.unwrap(Session.class);

		// Insercción o actualización.
		currentSession.saveOrUpdate(updCustomer);

		// Cierre de sesión.
		currentSession.close();

	}

	@Override
	public void delete(NttDataCustomer delCustomer) {

		// Obtención de sesión.
		Session currentSession = entityManager.unwrap(Session.class);

		// Mergeo de estados.
		delCustomer = entityManager.merge(delCustomer);

		// Insercción.
		currentSession.delete(delCustomer);

		// Cierre de sesión.
		currentSession.close();

	}

	@Override
	public NttDataCustomer searchById(Long customerId) {

		// Obtención de sesión.
		Session currentSession = entityManager.unwrap(Session.class);

		// Búsqueda por PK.
		NttDataCustomer result = currentSession.get(NttDataCustomer.class, customerId);

		// Cierre de sesión.
		currentSession.close();

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NttDataCustomer> searchAll() {
		// Obtención de sesión.
		Session currentSession = entityManager.unwrap(Session.class);

		// Búsqueda de todos los registros.
		List<NttDataCustomer> list = currentSession.createQuery("FROM NttDataCustomer").list();

		// Cierre de sesión.
		currentSession.close();

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NttDataCustomer> searchByCustomerFullName(String name, String surname1, String surname2) {

		// Obtención de sesión.
		Session currentSession = entityManager.unwrap(Session.class);

		// Localiza cliente por nombre completo.
		final List<NttDataCustomer> customerList = currentSession
		        .createQuery("FROM NttDataCustomer WHERE name='" + name + "' AND surname1='" + surname1 + "' AND surname2='" + surname2 + "'").list();

		return customerList;

	}

}
