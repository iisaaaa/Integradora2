package model;

public class Artifact extends Deliverable{
    private ArtifactType type;

    public Artifact(String name, DevelopmentPhase phase, ArtifactType type){
        super(name, phase);
        this.type = type;
    }

    @Override
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
