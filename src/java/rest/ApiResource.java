/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entity.Person;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Andreas Fisker
 */
//Ca2Orm
@Path("api")
public class ApiResource {

    @Context
    private Map<Integer,Person> personMap = new HashMap<Integer, Person>(); 
    Gson gson = new Gson();
    /**
     * Creates a new instance of ApiResource
     */
    public ApiResource() {
    }

    /**
     * Retrieves representation of an instance of rest.ApiResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Produces("application/json")
    @Path("/person/complete")
    public String getAllPjson(){
        
        return gson.toJson(personMap.values()); 
    }
    @GET
    @Produces("application/json")
    @Path("/person/{id}")
    public String getOnePjson(@PathParam("id") int id){
        Person p = personMap.get(id);
        if(!personMap.containsKey(id)){
            throw new WebApplicationException("No person with the given ID found.", Response.Status.NOT_FOUND);
        }
        return gson.toJson(p); 
    }
    
    @GET
    @Produces("application/json")
    @Path("/person/contactinfo")
    public String getAllContactPjson(){
        
        return gson.toJson(personMap.values()); 
    }
    /**
     * PUT method for updating or creating an instance of ApiResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
//    @POST
//    @Consumes("application/json")
//    @Path("/person")
//    public Person(String jsonin){
//        Person P = new Person();
//        return P;
//    }
}
