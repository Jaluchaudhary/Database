 import java.util.Scanner;
 import javax.swing.JOptionPane;
            
  public class MonthlyBill{
            
    public static void main(String[] args) {
            
                 Scanner keyboard = new Scanner(System.in); // Scanner can get the input.
                  
                   double minKilowatt = 0.0; // Set all customer recored
                   double maxKilowatt = 1000.0;
                   double lowRateKilowattMin = 200.0;
                   double lowRate = 0.08;
                   double highRate = 0.11;
                   double totalOwed = 0.0;
                   int numCustomers = 0;
                    
    //System.out.println("Enter the monthly bill");
     System.out.println("Enter the customer number");
     System.out.println("Enter the customer name");
     System.out.println("Enter the kilowatt used");
     //System.out.println("Enter the anount owed");
         
            
                  // Monthaly bill report heading
                  StringBuffer sb = new StringBuffer();// Buffer is a Sring builder sb represent the StringBuffer
                  sb.append("Monthly Billing Report" + "\n"); // This is a heading and append method can append the contant. 
                  sb.append("\n\n");
                  
                 sb.append("Customer Number | Customer Name | Kilowatts Used | Amount Owed" + "\n");// This is sub heading
                  
                  
                  System.out.print("Enter Customer Number or (QUIT): "); // customerNumber prompt
            
     String customerNumber; // read customerNumber on String format
     customerNumber = keyboard.nextLine();
            
      double amountOwed = 0.0;
      double kilowattsUsed = 0.0;
      String customerName = "";
                     
                while (!customerNumber.equalsIgnoreCase("QUIT")) // Start DOWHILE
                {
           
                do {
               try {    // try block
               int custNumber = Integer.parseInt(customerNumber);
               break;
                } 
                catch (Exception e)// catch block
                 {
            System.out.println("ERROR, Invalid number!");
            System.out.print("Please enter valid Customer Number or (QUIT to Exit): ");
            customerNumber = keyboard.nextLine();
            if (customerNumber.equalsIgnoreCase("QUIT")){
            return;
            }
            }
            } while (true);
            
           
   System.out.print("Enter Customer Name: ");
   customerName = keyboard.nextLine();
            
            do {
            System.out.print("Enter KiloWatts used: ");
            
            try {
            String kilowatts = keyboard.nextLine();
            kilowattsUsed = Double.parseDouble(kilowatts);
            }
            catch(Exception ex) {
            kilowattsUsed = -1;
            }
            
            if (kilowattsUsed < minKilowatt || kilowattsUsed >= maxKilowatt) {
            System.out.println("ERROR! Please enter a valid number of kilowatts");
            }
            
            } while (kilowattsUsed < minKilowatt && kilowattsUsed >= maxKilowatt);
            
                        
    if (kilowattsUsed < lowRateKilowattMin)
      {
    amountOwed = kilowattsUsed * highRate;
    } else 
    {
   amountOwed = kilowattsUsed * lowRate;
    }
            
          totalOwed = totalOwed + amountOwed;
          numCustomers = numCustomers + 1;
            
           
            sb.append(customerNumber + " | " + customerName + " | " + kilowattsUsed + " | $" + String.format("%.2f", amountOwed) + "\n");// PRINT customerNumber, customerName, kilowattsUsed, amountOwed

            
            System.out.print("Enter Customer Number (QUIT to Exit): ");// customer Number read
            customerNumber = keyboard.nextLine();
            }
            
            sb.append("\n\n");
            if (numCustomers > 0) {
            sb.append("Number of Customers: " + numCustomers + "\n");
            sb.append("Total Owed: $" + String.format("%.2f",totalOwed) + "\n");
            } else {
            sb.append("No customers entered" + "\n");
            }
            
     JOptionPane.showMessageDialog(null, sb.toString(), "Message", JOptionPane.INFORMATION_MESSAGE); // This is a print a message 
      }
            
   }