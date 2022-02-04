public class RegularPrice extends Price {
   public int getPriceCode() {
       return Movie.REGULAR;
   }
     
   public double getCharge(int daysRented){
    double thisAmount = 2;
    if (daysRented > 2)
        thisAmount += (daysRented - 2) * 1.5;
    
    return thisAmount;
  }
}