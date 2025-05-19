package model;

public class Repository extends Deliverable{
    private String url;
    private int fileCount;

    public Repository(String name, DevelopmentPhase phase, String url, int fileCount, String title, String link) {
        super(title,link,phase);
        this.url = url;
        this.fileCount = fileCount;
    }


    protected String generateId() {
        return"repo-" + System.currentTimeMillis();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Repository" + "url =" + url + " - " + "filecount =" + fileCount;
    }
}

