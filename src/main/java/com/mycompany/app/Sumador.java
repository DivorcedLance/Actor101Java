package com.mycompany.app;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

public class Sumador extends UntypedAbstractActor {
    
    // private double Arreglo[];
    
    private ActorRef maestro;
    
    private void crearActores() {

        maestro = getContext().actorOf(Props.create(Maestro.class));
    }

    @Override
    public void postStop() throws Exception {
        super.postStop(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void preStart() throws Exception {
        super.preStart(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        crearActores();
        maestro.tell(10, getSelf());
    }
    
    @Override
    public void onReceive(Object message) throws Throwable {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
