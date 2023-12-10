package com.mycompany.bibliotecaproyecto.main;

import com.mycompany.bibliotecaproyecto.controllers.LoginController;
import com.mycompany.bibliotecaproyecto.models.BookApi;
import com.mycompany.bibliotecaproyecto.models.ClientModel;
import com.mycompany.bibliotecaproyecto.service.BookService;
import com.mycompany.bibliotecaproyecto.service.ClientService;
import com.mycompany.bibliotecaproyecto.service.DataBookApiService;
import java.util.ArrayList;

public class Main {
	
    public static void main(String[] args) {        
        LoginController login = new LoginController();
        login.init();
    }
    
}
