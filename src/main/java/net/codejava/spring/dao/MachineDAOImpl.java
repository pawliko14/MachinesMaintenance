package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.model.Machine;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class MachineDAOImpl implements MachineDAO {

	private JdbcTemplate jdbcTemplate;
	
	public MachineDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int saveOrUpdate(Machine c) {
		if (c.getId() > 0) {
			// update
			String sql = "UPDATE maintenance.maszyny SET Nr_maszyny=?, Kod=?, Wydzial=?, "
						+ "Gniazdo=?, Sprawnosc=? WHERE ID=?";
			
			return 	jdbcTemplate.update(sql, c.getNr_Maszyny(), c.getKod(), c.getWydzial(), c.getGniazdo(),c.getSprawnosc(), c.getId());
			
		} else {
			// insert
			String sql = "INSERT INTO maintenance.maszyny (Nr_Maszyny, Kod, Wydzial, Gniazdo, Sprawnosc)"
						+ " VALUES (?, ?, ?, ?, ?)";
			
		return 	jdbcTemplate.update(sql, c.getNr_Maszyny(), c.getKod(),c.getWydzial(), c.getGniazdo(),c.getSprawnosc());
		}
		
	}

	@Override
	public int delete(int contactId) {
		String sql = "DELETE FROM maintenance.maszyny WHERE ID = ?";
		 return jdbcTemplate.update(sql, contactId);
	}

	@Override
	public List<Machine> list() {
		String sql = "SELECT * FROM maintenance.maszyny";
		List<Machine> listContact = jdbcTemplate.query(sql, new RowMapper<Machine>() {

			@Override
			public Machine mapRow(ResultSet rs, int rowNum) throws SQLException {
				Machine aContact = new Machine();
	
				aContact.setId(rs.getInt("ID"));
				aContact.setNr_Maszyny(rs.getString("Nr_Maszyny"));
				aContact.setKod(rs.getString("Kod"));
				aContact.setWydzial(rs.getString("Wydzial"));
				aContact.setGniazdo(rs.getString("Gniazdo"));
				aContact.setSprawnosc(rs.getString("Sprawnosc"));
				
				return aContact;
			}
			
		});
		
		return listContact;
	}

	@Override
	public Machine get(int contactId) {
		String sql = "SELECT * FROM maintenance.maszyny WHERE ID =" + contactId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Machine>() {

			@Override
			public Machine extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Machine contact = new Machine();
					contact.setId(rs.getInt("ID"));
					contact.setNr_Maszyny(rs.getString("Nr_Maszyny"));
					contact.setKod(rs.getString("Kod"));
					contact.setWydzial(rs.getString("Wydzial"));
					contact.setGniazdo(rs.getString("Gniazdo"));
					contact.setSprawnosc(rs.getString("Sprawnosc"));
					return contact;
				}
				
				return null;
			}
			
		});
	}

}
