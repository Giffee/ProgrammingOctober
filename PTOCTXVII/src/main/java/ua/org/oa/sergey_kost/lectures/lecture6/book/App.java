package ua.org.oa.sergey_kost.lectures.lecture6.book;

public class App {
    private static final String PATH = "./src/main/java/ua/org/oa/sergey_kost/lectures/lecture6/book/";

    public static void main(String[] args) {
        Book book = new Book("Harry Potter-7.2", "J.K. Rolling", 2009);
        Book book1 = new Book("Warcraft", "Richard Khnaak", 2001);
        Book book2 = new Book("Padenie Adama", "Sandra Brown", 1980);

        BookStorage bs = new BookStorage(PATH, PATH + "addBooks.txt");
        bs.writeToFile(book);
        bs.writeToFile(book); //Already
        bs.writeToFile(book1);
        bs.writeToFile(book2);
        bs.serialization();
        System.out.println(bs.deserialization());


    }
}
