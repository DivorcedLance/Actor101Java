package com.mycompany.app;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

public class Maestro extends UntypedAbstractActor  {

        private ActorRef esclavos[];
        
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
                System.out.println("Creando esclavos: " + (int)message);
                crearEsclavos((int)message);
                mensajeEsclavos();
            }
        }


        public void crearEsclavos(int cantidad) {
            esclavos = new ActorRef[cantidad];
            for (int i=0; i<cantidad; i++) {
                esclavos[i] = getContext().actorOf(Props.create(Esclavo.class));
            }
        }

        public void mensajeEsclavos() {
            for (int i=0; i<esclavos.length; i++) {
                esclavos[i].tell(1, getSelf());
            }
        }

}