public  class Chaudiere {

    // un unique champ priv� : l'�tat de notre chaudi�re
    private  int temperature ;

    public Chaudiere() {
       this.temperature =  0 ;
   }

    public  int getTemperature() {
       return  this.temperature ;
   }

    public  void augmenteTemperature() {
       this.temperature =  this.temperature +  1 ;
   }
}