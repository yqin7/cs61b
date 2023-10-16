package gitlet;

import java.io.File;
import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author Ye Qin
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    /* TODO: fill in the rest of this class. */


    /** start with one commit: initial commit.
     * It will have a single branch: master.
     * points to this initial commit, and master will be the current branch.
     * The timestamp for this initial commit will be 00:00:00 UTC, Thursday, 1 January 1970
     *  all repositories will automatically share this commit
     *  (they will all have the same UID) */
    public static void init() {
        GITLET_DIR.mkdir();
        Commit initial = new Commit("initial commit", null);
        Branch master = new Branch(initial);
        /* Using this name for saved commit is bad, try to figure by hashing */
        File initialCommitFile = Utils.join(GITLET_DIR, initial.getUID());
        Utils.writeObject(initialCommitFile, initial);
        File branchFile = Utils.join(GITLET_DIR, "Master Branch");
        Utils.writeObject(branchFile, master);

    }

    public void commit() {
        // Read from my computer the head commit object and the staging area.
        // Clone the HEAD commit
        // Modify its message and timestamp according to user input
        // Use the staging area in order to modify the files tracked by the new commit
        // Write back any new object made or any modified objects read earlier.
    }

}
