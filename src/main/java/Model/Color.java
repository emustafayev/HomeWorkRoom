package Model;

public enum Color{
    Green(80),
    Gray(90),
    Black(70),
    Red(100);
    private float price;

    Color(float price){
        this.price=price;
    }

    public float getPrice(){
        return this.price;
    }
}
