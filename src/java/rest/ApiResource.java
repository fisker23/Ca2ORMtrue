/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import entity.Person;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
import org.eclipse.persistence.sessions.Project;

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
   String str  = "";
   
        for (int i = 0; i < personMap.size(); i++) {
            str += personMap.get(i).getEmail() + personMap.get(i).getFirstName() + personMap.get(i).getLastName();
            
        }
   return gson.toJson(str); 
    }
    @GET
    @Produces("application/json")
    @Path("/person/contactinfo/{id}")
    public String getOneContactPjson(@PathParam("id") int id){
         
          Person p = personMap.get(id);
        if(!personMap.containsKey(id)){
            throw new WebApplicationException("No person with the given ID found.", Response.Status.NOT_FOUND);
        }
        JsonObject jo = new JsonObject();
        jo.addProperty("firstName", p.getFirstName());
        jo.addProperty("lastName", p.getLastName());
        jo.addProperty("email",p.getEmail());
        return gson.toJson(jo); 
    }
    /**
     * PUT method for updating or creating an instance of ApiResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    @Path("/person")
    public void putJson(String content) {
       // JsonObject o = new JsonParser().parse(jsonAsString).getAsJsonObect();
       
    }
    
    @POST
    @Consumes("application/json")
    @Path("/person")
    public Person createPerson(String jsonin){
         java.lang.reflect.Type type = new TypeToken<Collection<Project>>(){}.getType();
    List<Person> persons = gson.fromJson(jsonin,type);
        for (Person person : persons) {
            System.out.println("TEST: "+person.getFirstName());
        }
        return persons.get(1);
    }
}
