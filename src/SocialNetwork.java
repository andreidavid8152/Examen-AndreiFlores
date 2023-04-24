import java.util.*;


public class SocialNetwork {
    private Queue<Persona> cola;
    private Queue<Persona> colaPrioridad;
    private Stack<Persona> pila;

    public SocialNetwork(){
        cola =  new LinkedList<>();
        colaPrioridad =  new PriorityQueue<>(new Comparator<Persona>() {
            public int compare(Persona p1, Persona p2) {
                if (p1.getPrioridad() < p2.getPrioridad()) {
                    return 1;
                } else if (p1.getPrioridad() > p2.getPrioridad()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        pila = new Stack<>();
    }

    public Queue<Persona> getCola() {
        return cola;
    }

    public void setCola(Queue<Persona> cola) {
        this.cola = cola;
    }

    public Queue<Persona> getColaPrioridad() {
        return colaPrioridad;
    }

    public void setColaPrioridad(Queue<Persona> colaPrioridad) {
        this.colaPrioridad = colaPrioridad;
    }

    public Stack<Persona> getPila() {
        return pila;
    }

    public void setPila(Stack<Persona> pila) {
        this.pila = pila;
    }

    public boolean agregarPersona(Persona p){
        boolean value = false;

        if(buscarPersona(p.getNombreCompleto())){
            cola.add(p);
            value = true;
        }


        return value;
    }

    public boolean buscarPersona(String nombre){
        boolean value = true;
        Iterator<Persona> iterador = cola.iterator();

        while (iterador.hasNext()) {
            Persona elemento = iterador.next();
            if (elemento.getNombreCompleto().equals(nombre)){
                value = false;
            }
        }

        return value;
    }



}
