package TrialPodcast;
import java.util.Arrays;

public class PodcastManager {
    private static final int INITIAL_GENRE_CAPACITY = 10;
    private Genre[] genres;
    private int genreCount;

    public PodcastManager() {
        genres = new Genre[INITIAL_GENRE_CAPACITY];
        genreCount = 0;

        // Add some default genres
        addGenre("Technology");
        addGenre("Health");
        addGenre("Comedy");
        addGenre("History");
        addGenre("Business");

        // Add some sample podcasts
        addSamplePodcasts();
    }

    public void addGenre(String name) {
        if (genreCount == genres.length) {
            genres = Arrays.copyOf(genres, genres.length * 2);
        }

        genres[genreCount++] = new Genre(name);
    }

    public void displayGenres() {
        System.out.println("\n--- Available Genres ---");
        for (int i = 0; i < genreCount; i++) {
            System.out.println((i + 1) + ". " + genres[i].getName() +
                    " (" + genres[i].getPodcastCount() + " podcasts)");
        }
    }

    public int getGenreCount() {
        return genreCount;
    }

    public void displayPodcastsByGenre(int genreIndex) {
        if (genreIndex < 0 || genreIndex >= genreCount) {
            System.out.println("Invalid genre index.");
            return;
        }

        Genre genre = genres[genreIndex];
        System.out.println("\n--- " + genre.getName() + " Podcasts ---");

        if (genre.getPodcastCount() == 0) {
            System.out.println("No podcasts in this genre yet.");
            return;
        }

        for (int i = 0; i < genre.getPodcastCount(); i++) {
            Podcast podcast = genre.getPodcast(i);
            System.out.println((i + 1) + ". " + podcast.getTitle() + " - " + podcast.getDescription());
        }
    }

    public void addPodcastToGenre(int genreIndex, Podcast podcast) {
        if (genreIndex < 0 || genreIndex >= genreCount) {
            System.out.println("Invalid genre index.");
            return;
        }

        genres[genreIndex].addPodcast(podcast);
    }

    public void removePodcastFromGenre(int genreIndex, int podcastIndex) {
        if (genreIndex < 0 || genreIndex >= genreCount) {
            System.out.println("Invalid genre index.");
            return;
        }

        Genre genre = genres[genreIndex];

        if (podcastIndex < 0 || podcastIndex >= genre.getPodcastCount()) {
            System.out.println("Invalid podcast index.");
            return;
        }

        if (genre.removePodcast(podcastIndex)) {
            System.out.println("Podcast removed successfully.");
        } else {
            System.out.println("Failed to remove podcast.");
        }
    }

    public int getPodcastCount(int genreIndex) {
        if (genreIndex < 0 || genreIndex >= genreCount) {
            return 0;
        }
        return genres[genreIndex].getPodcastCount();
    }

    public Podcast getPodcast(int genreIndex, int podcastIndex) {
        if (genreIndex < 0 || genreIndex >= genreCount) {
            return null;
        }

        Genre genre = genres[genreIndex];

        if (podcastIndex < 0 || podcastIndex >= genre.getPodcastCount()) {
            return null;
        }

        return genre.getPodcast(podcastIndex);
    }

    private void addSamplePodcasts() {
        // Technology podcasts
        addPodcastToGenre(0, new Podcast("TechTalk", "Latest in technology news and trends"));
        addPodcastToGenre(0, new Podcast("Future of AI", "Exploring artificial intelligence advancements"));
        addPodcastToGenre(0, new Podcast("Coding 101", "Programming basics for beginners"));

        // Health podcasts
        addPodcastToGenre(1, new Podcast("Wellness Journey", "Tips for a healthier lifestyle"));
        addPodcastToGenre(1, new Podcast("Nutrition Facts", "Understanding what you eat"));

        // Comedy podcasts
        addPodcastToGenre(2, new Podcast("Laugh Hour", "Stand-up comedy and funny stories"));
        addPodcastToGenre(2, new Podcast("Funny Stories", "Real-life humorous tales"));

        // History podcasts
        addPodcastToGenre(3, new Podcast("Ancient Civilizations", "Exploring the ancient world"));
        addPodcastToGenre(3, new Podcast("World War II Chronicles", "Stories from the Second World War"));

        // Business podcasts
        addPodcastToGenre(4, new Podcast("Startup Success", "How to build a successful business"));
        addPodcastToGenre(4, new Podcast("Market Trends", "Analysis of current market conditions"));
    }
}
