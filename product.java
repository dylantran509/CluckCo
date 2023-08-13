public class product {

    private String prodName;
    private String prodImg;
    private String prodPrice;
    private double prodDPrice;

    public String getProdName(){
        return prodName;
    }
    
    public void setProdName(String prodName){
        this.prodName = prodName;
    }

    public  String getProdImg(){
        return prodImg;
    }

    public void setProdImg(String image){
        prodImg = image;
    }

    public String getProdPrice(){
        return prodPrice;
    }

    public void setProdPrice(String price){
        prodPrice = price;
    }

    public void setProdDPrice(double price){
        prodDPrice = price;
    }

    public double getProdDPrice(){
        return prodDPrice;
    }
}


//Card class on video
/*  Hbox = box
 *  imageView = image
 *  label = Book/Product
 *  lable = price 
 * 
 * 
 * 
 *  copy and past under CardControler (code)
 * 
 *  public void set Data(Book book) at 19:23
 */