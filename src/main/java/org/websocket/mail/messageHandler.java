/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websocket.mail;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
/**
 *
 * @author maria
 */
@ServerEndpoint("/email1")
public class messageHandler {
    @OnMessage
    public String[] onMessage(String message, Session session){
    String sender=null;
    String mess=null;
        try (JsonReader reader= Json.createReader(new StringReader(message))){
            JsonObject JsonMessage= reader.readObject();
            if(JsonMessage.getString("message")!=null){
                mess=JsonMessage.getString("message");
                sender=JsonMessage.getString("addres");
            }
        }return new String[]{sender, mess};
}
}
