import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookStore<T extends Literature> {
    private final List<T> items = new ArrayList<>();

    // Method to add an item
    public void addItem(T item) {
        items.add(item);
    }

    // Method to print all items' titles
    public void printItems() {
        for (T item : items) {
            System.out.println(item.getTitle());
        }
    }

    public List<T> getItems() {
        return items;
    }

    // Lambda: Print book titles that match a specific title
    public void printBookTitle(String title) {
        items.forEach(item -> {
            if (item.getTitle().contains(title)) {
                System.out.println(item.getTitle());
            }
        });
    }

    // Method Reference: Sort titles alphabetically
    public void printTitlesInAlphaOrder() {
        items.sort(Comparator.comparing(Literature::getTitle, String::compareToIgnoreCase));
        items.forEach(item -> System.out.println(item.getTitle()));
    }

    // PECS Principle: Add novels to a collection
    public void addNovelsToCollection(List<? super Novel> novelCollection) {
        for (T item : items) {
            if (item instanceof Novel) {
                novelCollection.add((Novel) item);
            }
        }
    }

    // Static Nested Class
    public static class BookStoreInfo {
        public void displayInfo(String storeName, int itemCount) {
            System.out.println("BookStore: " + storeName + ", Items: " + itemCount);
        }
    }

    // Inner Class for Novel Statistics
    public class NovelStatistics {
        public double averageTitleLength() {
            int totalLength = 0;
            for (T item : items) {
                totalLength += item.getTitle().length();
            }
            return (double) totalLength / items.size();
        }
    }
}
