package in.pci.nrlmta.models;

import java.io.Serializable;

public class ListItem implements Serializable {
    String state;
    int count;

    public ListItem(String state, int count) {
        this.state = state;
        this.count = count;
    }

    public String getState() {
        return state;
    }

    public int getCount() {
        return count;
    }
}
