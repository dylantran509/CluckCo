package CluckCo.shoppingCart.home;

public enum Product {
    
    APPLE("Apple.jpg", 0.55f), MILK("Milk.jpg", 0.78f), 
    JUICE("Juice.jpg", 0.56f), LETTUCE("Lettuce.jpg", 0.56f);
    //price and image name *EDIT LATER FOR CLUCK&CO products*
    private String imageFile;
    private float price;

    private Product(String imageFile, float price){
        this.imageFile = imageFile;
        this.price = price;   
    }

    public String getImageFile(){
        return imageFile;
    }

    public float getPrice(){
        return this.price;
    }
}
