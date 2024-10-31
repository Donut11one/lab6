/**
 * Comic Book class extends Literature.
 * @author Nickolay Makarenko
 * @author Alex He
 * @version 1.0
 */
public class ComicBook extends Literature
{
    private final String title;

    /**
     * constructor of the comic book.
     * @param title title of the comic book as a String
     */
    public ComicBook(final String title)
    {
        this.title = title;
    }

    /**
     * overrides getTitel from literature
     */
    @Override
    public String getTitle()
    {
        return title;
    }
}