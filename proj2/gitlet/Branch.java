package gitlet;
import java.io.Serializable;
import java.util.*;


public class Branch implements Serializable {
    private Commit head;
    private LinkedList<Commit> commitsList = new LinkedList<>();

    public Branch (Commit commitInformation) {
        commitsList.addLast(commitInformation);
        head = commitsList.get(0);
    }
}

