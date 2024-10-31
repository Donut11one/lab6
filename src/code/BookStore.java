import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Book store class extends Literature to keep track of a list of items inside of a bookstore.
 * @author Nickolay Makarenko
 * @author Alex He
 * @version 1.0
 */
public class BookStore<T extends Literature> {
    private final List<T> items = new ArrayList<>();

    /**
     * adds an item to to the list.
     * @param item an item to add to the list as any type object
     */
    public void addItem(final T item)
    {
        items.add(item);
    }

    /** 
     * Method to print all items' titles.
     */
    public void printItems()
    {
        for (T item : items)
        {
            System.out.println(item.getTitle());
        }
    }

    /**
     * get all tiems of the list.
     * @return a list of all items in the bookstore
     */
    public List<T> getItems()
    {
        return items;
    }

    /**
     * print all books title that match the specific title.
     * @param title title of the book as a string
     */
    public void printBookTitle(final String title) {
        items.forEach(item -> {
            if (item.getTitle().contains(title)) {
                System.out.println(item.getTitle());
            }
        });
    }

    /**
     * Prints the all items' titles in alphabetical order.
     */
    public void printTitlesInAlphaOrder() {
        items.sort(Comparator.comparing(Literature::getTitle, String::compareToIgnoreCase));
        items.forEach(item -> System.out.println(item.getTitle()));
    }

    /**
     * Adds a list of novels to items.
     * @param novelCollection list of objects that extends Novel
     */
    public void addNovelsToCollection(final List<? super Novel> novelCollection) {
        for (T item : items) {
            if (item instanceof Novel) {
                novelCollection.add((Novel) item);
            }
        }
    }

    /**
     * Innerclass of the information of the bookstore
     */
    public static class BookStoreInfo
    {
        /**
         * display the info of the bookstore
         * @param storeName name of the store as a string
         * @param itemCount total count of items in bookstore as an int
         */
        public void displayInfo(final String storeName,
                                final int itemCount)
        {
            System.out.println("BookStore: " + storeName + ", Items: " + itemCount);
        }
    }

    /**
     * Innerclass to get Novel Staticsics
     */
    public class NovelStatistics
    {
        /**
         * Calculates the average length of all titles.
         * @return averge length of titles as a double
         */
        public double averageTitleLength()
        {
            int totalLength = 0;
            for (T item : items)
            {
                totalLength += item.getTitle().length();
            }
            return (double) totalLength / items.size();
        }
    }
}
