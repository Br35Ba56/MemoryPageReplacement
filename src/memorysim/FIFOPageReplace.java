package memorysim;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FIFOPageReplace extends MemoryAlgorithm {
    //Uses Queue for memory
    private List<PhysicalFrame> frameList;
    private List<MemoryReference> memoryRef;
    private List<Boolean> pageFaults;

    public FIFOPageReplace(List<MemoryReference> memoryRef){
        frameList = new LinkedList<>();
        this.memoryRef = memoryRef;
        this.pageFaults = new ArrayList<>();

    }
}
