package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.NttDataCustomer;

/**
 * Taller 1 - Spring - FPDual
 * 
 * Interface del servicio de clientes.
 * 
 * @author aguerrre
 *
 */
public interface NttDataCustomerManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newCustomer
	 */
	public void insertNewCustomer(final NttDataCustomer newCustomer);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedCustomer
	 */
	public void updateCustomer(final NttDataCustomer updatedCustomer);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedCustomer
	 */
	public void deleteCustomer(final NttDataCustomer deletedCustomer);

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param customerId
	 */
	public NttDataCustomer searchById(final Long customerId);

	/**
	 * Obtiene un cliente por su nombre completo.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @return List<NttDataCustomer>
	 */
	public List<NttDataCustomer> searchByFullName(final String name, final String surname1, final String surname2);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<NttDataCustomer>
	 */
	public List<NttDataCustomer> searchAll();

}
