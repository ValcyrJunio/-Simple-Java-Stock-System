import java.util.Objects;
import java.util.Scanner;


public class simpleStock {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int position = 0;
        int option = 0;
        int total = 0;
        int [] quantity = new int[15];
        String [] products = new String[15];

        while (option != 7){
            boolean found = false;
            System.out.println("=== INVENTORY SYSTEM === ");
            System.out.println("1 - Add product \n 2 - Remove a product \n 3 - List all products \n 4 - Add quantity \n 5 - Remove quantity \n 6 - Search for a product \n  7 - Leave  ");
            option = scan.nextInt();
            scan.nextLine();

            switch (option){
                case 1:
                    if (total < products.length){
                    System.out.println("Type the product name: ");
                    products [total] = scan.nextLine();
                    System.out.println("Quantity: ");
                    quantity [total] = scan.nextInt();
                    total++;
                    }else {
                        System.out.println("Inventory is full");
                    }
                    continue;

                case 2:
                    System.out.println("Type the position of the product");
                    position = scan.nextInt();
                    if (position >= 0 && position <= total) {
                        for (int i = position; i <= total - 1; i++) {
                            products[i] = products[i + 1];
                            quantity[i] = quantity[i + 1];
                        }
                        total--;
                    }else {
                        System.out.println("Type a valid position ");
                    }
                    continue;

                case 3:
                    System.out.println("Position | Name | Quantity");
                    for (int i = 0 ; i < total ; i++ ){
                        System.out.printf("[%d - %s - %d]\n", i, products[i], quantity[i]);
                    }
                    continue;

                case 4:
                    System.out.println("Type the product position");
                    position = scan.nextInt();
                    if (position >=0 && position <= total) {
                        System.out.println("How much you want to add?");
                        int add = scan.nextInt();
                        quantity[position] += add;
                    } else {
                        System.out.println("Type a valid position!!");
                    }
                    continue;

                case 5:
                    System.out.println("Type the product position");
                    position = scan.nextInt();
                    if (position >= 0 && position <= total) {
                        System.out.println("How much you want to remove?");
                        int remove = scan.nextInt();
                        if (remove <= quantity[position]) {
                            quantity[position] -= remove;
                        } else {
                            System.out.println("Not enough stock!");
                        }
                    } else {
                        System.out.println("Type a valid position!");
                    }

                case 6:
                    System.out.println("Type the name of the product that you are searching for: ");
                    String name = scan.nextLine();
                    for (int i = 0 ; i < total ; i++){
                        if (products[i].toLowerCase().contains(name.toLowerCase())){
                            System.out.printf("[Id = %d | Product = %s | Quantity = %d] \n", i, products[i], quantity[i]);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("ERROR - CAN'T FIND THE PRODUCT");
                    }
            }

        }
        scan.close();
    }
}
