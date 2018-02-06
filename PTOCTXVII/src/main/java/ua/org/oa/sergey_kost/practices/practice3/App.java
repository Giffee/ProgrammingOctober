package ua.org.oa.sergey_kost.practices.practice3;

public class App {
    public static void main(String[] args) {
        GenericStorage<Integer, Movie> movieStorage = new GenericStorageImpl<>();
        System.out.println("Create: id = " + movieStorage.create(new Movie("Avatar", "fantasy", "USA", "Film with very good special effects")));
        System.out.println("Create: id = " + movieStorage.create(new Movie("Matrix", "thriller", "USA", "The world of the Matrix is an illusion that exists only in the endless dream of a doomed humanity")));
        System.out.println("Read: " + movieStorage.read(1));
        System.out.println("Read: " + movieStorage.read(2));
        System.out.println("Updated: " + movieStorage.update(1, new Movie("Avatar 2", "fantasy", "USA", "Didn't finished yet")));
        System.out.println("Deleted: " + movieStorage.delete(1));
        System.out.println("Read: " + movieStorage.read(1));

    }
}
