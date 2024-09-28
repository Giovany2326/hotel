import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        //Constante de precio por noches
        final double PRECIO_POR_NOCHES = 55500;
        //Entrada de datos 
        Scanner scanner = new Scanner(System.in);
        //Arrays de nombre de clientes, habitaciones ocupadas y el numero de noches  
      String [] nombreClientes = new String[5];
      boolean [] habitacionesOcupadas = new boolean[5];
      int [] noches = new int[5];
      //Tipo de variable 
     int codigo;
      
      do{ 
        //menu de el sistema de gestion de reservas del hotel  
      System.out.println("Sitema de gestion de reservas del hotel");
      System.out.println("codigo   //  accion a ejecutar");
      System.out.println("  1      //  Reserva de habitacion");
      System.out.println("  2      //  Cancelacion de reserva");
      System.out.println("  3      //  Reporte");
      System.out.println("  4      //  Salir del sistema de gestion de reservas");
      System.out.print("ingrese el codigo de la accion que desea ejecurtar");
      //scanner para leer el tipo de accion a ejecutar
      codigo = scanner.nextInt(); 
     
      switch(codigo){
          //si ingresa el codigo "1" le dejara reservar la habitacion del cliente 
          case 1:
            System.out.println("Ingrese el numero de la habitacion (1-5)");
             int numeroHabitacion = scanner.nextInt()-1;
              scanner.nextLine();//Consume el salto de linea que deja el nextInt
             if(habitacionesOcupadas[numeroHabitacion]) {
                System.out.println("lo sentimos la habitacion se encuentra ocupada");
             } else {
                 System.out.println("ingrese nombre de el cliente");
                  nombreClientes[numeroHabitacion]= scanner.nextLine();
                  System.out.println("ingrese el numero de noches");
                   noches[numeroHabitacion]= scanner.nextInt();
                    scanner.nextLine();//Consume el salto de linea que deja el nextInt
                   System.out.println("precio por noche $"+PRECIO_POR_NOCHES);
                   System.out.println("total a pagar $"+(PRECIO_POR_NOCHES*noches[numeroHabitacion]));
                   habitacionesOcupadas[numeroHabitacion]= true;
                   System.out.println("se realizo una reserva exitosa");
                   break;
      } //si ingresa el codigo "2" podra hacer la cancelacion de la habitacion del cliente 
          case 2:
           System.out.println("ingrese el numero de la habitacion que desea cancelar");
           int habitacionCancelada = scanner.nextInt()-1;
            if(!habitacionesOcupadas[habitacionCancelada]){
                System.out.println("la habitacion ya esta disponible");
            } else {
                habitacionesOcupadas[habitacionCancelada]= false;
                nombreClientes[habitacionCancelada]= null;
                noches[habitacionCancelada]= 0;
                System.out.println("se realizo la cancelacion con exito");
            }
            break;
            //si ingresa el codigo "3" podra ver un reorte sobre las habitaciones del hotel 
           case 3:
            System.out.println("reporte del hotel");
            for(int i=0; i<5; i++){
                if(habitacionesOcupadas[i]){
                    double totalPagar = noches[i]*PRECIO_POR_NOCHES;
                    System.out.println("habitacion "+(i+1)+" ocupada por "+nombreClientes[i] );
                    System.out.println("numero de noches "+noches[i]+" precio por noche $"+PRECIO_POR_NOCHES );
                    System.out.println("total a pagar $"+totalPagar );
                    }else {
                        System.out.println("habitacion "+(i+1)+" disponible");
                    }
            }
             break;
             //si ingresa el codigo "4" se cerrara el programa 
            case 4:
             System.out.println("saliendo del sistema de reserva...");
            break;
            //si ingresa un codigo que no esta entre las opciones le saldra que esa opcion es incorrecta y lo dejara escoger otra opcion 
            default:
             System.out.println("la opcion es incorrecta, vuelve a intentar");
            break;
      } 
      
    }while(codigo !=4 );//Condicion para cerrar el programa (se cierra el bucle)
}
}