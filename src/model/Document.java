package model;

public class Document extends Deliverable{
    private String url;
    private String cloudService;

    public Document(String name, DevelopmentPhase phase, String url, String cloudService, String title, String link){
        super(title,link,phase);
        this.url = url;
        this.cloudService = cloudService;
    }

    
    protected String generateId() {
        return "doc-" + System.currentTimeMillis();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCloudService() {
        return cloudService;
    }

    public void setCloudService(String cloudService) {
        this.cloudService = cloudService;
    }

    @Override
    public String toString(){
        return super.toString() + "Document" + "url = " + url + " - " + "cloudService = " + cloudService;
    }
}
