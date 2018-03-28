/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wartokg.web;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:IdealpesFacadeREST
 * [Idealpes]<br>
 * USAGE:
 * <pre>
 *        PesoIdealClient client = new PesoIdealClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author inesm
 */
public class PesoIdealClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:37040/Peso_Ideal/resources";

    public PesoIdealClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Idealpes");
    }

    public String findXPeso(String altura, String sexo, int edad) throws ClientErrorException {
        WebTarget resource = webTarget;
        String pei=null;
        if (altura != null) {
            resource = resource.queryParam("altura", altura);
        }
        if (sexo != null) {
            resource = resource.queryParam("sexo", sexo);
        }
        if (edad != 0) {
            resource = resource.queryParam("edad", edad);
        }
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
      
    }

    public void close() {
        client.close();
    }
    
}
