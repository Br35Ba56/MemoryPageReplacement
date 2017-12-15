package memorysim;

import java.util.Collections;
import java.util.List;

public abstract class MemoryAlgorithm {

    public List<Boolean> pageFaults;
    public List<String> victimFrames;

    public List<String> getVictimFrames() {
        return Collections.unmodifiableList(victimFrames);
    }

    public List<Boolean> getPageFaults() {
        return Collections.unmodifiableList(pageFaults);
    }
}

