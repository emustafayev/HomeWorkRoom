package Model;

public enum FloorType{
   Laminate(200),
   Timber(250),
   Vinyl(240),
   Carpet(190),
   Bamboo(234);

   private float price;
   FloorType(float price){
       this.price=price;
   }

   public float getPrice(){
       return price;
   }
}
