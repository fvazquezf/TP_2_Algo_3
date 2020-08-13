package edu.fiuba.algo3.modelo;



import java.util.ArrayList;
import java.util.List;

public class Opciones {
    private final List<String> opcion = new ArrayList<>();
    private String opcionA;
    private String opcionB;
    private String opcionC;
    private String opcionD;
    private String opcionE;
    private String opcionF;
    private String opcionG;

//    public Opciones(String opcionA,String opcionB,String opcionC,String opcionD,String opcionE,String opcionF,String opcionG){
//            this.opcionA = opcionA;
//            this.opcionB = opcionB;
//            this.opcionC = opcionC;
//            this.opcionD = opcionD;
//            this.opcionE = opcionE;
//            this.opcionF = opcionF;
//            this.opcionG = opcionG;
//    }
    public Opciones (String ... opcion){
        for(int i=0;i < opcion.length; i++)
            this.opcion.add(opcion[i]);
    }

    public List obtenerOpciones(){
//        List<String> op= new ArrayList<>();
//        op.add(this.opcionA);
//        op.add(this.opcionB);
//        op.add(this.opcionC);
//        op.add(this.opcionD);
//        op.add(this.opcionE);
//        op.add(this.opcionF);
//        op.add(this.opcionG);
//
//        return op;
        return this.opcion;
    }
}
