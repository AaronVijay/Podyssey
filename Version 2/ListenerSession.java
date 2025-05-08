package TrialPodcast;

public class ListenerSession {
    private ArrayQueue listeningQueue;
    private ArrayStack recentlyPlayed;

    public ListenerSession() {
        listeningQueue = new ArrayQueue();
        recentlyPlayed = new ArrayStack();
    }

    public void addToQueue(Podcast podcast) {
        listeningQueue.enqueue(podcast);
    }

    public void listenToNextPodcast() {
        if (listeningQueue.isEmpty()) {
            System.out.println("Your listening queue is empty. Add podcasts to listen.");
            return;
        }

        Podcast podcast = listeningQueue.dequeue();
        recentlyPlayed.push(podcast);

        System.out.println("\n--- Now Playing ---");
        System.out.println("Title: " + podcast.getTitle());
        System.out.println("Description: " + podcast.getDescription());
        System.out.println("Remaining in queue: " + listeningQueue.size());
    }

    public void displayQueue() {
        System.out.println("\n--- Your Listening Queue ---");

        if (listeningQueue.isEmpty()) {
            System.out.println("Your queue is empty.");
            return;
        }

        Podcast[] podcasts = listeningQueue.getElements();
        for (int i = 0; i < podcasts.length; i++) {
            System.out.println((i + 1) + ". " + podcasts[i].getTitle() + " - " + podcasts[i].getDescription());
        }
    }

    public void displayRecentlyPlayed() {
        System.out.println("\n--- Recently Played (Most Recent First) ---");

        if (recentlyPlayed.isEmpty()) {
            System.out.println("You haven't listened to any podcasts yet.");
            return;
        }

        Podcast[] podcasts = recentlyPlayed.getElements();
        for (int i = podcasts.length - 1; i >= 0; i--) {
            System.out.println((podcasts.length - i) + ". " + podcasts[i].getTitle() + " - " + podcasts[i].getDescription());
        }
    }
}

