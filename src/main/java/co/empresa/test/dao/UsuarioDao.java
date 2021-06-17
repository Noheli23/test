package co.empresa.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import co.empresa.test.modelo.Usuario;
import co.empresa.test.utils.Conexion;

public class UsuarioDao {

	private Conexion conexion;
	
	public static final String INSERT_USUARIO_SQL= "INSERT INTO usuario (nombre, email, pais) VALUES (?, ?, ?);";
	public static final String DELETE_USUARIO_SQL= "DELETE FROM usuario WHERE id = ?;";
	public static final String UPDATE_USUARIO_SQL= "UPDATE usuario SET nombre = ?, email = ?, pais = ? WHERE id = ?;";
	public static final String SELECT_USUARIO_BY_ID= "SELECT * FROM usuario WHERE id = ?;";
	public static final String SELECT_ALL_USUARIO= "SELECT * FROM usuario;";
	
	
	public UsuarioDao() {
		this.conexion=Conexion.getConexion();
	}
	
	public void insert(Usuario usuario) throws SQLException {
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPais());
			conexion.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void delete (int id) throws SQLException {
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_USUARIO_SQL);
			preparedStatement.setInt(1, id);
		
			conexion.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void update(Usuario usuario) throws SQLException {
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPais());
			preparedStatement.setInt(4, usuario.getId());
			conexion.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List <Usuario> selectAll(){
		
		List <Usuario> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_USUARIO);
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				int id= rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuarios.add(new Usuario(id, nombre, email, pais));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return usuarios;
	}
	
	public Usuario select(int id){
		
		Usuario usuario = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_USUARIO_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
			
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuario = new Usuario(id, nombre, email, pais);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return usuario;
	}

}
