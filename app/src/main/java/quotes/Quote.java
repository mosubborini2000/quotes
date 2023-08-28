package quotes;

import java.util.Arrays;
import java.util.List;

public class Quote {
    private String[] tags;
    private String author;
    private String likes;
    private String text;

    public Quote() {

    }

    public String[] getTags() {
        return tags;
    }

    public String getAuthor() {
        return author;
    }

    public String getLikes() {
        return likes;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {

        return "Quote{" +
                "tags=" + tags + "" +
        '}';

    }
}
