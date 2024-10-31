/**
 * Magazine class extends Literature.
 * @author Nickolay Makarenko
 * @author Alex He
 * @version 1.0
 */
public class Magazine extends Literature
{
    private final String title;

    /**
     * Constructor of magazine class.
     * @param title title of the magazine as a String.
     */
    public Magazine(final String title)
    {
        this.title = title;
    }

    /**
     * overrides getTitle from Literature
     */
    @Override
    public String getTitle()
    {
        return title;
    }
}
