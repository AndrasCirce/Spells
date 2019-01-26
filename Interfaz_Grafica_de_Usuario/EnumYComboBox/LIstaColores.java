
package Interfaz_Grafica_de_Usuario.EnumYComboBox;
    
/**
 *
 * @author Adeaf
 */
public enum LIstaColores {
    morado (128, 0, 128),
    rojo (255, 0, 0),
    amarillo(255, 255 ,0),
    verde(0,255,0),
    azul(0, 0, 255),
    cafe(128, 0, 0),
    negro(0, 0, 0),
    blanco(255,255, 255);
    private int R, G, B;
    
    private LIstaColores (int R, int G , int B){
        this.R = R;
        this.G = G;
        this.B = B;
    }
    
    public int GetR(){
        return this.R;
    }
    
    
    public int GetG(){
        return this.G;
    }
    
    
    public int GetB(){
        return this.B;
    }

    @Override
    public String toString() {
        return "LIstaColores{" + "R = " + R + ", G = " + G + ", B = " + B + '}';
    }
    
    
}
