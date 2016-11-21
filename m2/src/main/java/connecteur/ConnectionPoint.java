package connecteur;

/**
 * Created by clement on 14/11/16.
 */
public class ConnectionPoint {

    private String message;
    private Object parent;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

}
