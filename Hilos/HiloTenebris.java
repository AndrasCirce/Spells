/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 *
 * @author Adeaf
 */
public class HiloTenebris {

    static String tipo = "ping";
    static int total;
    
    public synchronized static void ver(String tipo1, String tipo2) {
        if (tipo.equals(tipo1)) {
            System.out.println(tipo1);
            tipo = tipo2;
            total ++;
        } else {
            Thread.yield();
        }
    }
    
    static class HiloNero implements Runnable{
            public String tipo1, tipo2;

        public HiloNero(String tipo1, String tipo2) {
            this.tipo1 = tipo1;
            this.tipo2 = tipo2;
        }
            
        
        @Override
        public void run() {
            while(total <5){
                ver(tipo1, tipo2);
            }
        }        
    }        
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        HiloNero ping, pong, papas;
        
        ping = new HiloNero("ping", "pong");
        ping = new HiloNero("ping", "pong");
        ping = new HiloNero("ping", "pong");
        pong = new HiloNero("pong", "papas");
        pong = new HiloNero("pong", "papas");
        papas = new HiloNero("papas", "ping");
        
        Thread a = new Thread(ping);
        Thread b = new Thread(ping);
        Thread c = new Thread(ping);
        Thread d = new Thread(pong);
        Thread e = new Thread(pong);
        Thread f = new Thread(papas);
        
        exec.execute(a);
        exec.execute(b);
        exec.execute(c);
        exec.execute(d);
        exec.execute(e);
        exec.execute(f);
        
        exec.shutdown();
        
        
    }
}
