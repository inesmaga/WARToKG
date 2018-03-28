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
 * Jersey REST client generated for REST resource:ValoraResource [Valora]<br>
 * USAGE:
 * <pre>
 *        ValoracClient client = new ValoracClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author inesm
 */
public class ValoracClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:37040/Valoracy/resources";

    public ValoracClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Valora");
    }

    public String getText(Double imc) throws ClientErrorException {
        WebTarget resource = webTarget;
        String j = null;
        if (imc != 0) {
        
            resource = resource.queryParam("imc", imc);
        }
        j= resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
        return j;
    }

    public void close() {
        client.close();
    }
    
}
