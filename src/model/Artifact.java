package model;

public class Artifact extends Deliverable{
    private ArtifactType type;

    public Artifact(String name, DevelopmentPhase phase, ArtifactType type, String id, String title, String link){
        super(title,link,phase);
        this.type = type;
    }

    
    protected String generateId(){
        return "Art-" + System.currentTimeMillis();
    }

    public ArtifactType getType() {
        return type;
    }

    public void setType(ArtifactType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + "Artifact" + "type = " + type;
    }
}
