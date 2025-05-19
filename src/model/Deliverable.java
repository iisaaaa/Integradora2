package model;

import java.util.UUID;

public class Deliverable {
    private String id;
    private String title;
    private String link;
    private DevelopmentPhase phase; // Link al archivo, puede ser Drive o similar

    public Deliverable(String title, String link, DevelopmentPhase phase) {
        this.id = generateDeliverableId();
        this.title = title;
        this.link = link;
        this.phase=phase;
    }

    private String generateDeliverableId() {
        return "Deliv-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Deliverable{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
