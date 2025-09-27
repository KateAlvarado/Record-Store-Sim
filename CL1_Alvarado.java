 /* Kate Alvarado
[CS1101] Comprehensive Lab 1
This work is to be done individually. It is not permitted to.
share, reproduce, or alter any part of this assignment for any
purpose. Students are not permitted to share code, upload
this assignment online in any form, or view/receive/
modifying code written by anyone else. This assignment is part.
of an academic course at The University of Texas at El Paso and
a grade will be assigned for the work produced individually by
the student.
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CL1_Alvarado{ 
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		//fix indentations

	try{

		boolean condition = true;
		File file = new File("albums.txt"); //initializes file
		Scanner input = new Scanner(file); //file reading
		double totalPrice = 0;
		int cartContents = 0;
		 
		while(condition){ 

		System.out.println("Welcome to Miner Disco!" + "\n 1. Order" + "\n 2. View Current Order" + 
			"\n 3. Clear Cart Contents" + "\n 4.Checkout" + "\n 5. Exit Miner Disco");
			
			int nextInt = scanner.nextInt(); //takes user input
			//scanner.nextLine();

			switch(nextInt){ 
				case 1:
					System.out.println("Please select a genre from which your desired album is in:" +
						"\n 1) Rock" + "\n 2) Pop" + "\n 3) Hip-Hop" + "\n 4) Electronic" + "\n 5) Rap");
						
					//scanner.nextLine(); //eats white space to cont reading
					String userInputGenre = scanner.nextLine(); 

					Scanner firstSelection = new Scanner(file); //rereads file
					boolean genreExists = false;
						
						
					while(firstSelection.hasNextLine()){ // continues as long as there is a next line in file
							
						String currentSongName = firstSelection.next(); 
						String currentGenre = firstSelection.next();
						double currentPrice = firstSelection.nextDouble();
						firstSelection.nextLine(); //eats space

						if(userInputGenre.equalsIgnoreCase(currentGenre)){ //checks the genre before printing
								// print the three variables, they will update as you go along
							System.out.println("Title:" + " " + currentSongName);
							System.out.println("Genre:" + " " + currentGenre);
							System.out.println("Price:" + " " + currentPrice);
							genreExists = true;
						}
					}
						if (!genreExists){
							System.out.println("No albums for this genre.");
						}
						
						System.out.println("Which album would you like to buy?");				
						String albumChoice = scanner.nextLine(); //user input
						boolean albumExists = false; //tracks if album exists
							
						firstSelection = new Scanner(file); //rereads file
						while (firstSelection.hasNextLine()){
							String currentAlbumName = firstSelection.next(); //reads album name
							String currentGenre = firstSelection.next();
							double currentPrice = firstSelection.nextDouble();
							firstSelection.nextLine();

							if(albumChoice.equalsIgnoreCase(currentAlbumName)){
								System.out.println("Album added to cart!");
								albumExists = true;
								cartContents++;
								totalPrice += currentPrice;
							}
							
						}
							
							if(!albumExists){
								System.out.println("Sorry! Album not in stock.");
							}
						break;

				case 2: //view order
						System.out.println("------- CART -------");
						System.out.println("Number of items:" + cartContents);
						System.out.println("Total:" + totalPrice);
						break;

				case 3:
						System.out.println("Are you sure you want to clear the contents in your cart? (yes/no)");
						scanner.nextLine();
						String userDecision = input.nextLine();

					if(userDecision.equalsIgnoreCase("yes")){
						cartContents = 0;
						totalPrice = 0;
						System.out.println("Cart cleared succesfully.");
					}else{
					System.out.println("Cart not cleared. Continue shopping!");
					}

					
					break;

				case 4://checkout 
						System.out.println("Would you like pick up or delivery? \n Enter 1 for pickup. \n Enter 2 for delivery.");
						int checkOut = input.nextInt();
						scanner.nextLine();

					if(checkOut == 2) { 
						System.out.println("Delivery includes a $7.00 delivery fee.");
					}

					System.out.println("Enter your 16 digit card number to purchase:");
					String cardNumber = input.nextLine();
					if(cardNumber.length() == 16){
						double tax = totalPrice * 0.0825;
						double finalTotal = totalPrice + tax + 7.00;
						System.out.println("Order Summary: \n Number of items:" + cartContents + "\n" + "Subtotal: $" + totalPrice + "\n Delivery Fee: $7.00 \n Tax (8.25%): $" + tax + "\n Final Total:" + finalTotal);
					}else{
						System.out.println("Invalid input. Please try again:");
					}	
					
					break;

				case 5:
					condition = false;
					System.out.println("Thank you for using Miner Disco!");
			
			}		break;

			}
		}catch (Exception error){
			System.out.println(error); 
	}
  }
}
	




