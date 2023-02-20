/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junio
 */
public class Servidor {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(8000);
            System.out.println("ESPERANDO...");

            while (true) {

                Socket cliente = server.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                PrintWriter salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()));

                String dato = entrada.readLine();

                System.out.println(dato);
                salida.println(dato);
                cliente.close();

            }

        } catch (IOException e) {

            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
