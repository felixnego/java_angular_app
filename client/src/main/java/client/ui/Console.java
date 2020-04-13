package client.ui;

import client.service.ClientServiceClient;
import client.service.SaleServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import client.service.BookServiceClient;
import fel.web.dto.*;

import java.util.Scanner;

@Component
public class Console {
    @Autowired
    private BookServiceClient bookService;

    @Autowired
    private ClientServiceClient clientService;

    @Autowired
    private SaleServiceClient saleService;

    public void runConsole(){
        printMenu();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String option = scanner.next();
            if (option.equals("x")){
                break;
            }
            switch(option) {
                case "1":
                    listBooks();
                    break;
                case "2":
                    addBook();
                    break;
                case "3":
                    deleteBook();
                    break;
                case "4":
                    updateBook();
                    break;
                case "5":
                    listClients();
                    break;
                case "6":
                    addClient();
                    break;
                case "7":
                    deleteClient();
                    break;
                case "8":
                    updateClient();
                    break;
                case "9":
                    buyBook();
                    break;
                case "10":
                    report();
                    break;
                default:
                    System.out.println("Invalid option!");
            }
            printMenu();
        }
    }

    private void report() {
        System.out.println(saleService.getAllSales());
    }

    private void buyBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Client id = ");
        Long clientID = Long.parseLong(scanner.nextLine());

        System.out.println("Book id = ");
        Long bookID = Long.parseLong(scanner.nextLine());

        SaleDto sale = new SaleDto(clientID, bookID);

        System.out.println(saleService.saveSale(sale));
    }

    private void updateClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("id = ");
        Long id = Long.parseLong(scanner.nextLine());

        System.out.println("name = ");
        String name = scanner.nextLine();

        System.out.println("email = ");
        String email = scanner.nextLine();

        clientService.updateClient(id, new ClientDto(name, email));
    }

    private void deleteClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("id = ");
        Long id = Long.parseLong(scanner.nextLine());
        clientService.deleteById(id);
    }

    private void addClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name = ");
        String name = scanner.nextLine();

        System.out.println("email = ");
        String email = scanner.nextLine();

        ClientDto client = new ClientDto(name, email);

        System.out.println(clientService.saveClient(client));
    }

    private void listClients() {
        ClientsDto clientsDto = clientService.getAllClients();
        System.out.println(clientsDto);
    }

    private void updateBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("id = ");
        Long id = Long.parseLong(scanner.nextLine());

        System.out.println("title = ");
        String title = scanner.nextLine();

        System.out.println("author = ");
        String author = scanner.nextLine();

        System.out.println("price = ");
        int price = Integer.parseInt(scanner.nextLine());

        System.out.println("year = ");
        int year = Integer.parseInt(scanner.nextLine());
        BookDto bookDto = new BookDto(title, author, price, year);
        bookDto.setId(id);
        bookService.updateBook(id, bookDto);
    }

    private void deleteBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("id = ");
        Long id = Long.parseLong(scanner.nextLine());
        bookService.deleteById(id);
    }

    private void addBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("title = ");
        String title = scanner.nextLine();

        System.out.println("author = ");
        String author = scanner.nextLine();

        System.out.println("price = ");
        int price = Integer.parseInt(scanner.nextLine());

        System.out.println("year = ");
        int year = Integer.parseInt(scanner.nextLine());

        BookDto book = new BookDto(title, author, price, year);

        System.out.println(bookService.saveBook(book));
    }

    private void listBooks() {
        BooksDto booksDto = bookService.getAllBooks();
        System.out.println(booksDto);
    }

    private void printMenu() {
        System.out.println("1 - List Books\n" +
                "2 - Add Book\n" +
                "3 - Delete Book\n" +
                "4 - Update Book\n" +
                "5 - List Clients\n" +
                "6 - Add Client\n" +
                "7 - Delete Client\n" +
                "8 - Update Client\n" +
                "9 - Buy Book\n" +
                "10 - Report\n" +
                "x - Exit");

    }

}
