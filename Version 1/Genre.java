package TrialPodcast;

public class Genre {
    private String name;
    private ArrayLinkedList podcasts;

    public Genre(String name) {
        this.name = name;
        this.podcasts = new ArrayLinkedList();
    }

    public String getName() {
        return name;
    }

    public ArrayLinkedList getPodcasts() {
        return podcasts;
    }

    public void addPodcast(Podcast podcast) {
        podcasts.addLast(podcast);
    }

    public boolean removePodcast(int index) {
        return podcasts.remove(index);
    }

    public int getPodcastCount() {
        return podcasts.size();
    }

    public Podcast getPodcast(int index) {
        return podcasts.get(index);
    }
}

