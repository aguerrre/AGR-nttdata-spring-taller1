package com.nttdata.hibernate.persistence;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/**
 * Taller 1 - Spring - FPDual
 * 
 * DAO de tabla NTTDATA_TS1_CUSTOMER
 * 
 * @author aguerrre
 *
 */
public interface NttDataCustomerDaoI {

	/**
	 * Inserta un cliente en BBDD.
	 * 
	 * @param newCustomer
	 */
	public void insert(NttDataCustomer newCustomer);

	/**
	 * Actualiza un cliente de BBDD.
	 * 
	 * @param updCustomer
	 */
	public void update(NttDataCustomer updCustomer);

	/**
	 * Elimina un cliente en BBDD.
	 * 
	 * @param paramT
	 */
	public void delete(NttDataCustomer delCustomer);

	/**
	 * Localiza un cliente por ID en BBDD.
	 * 
	 * @param customerId
	 * @return NttDataCustomer
	 */
	public NttDataCustomer searchById(final Long customerId);

	/**
	 * Búsqueda de todos los clientes en BBDD.
	 * 
	 * @return List<EverisCustomer>
	 */
	public List<NttDataCustomer> searchAll();

	/**
	 * Obtiene un cliente por nombre completo.
	 * 
	 * @param paramT
	 * @return List<NttDataCustomer>
	 */
	public List<NttDataCustomer> searchByCustomerFullName(final String name, final String surname1, final String surname2);

}
