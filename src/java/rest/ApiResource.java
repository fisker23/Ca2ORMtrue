/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import control.Facade;
import entity.Person;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Andreas Fisker
 */
//Ca2Orm
@Path("")
public class ApiResource {

    
    Gson gson = new Gson();
    Facade f = new Facade("Ca2ORMtruePU");
    /**
     * Creates a new instance of ApiResource
     */
    public ApiResource() {
        for (int i = 0; i < 10; i++) {
        }
    }

    @GET
    @Produces("application/json")
    @Path("/person/complete")
    public String getAllPjson(){
        JsonArray ja = new JsonArray();
        for (Person p : f.getAllPersons()) {
        JsonObject  jo = new JsonObject();
        jo.addProperty("firstName", p.getFirstName());
        jo.addProperty("lastName", p.getLastName());
        jo.addProperty("email", p.getEmail());
        jo.addProperty("street", p.getAddress().getStreet());
        jo.addProperty("additionalInfo", p.getAddress().getAdditionalInfo());
        jo.addProperty("zipCode", p.getAddress().getCityInfo().getZipCode());
        jo.addProperty("city", p.getAddress().getCityInfo().getCity());
        ja.add(jo);
        }
        String str = gson.toJson(ja);
        
        return str;
    }
    
    @POST
    @Consumes("application/json")
    @Path("/person")
    public void createPerson(String jsonin){
        JsonObject o = new JsonParser().parse(jsonin).getAsJsonObject();
        String fname = o.get("firstName").getAsString();
        String lname = o.get("lastName").getAsString();
        String email = o.get("email").getAsString();
        String street = o.get("street").getAsString();
        String ai = o.get("additionalInfo").getAsString();
        String zip = o.get("zip").getAsString();
        
        f.createPerson(fname, lname, email, null, street, ai, zip);
        
        
    }
    
    @GET
    @Produces("application/json")
    @Path("/person/{id}")
    public String getOnePjson(@PathParam("id") int id){
        return gson.toJson(f.getOnePerson(id));
    }
    
//    @GET
//    @Produces("application/json")
//    @Path("/person/contactinfo")
//    public String getAllContactPjson(){
//   String str  = "";
//   return gson.toJson(str); 
//    }
//    @GET
//    @Produces("application/json")
//    @Path("/person/contactinfo/{id}")
//    public String getOneContactPjson(@PathParam("id") int id){
//         
//          Person p = personMap.get(id);
//        if(!personMap.containsKey(id)){
//            throw new WebApplicationException("No person with the given ID found.", Response.Status.NOT_FOUND);
//        }
//        JsonObject jo = new JsonObject();
//        jo.addProperty("firstName", p.getFirstName());
//        jo.addProperty("lastName", p.getLastName());
//        jo.addProperty("email",p.getEmail());
//        return gson.toJson(jo); 
//    }
    
//    @PUT
//    @Consumes("application/json")
//    @Path("/person")
//    public void putJson(String content) {
//       // JsonObject o = new JsonParser().parse(jsonAsString).getAsJsonObect();
//       
//    }
//    
    
}
