package br.com.sistema.util;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;



public class ConnectionFactory {
		
	public static Connection getConnection() throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String login = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/dadosaluno";
			return DriverManager.getConnection(url,login,password);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage()); //Remover depois
		}
	}
	public static void main(String[] args) {
		try {
		Connection conn = ConnectionFactory.getConnection();
		JOptionPane.showMessageDialog(null, "Conectado com sucesso!"); //Remover depois
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
