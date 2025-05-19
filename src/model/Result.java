package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Result {
    private String id;
    private String name;
    private String description;
    private List<Deliverable> deliverables;

    public Result(String name, String description) {
        this.id = generateResultId();
        this.name = name;
        this.description = description;
        this.deliverables = new ArrayList<>();
    }

    private String generateResultId() {
        return "Res-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Deliverable> getDeliverables() {
        return deliverables;
    }

    public void addDeliverable(Deliverable deliverable) {
        deliverables.add(deliverable);
    }

    public void deleteDeliverable(String deliverableId) {
        deliverables.removeIf(d -> d.getId().equals(deliverableId));
    }

    @Override
    public String toString() {
        return "Result{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deliverables=" + deliverables +
                '}';
    }
}
