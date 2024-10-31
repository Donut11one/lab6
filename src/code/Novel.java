/**
 * Novelclass extends Literature.
 * @author Nickolay Makarenko
 * @author Alex He
 * @version 1.0
 */
public class Novel extends Literature
{
    private final String title;

    /**
     * constructor for a novel calss
     * @param title title of the novel as a string.
     */
    public Novel(final String title)
    {
        this.title = title;
    }

    /**
     * Overrides getTitle method from literature
     */
    @Override
    public String getTitle()
    {
        return title;
    }


}




