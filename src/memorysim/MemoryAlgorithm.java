package memorysim;

import java.util.List;

public abstract class MemoryAlgorithm {
    public boolean pageFaults;
    List<MemoryReference> referenceStrings;
    List<String> victimFrames;

}

class MemoryReference {
    String referenceString;
}
