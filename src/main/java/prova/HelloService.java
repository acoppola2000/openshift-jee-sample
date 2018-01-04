package prova;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import prova.DatabaseReader;

/**
 * A simple REST service which is able to say hello to someone using HelloService Please take a look at the web.xml where JAX-RS
 * is enabled
 *
 * @author gbrey@redhat.com
 *
 */

@Path("/")
public class HelloService {


    @GET
    @Path("/json")
    @Produces({ "application/json" })
    public String getHelloWorldJSON() {
    	String nomeFile = new DatabaseReader().getHello();
        return "{\"result\":\"" + "Hello World " + nomeFile + "\"}";
    }

    @GET
    @Path("/xml")
    @Produces({ "application/xml" })
    public String getHelloWorldXML() {
    	System.out.println("richiesta rest application/xml alle " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        return "<xml><result>" + "Hello World " + System.getenv("POSTGRESQL_USER") + ":" + System.getenv("POSTGRESQL_PASSWORD") + "</result></xml>";
    }

}