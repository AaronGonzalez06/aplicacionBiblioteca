package com.mycompany.bibliotecaproyecto.service;

import com.mycompany.bibliotecaproyecto.models.ClientModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ClientService {
    
    public ArrayList<ClientModel> getClients() {
        ArrayList<ClientModel> clients = null;
        try {
            clients = new ArrayList<ClientModel>();
            File file = new File("src\\main\\resources\\cliente.txt");

            FileReader fr = new FileReader(file);
            BufferedReader read = new BufferedReader(fr);
            String linea;
            while ((linea = read.readLine()) != null) {
                String[] dataClient = linea.split(";");
                ClientModel addClient = new ClientModel(dataClient[0],dataClient[1],dataClient[2],Integer.parseInt(dataClient[4]),Integer.parseInt(dataClient[5]),dataClient[3],Boolean.parseBoolean(dataClient[6]));
                clients.add(addClient);
            }
            
            return clients;
        } catch (Exception e) {
            System.out.println("message: " + e.getMessage());
        }
        return clients;
    }
    
    
    public void addClient(ClientModel client) {
        try{
            File file = new File("src\\main\\resources\\cliente.txt");
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(client.getName()+";"+client.getSurname()+";"+client.getSurnameTwo()+";"+client.getDni()+";"+client.getAge()+";"+client.getPhone()+";"+client.getSanctioned());
            bw.close();
            fw.close();                     
        }catch(Exception e){
            System.out.println("message:" + e.getMessage());
        }
    }
}
