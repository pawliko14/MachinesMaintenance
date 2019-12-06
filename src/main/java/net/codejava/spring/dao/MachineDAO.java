package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Machine;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface MachineDAO {
	
	public int saveOrUpdate(Machine c);
	
	public int delete(int contactId);
	
	public Machine get(int contactId);
	
	public List<Machine> list();
}
