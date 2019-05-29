package props;

import org.apache.commons.lang3.ObjectUtils;

public class CraneDetails {
    private String location;
    private String Latitude;
    private String description;
    private String ownerOrDeveloper;
    private String cost;
    private String status;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerOrDeveloper() {
        return ownerOrDeveloper;
    }

    public void setOwnerOrDeveloper(String ownerOrDeveloper) {
        this.ownerOrDeveloper = ownerOrDeveloper;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExstimatedCompletion() {
        return exstimatedCompletion;
    }

    public void setExstimatedCompletion(String exstimatedCompletion) {
        this.exstimatedCompletion = exstimatedCompletion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String exstimatedCompletion;
    private String url;
}
