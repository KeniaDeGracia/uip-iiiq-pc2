package pa.edu.uip;
import java.util.Vector;

public class Mascotas {
    private int energia;
    private int hambre;
    private int limpieza;
    private Vector<String> items;
    private boolean alive = true;
}
    public void alimentar (){
        if (alive) {
            if (hambre >=5){
                hambre -=5;
            }else{
                hambre = 0;
            }
        }
    }

    public void jugar (){
        if(alive){
            hambre += 5;
            energia -= 4;
            limpieza -= 5;
            if(hambre >= 100  ||  energia < 1) {
                //muere
                alive = false;
            }
        }
    }

    public void bañarse () {
        if (alive) {
            limpieza += 10;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia (int energia) {
        this.energia = energia;
    }

    public int getHambre (){
        return hambre;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public int getLimpieza () {
        return limpieza;
    }

    public void setLimpieza (int limpieza) {
        this.limpieza =  limpieza;
    }

    public Vector<String> getItems() {
        return items;
    }

    public void setItems(Vector<String> items) {
        this.items = items;
    }

    public boolean isAlive() {
        return alive;
    }

}