package Decorador.Gestor_Decorador;

public class MainDecorador {

    static GestorAtaque gestor;

    public static void main(String[] args) {
        gestor = new GestorAtaque();

        /**INICIA LA VARIABLE DE LOS PERSONAJES **/
           gestor.nuevaPersona(0,1);
         gestor.nuevaPersona(1,2);
         gestor.nuevaPersona(2,3);

        /**LA PRIMER PRUEBA DE IMPRESION LA TIRO BIEN
         * pId 0 = Artilleros
         * pId 1 = Infanteria
         * pId 2 = Tanque
         * **/
           //Artilleros imprime
         printer(gestor.printPersonaje(0)+"\n");

         //Infanteria imprime
         printer(gestor.printPersonaje(1)+"\n");

         //Tanque imprime
         printer(gestor.printPersonaje(2)+"\n");

         System.out.println("SEGUNDA PRUEBA ARTILLEROS");

        /**LA SEGUNDA PRUEBA DE IMPRESION DE ARTILLERO FUNCIONO **/
        //IMPRIME EL ATAQUE DOBLE

        gestor.decorarCategoria(0, 4);
        printer(gestor.printPersonaje(0) + "\n");
        gestor.QuitarDecorarPersona(0);

      //IMPRIME LA DEFENSA DOBLE
      gestor.decorarCategoria(0, 5);
      printer(gestor.printPersonaje(0)+"\n");
      gestor.QuitarDecorarPersona(0);

      //IMPRIME LA DOS CASILLAS EL ATAQUE
      gestor.decorarCategoria(0, 3);
      printer(gestor.printPersonaje(0)+"\n");
      gestor.QuitarDecorarPersona(0);

        System.out.println("TERCER PRUEBA INFANTERIA");

        /**LA SEGUNDA PRUEBA DE IMPRESION DE INFANTERIA FUNCIONO **/

          //IMPRIME EL HEALER
         gestor.decorarCategoria(1, 6);
         printer(gestor.printPersonaje(1)+"\n");
         gestor.QuitarDecorarPersona(1);

         //IMPRIME EL SUMA DE ATAQUE 3 PUNTOS
         gestor.decorarCategoria(1, 7);
         printer(gestor.printPersonaje(1)+"\n");
         gestor.QuitarDecorarPersona(1);

         //IMPRIME EL SUMA DE DEFENSA 3 PUNTOS
         gestor.decorarCategoria(1, 8);
         printer(gestor.printPersonaje(1)+"\n");
         gestor.QuitarDecorarPersona(1);

        System.out.println("CUARTA PRUEBA TANQUE");

        /**LA TERCER PRUEBA DE IMPRESION DE TAMQUE FUNCIONO **/

         //IMPRIME EL ATAQUE BOMBA
         gestor.decorarCategoria(2, 9);
         printer(gestor.printPersonaje(2)+"\n");
         gestor.QuitarDecorarPersona(2);

         //IMPRIME EL DOBLE VIDA MOVIMIENTO
         gestor.decorarCategoria(2, 10);
         printer(gestor.printPersonaje(2)+"\n");
         gestor.QuitarDecorarPersona(2);

         //IMPRIME LA PROTECCION AL ALIADO
         gestor.decorarCategoria(2, 11);
         printer(gestor.printPersonaje(2)+"\n");
         gestor.QuitarDecorarPersona(2);


         //Artilleros imprime
         printer(gestor.printPersonaje(0)+"\n");
         //Infanteria imprime
         printer(gestor.printPersonaje(1)+"\n");

         System.out.println("ATACANDO");

         //gestor.matarPersonaje(0);

         //Artilleros imprime
         printer(gestor.printPersonaje(0)+"\n");
         }

         public static void printer(String pData) {
         System.out.println(pData);
         }

    }


