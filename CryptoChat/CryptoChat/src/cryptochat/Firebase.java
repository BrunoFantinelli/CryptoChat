/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptochat;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Firebase {

    public static void inserirUsuario(User user) {
        Client c = Client.create();
        WebResource wr = c.resource("https://cryptochat-5d105.firebaseio.com/" + user.getId() + ".json");

        Gson gson = new Gson();
        wr.type("application/json").put(String.class, gson.toJson(user));
    }

    public static String buscarUsuario(String id) {
        Client c = Client.create();
        WebResource wr = c.resource("https://cryptochat-5d105.firebaseio.com/" + id + ".json");
        String response = wr.get(String.class);
        return response;
    }

    public static String pegarMensagens(String id) {
        Client c = Client.create();
        WebResource wr = c.resource("https://cryptochat-5d105.firebaseio.com/" + id + "/mensagens/.json");
        String response = wr.get(String.class);
        return response;
    }

    public static void limparMensagens(String id) {
        Client c = Client.create();
        Gson gson = new Gson();
        ArrayList<String> aux = new ArrayList<>();
        WebResource wr = c.resource("https://cryptochat-5d105.firebaseio.com/" + id + "/mensagens/.json");
        wr.type("application/json").put(String.class, gson.toJson(aux));
    }

    public static void mandarMensagem(String id, String mensagem) {
        Client c = Client.create();
        Gson gson = new Gson();
        String mensagens = Firebase.pegarMensagens(id);
        ArrayList<String> aux = new ArrayList<>();
        mensagens = arrumarEntrada(mensagens);
        if(!mensagens.equals("null")){
             aux.add(mensagens);
        }
        aux.add(mensagem);
        WebResource wr = c.resource("https://cryptochat-5d105.firebaseio.com/" + id + "/mensagens/.json");
        wr.type("application/json").put(String.class, gson.toJson(aux));
    }

    
    public static String arrumarEntrada(String entrada){
        String aux = entrada;
        aux = aux.replace("\"", "");
        aux = aux.replace("[", "");
        aux = aux.replace("]", "");
        return aux;
    }
}
