import java.util.Enumeration;

public class HtmlStatement extends Statement {

  private String[] _strings = {
    "<H1>Rentals for <EM>", 
    "</EM></H1><P>\n", 
    "<P>You owe <EM>", 
    "</EM><P>\n", 
    "On this rental you earned <EM>" , 
    "</EM> frequent renter points<P>", 
  };

  private String getRentalsResult(Enumeration rentals){

    String result = "";

    while (rentals.hasMoreElements()) {
        Rental each = (Rental) rentals.nextElement();
        //show figures for each rental
        result += each.getMovie().getTitle()+ ": " +
        String.valueOf(each.getCharge()) + "<BR>\n";
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