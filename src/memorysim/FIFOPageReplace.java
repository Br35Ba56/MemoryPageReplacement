package memorysim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FIFOPageReplace extends MemoryAlgorithm {
    //Uses Queue for memory
    private ReferenceString referenceString;
    List<MemoryReference> physicalFrameList;

    public FIFOPageReplace(){
        physicalFrameList = new LinkedList<>();
        referenceString = new ReferenceString();
        victimFrames = new ArrayList<>();
        pageFaults = new ArrayList<>();
        for (MemoryReference memoryReference : referenceString.getReferenceList()) {
            System.out.print(memoryReference + " ");
        }
    }

    public FIFOPageReplace(ReferenceString referenceString) {
        this.referenceString = referenceString;
        physicalFrameList = new LinkedList<>();
        victimFrames = new ArrayList<>();
        pageFaults = new ArrayList<>();
        for (MemoryReference memoryReference : referenceString.getReferenceList()) {
            System.out.print(memoryReference + " ");
        }
    }

    public void execute() {
        for (MemoryReference memoryReference : referenceString.getReferenceList()) {
            getMemoryReference(memoryReference);
            System.out.println(physicalFrameList.toString() +"\n" +
            victimFrames.toString() + "\n" +
            pageFaults.toString() + "\n");
        }

    }

    private boolean pageFault(MemoryReference memoryReference){
        return physicalFrameList.contains(memoryReference);
    }

    private void getMemoryReference(MemoryReference memoryReference) {
        if (!physicalFrameList.contains(memoryReference)) {
            pageFaults.add(true);
            if (physicalFrameList.size() < 4) {
                physicalFrameList.add(0, memoryReference);
                victimFrames.add(" ");
            } else {
                victimFrames.add(physicalFrameList.remove(3).getName());
                physicalFrameList.add(0, memoryReference);
            }
        } else {
            victimFrames.add(" ");
            pageFaults.add(false);
        }

    }

}
