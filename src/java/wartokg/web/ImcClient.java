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
 * Jersey REST client generated for REST resource:ImcValoraResource [Imc]<br>
 * USAGE:
 * <pre>
 *        ImcClient client = new ImcClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author inesm
 */
public class ImcClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:37040/Imc/resources";

    public ImcClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Imc");
    }

    public String getImc(Double peso,String altu) throws ClientErrorException {
        WebTarget resource = webTarget;
       String  i=null;
         if (peso != 0.00) {
            resource = resource.queryParam("peso", peso);
        
        if (altu != null) {
            resource = resource.queryParam("altu", altu);
        }
         }
       i= resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
     return i;
    }

    public void close() {
        client.close();
    }
    
}
