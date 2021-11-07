package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dbconnection.DbConnect;

public class Equipment {
	private String id;
	private String name;
	private String category;
	private double cost;
	private String status;
<<<<<<< HEAD:src/models/Equipment.java

	public Equipment() {
		super();
		this.id = "";
		this.name = "";
		this.category = "";
		this.cost = 0;
		this.status = "Not Booked";
=======
	private static final Logger logger = LogManager.getLogger(Equipment.class);
	
	public String getEquip_id() {
		return equip_id;
>>>>>>> 57b4c2e9875ce97b3b72ee65736d6c24d3f7fb3c:EquipmentRental/src/classes/Equipment.java
	}
	
	public Equipment(String equip_id, String name, String category, double cost, String status) {
		super();
		this.id = equip_id;
		this.name = name;
		this.category = category;
		this.cost = cost;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Equipment [equip_id=" + id + ", name=" + name + ", category=" + category + ", cost=" + cost
				+ ", status=" + status + "]";
	}


	public void create(String id, String category, String name, double cost, String status) {
		String insertSql = "INSERT INTO equipment_rental.equipment_table (equipment_id, equipment_category, equipment_name, cost, rental_status) VALUES ('"
				+ id + "','" + category + "','" + name + "', '" + cost + "', '" + status + "')";
		try {
			Connection connection = DbConnect.getConnection();
			Statement stat = connection.createStatement();
			int numRowsAffected = stat.executeUpdate(insertSql);
<<<<<<< HEAD:src/models/Equipment.java
			if (numRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Equipment Record Created", "Message",
						JOptionPane.INFORMATION_MESSAGE);
=======
			if(numRowsAffected == 1)
			{
				JOptionPane.showMessageDialog(null, "Equipment Record Created", "Message", JOptionPane.INFORMATION_MESSAGE);
				logger.info("Equipment record created");
>>>>>>> 57b4c2e9875ce97b3b72ee65736d6c24d3f7fb3c:EquipmentRental/src/classes/Equipment.java
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			logger.error("Equipment record not created, SQL Exception: "+e.getMessage());
		}
	}

	public void Delete(String id) {
		String deleteSql = "DELETE FROM equipment_rental.equipment_table WHERE equipment_id = " + id;
		try {
			Connection connection = DbConnect.getConnection();
			Statement stat = connection.createStatement();
			int numRowsAffected = stat.executeUpdate(deleteSql);
<<<<<<< HEAD:src/models/Equipment.java
			if (numRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Equipment Record Deleted", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Delete error: " + e.getMessage());
=======
			if(numRowsAffected == 1)
			{
				JOptionPane.showMessageDialog(null, "Equipment Record Deleted", "Message", JOptionPane.INFORMATION_MESSAGE);
				logger.info("Equipment record deleted");
			}
		}
		catch(SQLException e)
		{
			System.err.println("Delete error: " +e.getMessage());
			logger.error("Delete error, SQL Exception: " +e.getMessage());
>>>>>>> 57b4c2e9875ce97b3b72ee65736d6c24d3f7fb3c:EquipmentRental/src/classes/Equipment.java
		}
	}

	public void readAll() {
		String selectSql = "SELECT * FROM equipment_rental.equipment_table WHERE 1=1";
		try {
			Connection connection = DbConnect.getConnection();
			Statement stat = connection.createStatement();
			ResultSet result = null;
			result = stat.executeQuery(selectSql);
			while (result.next()) {
				String id = result.getString("equipment_id");
				String category = result.getString("equipment_category");
				String name = result.getString("equipment_name");
				double cost = result.getDouble("cost");
				String status = result.getString("rental_status");
				System.out.println("ID: " + id + "\t\tName: " + name + "\t\tCategory: " + category + "\t\tCost: " + cost
						+ "\t\tStatus: " + status);
			}
<<<<<<< HEAD:src/models/Equipment.java
		} catch (SQLException e) {
			System.err.println("SQL Exception: " + e.getMessage());
=======
			logger.info("Equipment records accessed");
		}
		catch(SQLException e)
		{
			System.err.println("SQL Exception: " +e.getMessage());
			logger.error("Error reading equipment records: " +e.getMessage());
>>>>>>> 57b4c2e9875ce97b3b72ee65736d6c24d3f7fb3c:EquipmentRental/src/classes/Equipment.java
		}
	}

	public void update(String id, String category, String name, double cost, String status) {
		String updateSql = "UPDATE equipment_rental.equipment_table SET equipment_category = '" + category
				+ "', equipment_name='" + name + "', cost = '" + cost + "', rental_status = '" + status
				+ "' WHERE equipment_id = '" + id + "'";
		try {
			Connection connection = DbConnect.getConnection();
			Statement stat = connection.createStatement();
			int numRowsAffected = stat.executeUpdate(updateSql);
<<<<<<< HEAD:src/models/Equipment.java
			if (numRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Updated Successfully", "Update Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Update error: " + e.getMessage());
=======
			if(numRowsAffected == 1)
			{
				JOptionPane.showMessageDialog(null, "Updated Successfully", "Update Message", JOptionPane.INFORMATION_MESSAGE);
				logger.info("Equipment record updated");
			}
		}
		catch(SQLException e)
		{
			System.err.println("Update error: " +e.getMessage());
			logger.error("Equipment record not updated: " +e.getMessage());
>>>>>>> 57b4c2e9875ce97b3b72ee65736d6c24d3f7fb3c:EquipmentRental/src/classes/Equipment.java
		}
	}

	public void readOne(String id) {
		String selectSql = "SELECT * FROM equipment_rental.equipment_table WHERE equipment_id = '" + id + "'";
		try {
			Connection connection = DbConnect.getConnection();
			Statement stat = connection.createStatement();
			ResultSet result = null;
			result = stat.executeQuery(selectSql);
			result.next();
			id = result.getString("equipment_id");
			String category = result.getString("equipment_category");
			String name = result.getString("equipment_name");
			double cost = result.getDouble("cost");
			String status = result.getString("rental_status");
<<<<<<< HEAD:src/models/Equipment.java
			System.out.println("ID: " + id + "\t\tName: " + name + "\t\tCategory: " + category + "\t\tCost: " + cost
					+ "\t\tStatus: " + status);
		} catch (SQLException e) {
			System.err.println("SQL Exception: " + e.getMessage());
=======
			System.out.println("ID: "+id+"\t\tName: "+name+"\t\tCategory: "+category+"\t\tCost: "+cost+"\t\tStatus: "+status);
			
			logger.info("Single equipement record read");
		}
		catch(SQLException e)
		{
			System.err.println("SQL Exception: " +e.getMessage());
			logger.error("Could not read equipment record: "+e.getMessage());
>>>>>>> 57b4c2e9875ce97b3b72ee65736d6c24d3f7fb3c:EquipmentRental/src/classes/Equipment.java
		}
	}
}
