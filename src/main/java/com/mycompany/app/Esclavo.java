package com.mycompany.app;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;

public class Esclavo extends UntypedAbstractActor {
    
    private ActorRef maestro;
    
    @Override
    public void postStop() throws Exception {
        super.postStop(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void preStart() throws Exception {
        super.preStart(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("Iniciando actor: " + this.getSelf().path());
    }
    
    @Override
    public void onReceive(Object message) {
        if (message instanceof Integer) {
            System.out.println("Procesando mensaje: " + (int)message);
        }
        
        if (message instanceof ActorRef) {
            maestro = (ActorRef) message;
        }
    }
}
