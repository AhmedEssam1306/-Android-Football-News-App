package finalp.project;

/**
 * Created by Mohammed on 30-Nov-16.
 */
public class Competition {
    private String CompId;
    private String CompName;

    public String getProductId() {
        return CompId;
    }

    public String getName() {
        return CompName;
    }

    public Competition(String CompId, String CompName) {
        this.CompId = CompId;
        this.CompName = CompName;    }
}

