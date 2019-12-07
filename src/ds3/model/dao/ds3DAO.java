package ds3.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ds3gil.model.WeaponList;

public class ds3DAO extends DataAccessObject {

	
	
	public void addWeapon(WeaponList weaponlist)  {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
	

		try {
			// Luodaan yhteys ja aloitetaan transaktio:
			connection = getConnection();
			//Luodaan uusi henkilo tietokantaan:
			String sqlInsert = "INSERT INTO weapons(id, types, buildtype, lisat) VALUES (?, ?, ?, ?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setInt(1, weaponlist.getId());
			stmtInsert.setString(2, weaponlist.getTypes());
			stmtInsert.setString(3, weaponlist.getBuildtype());
			stmtInsert.setString(4, weaponlist.getLisat());
			stmtInsert.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection);
		}
	}


	
	/**
	 * Hakee tietokantataulun aseet 
	 * @return ArrayList<WeaponList> Lista aseita
	 */
	public ArrayList<WeaponList> findAll() {	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<WeaponList> weapons = new ArrayList<WeaponList>();
		WeaponList weapon = null; 
		try {
			conn = getConnection();
			String sqlSelect = "SELECT id, types, buildtype, lisat FROM weapons;";
			stmt = conn.prepareStatement(sqlSelect);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				weapon = readWeaponList(rs);
				weapons.add(weapon);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn); 
		}
	
		return weapons;
	}
	
	
	
	/**
	Lukee tietokannasta löytyviä aseita
	 */
	private WeaponList readWeaponList(ResultSet rs) {	
		try {
			
			int id = rs.getInt("id");
			String types = rs.getString("types");
			String buildtype = rs.getString("buildtype");
			String lisat = rs.getString("lisat");
			
			return new WeaponList(id, types, buildtype, lisat);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 Aseiden muokkaamista varten tehty metodi
	 */
	public void editWeapon(WeaponList weaponlist) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtUpdate = null;
		
		try {
			connection = getConnection();
			String sqlSelect = "UPDATE weapons SET id = ?,  types = ?, buildtype = ?, lisat = ? WHERE id = ?";
			stmtUpdate = connection.prepareStatement(sqlSelect);
			stmtUpdate.setInt(1, weaponlist.getId());
			stmtUpdate.setString(2, weaponlist.getTypes());
			stmtUpdate.setString(3, weaponlist.getBuildtype());
			stmtUpdate.setString(4, weaponlist.getLisat());
			stmtUpdate.setInt(5, weaponlist.getId());
			stmtUpdate.executeUpdate();
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtUpdate, connection);
		}
	}
	
	public WeaponList findWeapon(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		WeaponList weapon = null; 
			try {
				connection = getConnection();
				String sqlSelect = "SELECT * FROM weapons WHERE id = ?;";
				stmt = connection.prepareStatement(sqlSelect);
				stmt.setInt(1, id);;
			rs = stmt.executeQuery();
			rs.next();
			weapon = readWeaponList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, connection);
		}
		return weapon;
	}
	/**
	Aseiden postamista varten tehty metodi
	 */
	public void removeWeapon(int weaponId) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtDelete = null;

		try {
			connection = getConnection();
			String sqlInsert = "DELETE FROM weapons WHERE id = ?";
			stmtDelete = connection.prepareStatement(sqlInsert);
			stmtDelete.setInt(1, weaponId);
			stmtDelete.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtDelete, connection); 
		}
	}
}
