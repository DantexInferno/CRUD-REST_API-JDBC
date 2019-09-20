package com.rest.cruds.servicio;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.cruds.dao.EquipoDAO;
import com.rest.cruds.vo.EquipoVo;

@Path("/equipos")
public class EquipoServicio {
	
	EquipoDAO midao= new EquipoDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List listaEquipos() {
		List listaEquipos=midao.obtenerListaEquipos();
		
		return listaEquipos;
	}
	
	
	@POST
	@Path("/agregarEquipo")
	@Produces(MediaType.APPLICATION_JSON)
	public EquipoVo agregarEquipo(EquipoVo miEquipoVo) {
		
		return midao.registrarEquipo(miEquipoVo);
	}
	
	@PUT
    @Produces(MediaType.APPLICATION_JSON)
	public String actualizarEquipo(EquipoVo miEquipoVo) {
		
			return midao.actualizarEquipo(miEquipoVo);
		
		
	}
	
	@DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public void eliminarEquipo(@PathParam("id") int id) {
		midao.eliminarEquipo(id);
	}
}
