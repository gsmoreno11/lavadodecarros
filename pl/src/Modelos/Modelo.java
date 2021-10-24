 package Modelos;

public class Modelo {
    private String tipo;
    private String fecha;
    private String tipoVehiculo;
    private double costo;
    private String registros[][];

    public String[][] getRegistros() {
        return registros;
    }

    public void setRegistros(String[][] registros) {
        this.registros = registros;
    }
    
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
   
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
     public void CostolavadoAuto(){
         if(this.tipo.equals("lavado basico")){
             
             if(this.tipoVehiculo.equals("Carro")){
                 costo=59000;
             }else if(this.tipoVehiculo.equals("Camioneta")){
                 costo=69000;
             }   
         }else if(this.tipo.equals("lavado especial")){
             if(this.tipoVehiculo.equals("Carro")){
                 costo=65000;
             }else if(this.tipoVehiculo.equals("Camioneta")){
                 costo=79000;
             }   
         }else if(this.tipo.equals("desinfeccion basica")){
             if(this.tipoVehiculo.equals("Carro")){
                 costo=55000;
             }else if(this.tipoVehiculo.equals("Camioneta")){
                 costo=65000;
             }   
         }else if(this.tipo.equals("desinfeccion avanzada")){
             if(this.tipoVehiculo.equals("Carro")){
                 costo=70000;
             }else if(this.tipoVehiculo.equals("Camioneta")){
                 costo=75000;
             }   
         }else if(this.tipo.equals("Combo1")){
             if(this.tipoVehiculo.equals("Carro")){
                 costo=62000;
             }else if(this.tipoVehiculo.equals("Camioneta")){
                 costo=73000;
             }   
         }else if(this.tipo.equals("Combo2")){
             if(this.tipoVehiculo.equals("Carro")){
                 costo=68000;
             }else if(this.tipoVehiculo.equals("Camioneta")){
                 costo=76000;
             }   
         }else if(this.tipo.equals("Combo3")){
             if(this.tipoVehiculo.equals("Carro")){
                 costo=85000;
             }else if(this.tipoVehiculo.equals("Camioneta")){
                 costo=92000;
             }   
         }
     }
     
     public String mostrarvalor(){    
        return ""+this.costo;
         
     }
     public String mostrarfuncionario(String nomF){
         String a="";
         for(int i=0;i<registros.length;i++){
             if(registros[i][0].equals(nomF)){
                 String ser=registros[i][3];
                 String fec=registros[i][2];
                 String cos=registros[i][4];
                 a+="Servicio: "+ser+" Fecha: "+fec+" Costo: "+cos+"";
             }
         }
         return a;
     }
     public String mostrarservicio(String ser){
         String a="";
         for(int i=0;i<registros.length;i++){
             if(registros[i][3].equals(ser)){
                 String nom=registros[i][0];
                 String fec=registros[i][2];
                 String cos=registros[i][4];
                 a+="Funcionario: "+nom+" Fecha: "+fec+" Costo: "+cos+"";
             }
         }
         return a;
     }
     
     public String mostrarfecha(String fech){
         String a="";
         for(int i=0;i<registros.length;i++){
             if(registros[i][2].equals(fech)){
                 String ser=registros[i][3];
                 String nom=registros[i][0];
                 String cos=registros[i][4];
                 a+="Funcionario: "+nom+" Servicio: "+ser+" Costo: "+cos+"";
             }
         }
         return a;
     }
}