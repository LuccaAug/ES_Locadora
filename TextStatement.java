import java.util.Enumeration;

public class TextStatement extends Statement {

  private String[] _strings = {
    "Rental Record for ", 
    "\n", 
    "Amount owed is ", 
    "\n", 
    "You earned ", 
    " frequent renter points", 
  };

  private String getRentalsResult(Enumeration rentals){

    String result = "";

    while (rentals.hasMoreElements()) {
        Rental each = (Rental) rentals.nextElement();
        //show figures for this rental
        result += "\t" + each.getMovie().getTitle()+ "\t" +
        String.valueOf(each.getCharge()) + "\n";
    }

    return result;
  }

  public String value(Customer aCustomer) {
    Enumeration rentals = aCustomer.getRentals();
    String result = _strings[0] + aCustomer.getName() +
    _strings[1];
    result += getRentalsResult(rentals);
    //add footer lines
    result += _strings[2] +
    String.valueOf(aCustomer.getTotalCharge()) + _strings[3];
    result += _strings[4] +
    String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
    _strings[5];
    return result;
  }
}