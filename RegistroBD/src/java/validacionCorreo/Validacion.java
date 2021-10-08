/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validacionCorreo;

/**
 *
 * @author 57301
 */
public class Validacion {
    public static boolean estado;
    
    public static boolean validarCorreo(String correo){
        estado=false;
        int tamagno = correo.length();
        if((correo.contains("@") && !correo.contains(" "))&&
                (correo.substring(tamagno-4,tamagno).equals(".com")||correo.substring(tamagno-3,tamagno).equals(".es"))) {
            System.out.println("Tiene arroba");
            System.out.println("No tiene espacios");
            System.out.println(".com || .es");
            int posicion_a = correo.indexOf("@")+1;
            estado = true;
            //Que solo tenga un arroba el correo
            while(posicion_a<correo.length() && estado==true) {			
                    if(correo.charAt(posicion_a)=='@') {
                            estado = !estado;
                            System.out.println("Mas de un arroba");
                    }
                    posicion_a++;
            }
        } 
    return estado;
    }
    public static boolean validarFecha(String fecha){
        estado = false;
        try {
            int agno =Integer.parseInt(fecha.substring(6,10));
            int mes = Integer.parseInt(fecha.substring(3,5));
            int dia = Integer.parseInt(fecha.substring(0,2));
            if(dia<=31 && dia>=1 && mes<=12 && mes>=1 && agno>=1921 && agno<=2021){
                if(fecha.charAt(2)=='/'&&fecha.charAt(5)=='/'){
                    estado = true;
                    System.out.println("Fecha bien");
                }
                System.out.println("Fecha Incorrecta");
            }
        } catch (Exception e) {
            System.out.println("Fecha Incorrecta");
        }
        return estado;
    }
    
    public static boolean validarContrasegna(String pass, String pass_1){
        estado = pass.equals(pass_1);
        return  estado;
    }
    
}
