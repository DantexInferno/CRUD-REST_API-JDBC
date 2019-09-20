package com.rest.cruds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rest.cruds.conexion.Conexion;
import com.rest.cruds.vo.EquipoVo;

public class EquipoDAO {

	public String registrarEquipo(EquipoVo miEquipoVo) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "INSERT INTO equipos (nombre,departamento,estadio)"
				+ "  VALUES (?,?,?)";
		

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miEquipoVo.getNombre());
			preStatement.setString(2, miEquipoVo.getDepartamento());
			preStatement.setString(3, miEquipoVo.getEstadio());
			
			
			preStatement.execute();

			resultado = "Registro Exitoso";

		} catch (SQLException e) {
			System.out.println("No se pudo registrar el equipo: " + e.getMessage());
			resultado = "No se pudo registrar el equipo";
		} finally {
			conexion.desconectar();
		}

		return resultado;
	}
	
	public ArrayList<EquipoVo> obtenerListaEquipos() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EquipoVo miEquipoVo=new EquipoVo();
		ArrayList<EquipoVo> listaEquipos = null;
		
		
		
		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM equipos";

		try {
			if (connection != null) {
				listaEquipos = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				while (result.next() == true) {
					miEquipoVo = new EquipoVo();
					
					miEquipoVo.setId(result.getInt("id"));
					miEquipoVo.setNombre(result.getString("nombre"));
					miEquipoVo.setDepartamento(result.getString("departamento"));
					miEquipoVo.setEstadio(result.getString("estadio"));		
					
					
					
					listaEquipos.add(miEquipoVo);
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del equipo: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaEquipos;
	}
	
	public String actualizarEquipo(EquipoVo miEquipoVo) {
		String resultado = "";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();
		try {
			String consulta = "UPDATE equipos "
					+ " SET nombre = ? ,departamento= ?, estadio=?"
					+ " WHERE id= ? ";
			PreparedStatement preStatement = connection.prepareStatement(consulta);

			preStatement.setString(1, miEquipoVo.getNombre());
			preStatement.setString(2, miEquipoVo.getDepartamento());
			preStatement.setString(3, miEquipoVo.getEstadio());
			preStatement.setInt(4, miEquipoVo.getId());
			
			
			preStatement.executeUpdate();

			resultado = "Se ha Actualizado el equipo satisfactoriamente";

			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "No se pudo actualizar el equipo";
		}
		return resultado;
	}
	
	public String eliminarEquipo(int id) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();

		String resp = "";
		try {
			String sentencia = "DELETE FROM equipos WHERE id= ? ";

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.setInt(1, id);

			statement.executeUpdate();

			resp = "El equipo se ha eliminado exitosamente";
			statement.close();
			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resp = "No se pudo eliminar el equipo";
		}
		return resp;
	}
}
