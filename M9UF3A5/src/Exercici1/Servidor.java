/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercici1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author ALUMNEDAM
 */
public class Servidor {

    int PORT = 3498;
    DatagramSocket datagramSocket;
    byte[] bites = new byte[1000];
    byte[] Eco;

    public Servidor() throws SocketException, IOException {
        DatagramPacket datagramPacket = new DatagramPacket(bites, bites.length);
        this.datagramSocket = new DatagramSocket(PORT);
        datagramSocket.receive(datagramPacket);
        
        String mensaje = new String(datagramPacket.getData());
        System.out.println(mensaje);

        //Lo pasamos a mayusculas y obtenemos los bytes.
        this.Eco = mensaje.toUpperCase().getBytes();        
        DatagramPacket datagramPacket1 = new DatagramPacket(Eco, Eco.length, datagramPacket.getAddress(), datagramPacket.getPort());
        datagramSocket.send(datagramPacket1);

    }

    public static void main(String[] argv) throws Exception {
        Servidor s = new Servidor();
        
        while (true) {

        }
    }
}
