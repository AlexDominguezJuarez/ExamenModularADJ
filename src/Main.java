import java.time.Year;
import java.util.Scanner;


public class Main {
    //Funcion ejercicio 1 :linea 6-44
    public static void menu(){
        Scanner in=new Scanner(System.in);
        String eleccionMenu="a";
        while (eleccionMenu != "d"){
            System.out.println("Introduce la letra con la opcion que desees, solo se aceptaran letras minusculas");
            System.out.println("(a). Mayores de edad");
            System.out.println("(b). Calculadora de ingresos de canal de youtube");
            System.out.println("(c). Calculo horario");
            System.out.println("(d.) Salir");
            eleccionMenu=in.nextLine();

            switch (eleccionMenu){
                case "a":
                    int personasMayoresDeEdad=mayoresDeEdad();
                    System.out.println("Hay en total "+personasMayoresDeEdad+" personas con la mayoria de edad");
                    System.out.println("------------------------------------------------");

                    break;
                case "b":
                    double dineroFinalCanal=ingresosCanal();
                    System.out.println("El dinero que ha producido el canal son: "+dineroFinalCanal+"€");
                    System.out.println("------------------------------------------------");

                    break;
                case "c":
                    husoHorario();
                    System.out.println("------------------------------------------------");

                    break;
                case "d":
                    System.out.println("¡Hasta la proxima!");
                    eleccionMenu="d";
                    break;
            }

        }

    }
    //Funciones ejercicio 2: linea 46 - 63
    public static int mayoresDeEdad() {
        Scanner in=new Scanner(System.in);
        System.out.println("Introduce las personas que quieres saber si son mayor de edad");
        int numeroPersonas=in.nextInt();
        int añoActual = Year.now().getValue();

        int añoDeNacimiento;
        int contadorMayorEdad=0;
        for (int i=numeroPersonas;i>1;i--){
            System.out.println("Introduce el año de nacimiento");
            añoDeNacimiento=in.nextInt();
            if (añoActual-añoDeNacimiento >18) {
                contadorMayorEdad++;
            }

        }
        return contadorMayorEdad;
    }

    // Funciones y procedimientos ejercicio 3: lineas 67-121

    public static double cpm (){
        Scanner in=new Scanner(System.in);
        double valorCpm=0;
        System.out.println("Introduce la tematica del video:");
        System.out.println("1. ASMR");
        System.out.println("2. Deportes");
        System.out.println("3. Animales");
        System.out.println("4. Tecnologia");
        System.out.println("5. Bebés");
        int eleccionCpm=in.nextInt();
        while (eleccionCpm<1 || eleccionCpm>6){
            System.out.println("Opcion incorrecta, introducala de nuevo");
            eleccionCpm=in.nextInt();

        }
        switch (eleccionCpm){
            case 1:
                return 0.1;
            case 2:
                return 1;
            case 3:
                return 0.2;
            case 4:
                return 0.5;
            case 5:
                return 0.5;
        }
        return valorCpm;
    }


    public static double ingresosVideo(){
        Scanner in=new Scanner(System.in);
        System.out.println("Introduce el numero de visitas del video");
        int numeroVisitas=in.nextInt();
        double cpm= cpm();
        double ingresosVideo=(numeroVisitas*cpm)/1000;
        return ingresosVideo;

    }

    public static double ingresosCanal() {   //Funcion principal
        Scanner in=new Scanner(System.in);
        int numeroCondicion = 1;
        double dineroVideos=0;
        while (numeroCondicion==1) {
            dineroVideos = ingresosVideo()+dineroVideos;
            System.out.println("Ingresos actuales: "+dineroVideos);
            System.out.println("------------------------------------------------");
            System.out.println("Pulsa 1 si quiere sumar otro video, pulsa cualquier otro numero para salir");
            numeroCondicion= in.nextInt();
        }
        return dineroVideos;

    }
    //Funciones y procedimienmtos ejercicio 4: lineas 124-220

    public static void husoHorario (){    //Funcion principal
        String pmOam="A";
        String pmOamHoraActualizada="B";
        Scanner in=new Scanner(System.in);

        int horas=horasFuncionHuso();    //devuelve las horas

        int minutos=minutosFunvcionHuso();    //devuelve los minutos

        pmOam=amOpmFuncionHuso();    //devuelve si es am o pm

        int husoHorario=calcularHusoFuncionHuso();    //devuelve el huso horario

        int horasConUsoHorario=horas+husoHorario;

        if (horasConUsoHorario<0){
            horasConUsoHorario=horasConUsoHorario+12;
            if (pmOam == "AM") {
                pmOamHoraActualizada = "PM";
            } else if (pmOam == "PM") {
                pmOamHoraActualizada = "AM";

            }

            }

        if (horasConUsoHorario>12) {
            horasConUsoHorario=horasConUsoHorario-12;
            if (pmOam == "AM") {
                pmOamHoraActualizada = "PM";
            } else if (pmOam == "PM") {
                pmOamHoraActualizada = "AM";

            }
        }
//Creo este if para soluciuonar el problema de que me aparezca el signo de + o - en el huso horario

        if (husoHorario>0){
            System.out.println(horas + ":" + minutos + " " + pmOam + " (+" + husoHorario + ")   ->  "+horasConUsoHorario+":"+minutos+" "+pmOamHoraActualizada);

        }else{
            System.out.println(horas + ":" + minutos + " " + pmOam + " (" + husoHorario + ")   ->  "+horasConUsoHorario+":"+minutos+" "+pmOamHoraActualizada);
        }
    }

    public static int horasFuncionHuso(){
        System.out.println("Introduce las horas del lugar con huso horario 0 (de las 0 a las 12)");
        Scanner in=new Scanner(System.in);
        int horas=in.nextInt();
        while ((horas<0)|| (horas>24)){
            System.out.println("incorrectas, introduzca la hora de nuevo");
            horas=in.nextInt();
        }
        return horas;
    }

    public static int minutosFunvcionHuso(){
        Scanner in=new Scanner(System.in);
        System.out.println("Introduce los minutos del lugar original");
        int minutos=in.nextInt();
        while ((minutos>60)||(minutos<0)){
            System.out.println("Minutos incorrectos, introduzcalos de nuevo");
            minutos=in.nextInt();
        }
        return minutos;
    }

    public static String amOpmFuncionHuso() {
        Scanner in = new Scanner(System.in);
        String amOpm="";



        System.out.println("Pulsa 1 si la hora está en AM / Pulsa 2 si la hora esta en PM");
        int amOPm = in.nextInt();
        switch (amOPm) {
            case 1:
                return "AM";

            case 2:
                return
                        "PM";

        }
        return  amOpm;
    }

    public static int calcularHusoFuncionHuso(){
        Scanner in=new Scanner(System.in);
        System.out.println("introduce el uso horario del pais a calcular la hora");
        int usoHorario=in.nextInt();
        while ((usoHorario< -11) || (usoHorario>12)){
            System.out.println("Uso horario incorrecto, introduzca un valor del 12 al -11");
            usoHorario=in.nextInt();
        }
    return usoHorario;
    }

    // Procedimiento main

    public static void main(String[] args) {
        menu();
    }
}
