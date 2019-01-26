
package Hilos;

import static Hilos.HiloTenebroso.VECES;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adeaf
 */
public class HiloTenebroso {

    int status = 1;
   static final int  VECES = 5; 
    
    public static void main(String[] args) {
        
        HiloTenebroso HiloTenebroso = new HiloTenebroso();

        A1 a = new A1(HiloTenebroso, 1);
        A1 a1 = new A1(HiloTenebroso, 2);
        B1 b = new B1(HiloTenebroso,1);
        B1 b1 = new B1(HiloTenebroso, 2);
        C1 c = new C1(HiloTenebroso, 2);
        C1 c1 = new C1(HiloTenebroso, 1);

        a.start();
        a1.start();
        b.start();
        b1.start();
        c.start();
        c1.start();
        
        try {
            a.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloTenebroso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            b.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloTenebroso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            c.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloTenebroso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            a1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloTenebroso.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            b1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloTenebroso.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            c1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloTenebroso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println("fin");
    }
    
}

class A1 extends Thread {
int t;
    HiloTenebroso HiloTenebroso;
    A1(HiloTenebroso HiloTenebroso, int t) {
        this.HiloTenebroso = HiloTenebroso;
        this.t = t;
    }

    @Override
    public void run() {
        try {
            synchronized (HiloTenebroso) {
                for (int i = 0; i < VECES; i++) {
                    while (HiloTenebroso.status != 1) {
                        HiloTenebroso.wait();
                    }
                    System.out.println("ping "+ t);
                    HiloTenebroso.status = 2;
                    HiloTenebroso.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception 1 :" + e.getMessage());
        }
    }
}

class B1 extends Thread {

    HiloTenebroso HiloTenebroso;
    int t;
    B1(HiloTenebroso HiloTenebroso, int t) {
        this.HiloTenebroso = HiloTenebroso;
        this.t = t;
    }

    @Override
    public void run() {
        try {
            synchronized (HiloTenebroso) {
                for (int i = 0; i < VECES; i++) {
                    while (HiloTenebroso.status != 2) {
                        HiloTenebroso.wait();
                    }
                    System.out.println("    Pong " + t);
                    HiloTenebroso.status = 3;
                    HiloTenebroso.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception 2 :" + e.getMessage());
        }
    }
}

class C1 extends Thread {
    HiloTenebroso HiloTenebroso;
    int t;
    C1(HiloTenebroso HiloTenebroso, int t) {
        this.HiloTenebroso = HiloTenebroso;
        this.t = t;
    }

    @Override
    public void run() {
        try {
            synchronized (HiloTenebroso) {
                for (int i = 0; i < VECES; i++) {
                    while (HiloTenebroso.status != 3) {
                        HiloTenebroso.wait();
                    }
                    System.out.println("        Papas "+ t);
                    HiloTenebroso.status = 1;
                    HiloTenebroso.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception 3 :" + e.getMessage());
        }
    }
}
