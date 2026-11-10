package ua.opnu;

public class BookData implements Comparable<BookData> {
    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public double getRating() {
        if (reviews == 0) return 0;
        return total / reviews;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(BookData other) {
        // Книга з більшим рейтингом має бути "меншою" (сортування за спаданням)
        int ratingComparison = Double.compare(other.getRating(), this.getRating());
        if (ratingComparison != 0) {
            return ratingComparison;
        }
        // У разі рівності рейтингів порівнюємо за назвою
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return String.format("Книга '%s' (Рейтинг: %.2f)", title, getRating());
    }
}