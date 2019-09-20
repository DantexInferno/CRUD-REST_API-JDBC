package com.rest.cruds.cliente;

import javax.swing.JOptionPane;


import com.rest.cruds.vo.EquipoVo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class ClienteEquipos {

	public static void main(String[] args) {

		String urlServicio="http://localhost:8080/crud-rest-api/servicio/equipos/agregarEquipo";
		System.out.println("Servicio: " + urlServicio);
		
		EquipoVo miEquipoVo=new EquipoVo();
		
		miEquipoVo.setNombre(JOptionPane.showInputDialog("Ingrese nombre del equipo"));
		miEquipoVo.setDepartamento(JOptionPane.showInputDialog("Ingrese departamento del equipo"));
		miEquipoVo.setEstadio(JOptionPane.showInputDialog("Ingrese estadio del equipo"));
		
		ClientConfig clientConfig=new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
		
		Client client=Client.create(clientConfig);
		
		WebResource webResource=client.resource(urlServicio);
		
		ClientResponse respuesta=webResource.type("application/json").post(ClientResponse.class,miEquipoVo);
		System.out.println("resp: "+respuesta);
		
	
	}

}
