import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // Create a BookStore that stores all types of Literature
        BookStore<Literature> store = new BookStore<>();

        // Add different types of literature
        store.addItem(new Novel("War and Peace"));
        store.addItem(new ComicBook("Spider-Man"));
        store.addItem(new Magazine("National Geographic"));

        // Print all items in the store
        store.printItems();  // Should print: War and Peace, Spider-Man, National Geographic

        // Search and print books with "War" in the title
        System.out.println("\nBooks containing 'War':");
        store.printBookTitle("War");

        // Sort and print book titles in alphabetical order
        System.out.println("\nTitles in alphabetical order:");
        store.printTitlesInAlphaOrder();

        // Use the PECS principle to add novels to a collection
        List<Novel> novelCollection = new ArrayList<>();
        store.addNovelsToCollection(novelCollection);
        System.out.println("\nNovels in the collection:");
        for (Novel novel : novelCollection) {
            System.out.println(novel.getTitle());
        }

        // Use a static nested class to display store info
        BookStore.BookStoreInfo info = new BookStore.BookStoreInfo();
        info.displayInfo("My Book Store", store.getItems().size());

        // Use inner class to calculate novel statistics
        BookStore<Literature>.NovelStatistics stats = store.new NovelStatistics();
        System.out.println("\nAverage title length: " + stats.averageTitleLength());

        // Sort books by title length using an anonymous inner class
        System.out.println("\nTitles sorted by length:");
        store.getItems().sort(new Comparator<Literature>() {
            @Override
            public int compare(Literature o1, Literature o2) {
                return Integer.compare(o1.getTitle().length(), o2.getTitle().length());
            }
        });
        store.printItems();
    }
}
