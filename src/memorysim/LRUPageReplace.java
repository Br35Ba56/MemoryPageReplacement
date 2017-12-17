package memorysim;

import java.util.ArrayList;
import java.util.List;

public class LRUPageReplace extends MemoryAlgorithm {
    private ReferenceString referenceString;
    List<MemoryReference> physicalFrameList;
    private int indexOfReferenceString;

    public LRUPageReplace() {
        physicalFrameList = new ArrayList<>();
        referenceString = new ReferenceString();
        victimFrames = new ArrayList<>();
        pageFaults = new ArrayList<>();
        for (MemoryReference memoryReference : referenceString.getReferenceList()) {
            System.out.print(memoryReference + " ");
        }
    }

    public LRUPageReplace(ReferenceString referenceString) {
        this.referenceString = referenceString;
        physicalFrameList = new ArrayList<>();
        victimFrames = new ArrayList<>();
        pageFaults = new ArrayList<>();
        for (MemoryReference memoryReference : referenceString.getReferenceList()) {
            System.out.print(memoryReference + " ");
        }
    }

    public void execute() {
        for (MemoryReference memoryReference : referenceString.getReferenceList()) {
            getMemoryReference(memoryReference);
            indexOfReferenceString++;
            System.out.println("\nPhysical Frames: " +physicalFrameList.toString()
                    + "\nVictim Frames" + victimFrames.toString()
                    + "\nPage Faults: " + pageFaults.toString() + " \n");
        }
    }

    @Override
    public void getMemoryReference(MemoryReference memoryReference) {
        memoryReference.setIndexUsed(indexOfReferenceString);
        if (!physicalFrameList.contains(memoryReference)) {
            pageFaults.add(true);
            if (physicalFrameList.size() < 4) {
               // memoryReference.isLoaded(true);
                physicalFrameList.add(memoryReference);
                victimFrames.add(" ");
            } else {
                int frameToReplace = physicalFrameList.indexOf(getVictimFrame());
               // physicalFrameList.get(frameToReplace).isLoaded(false);

                victimFrames.add(physicalFrameList.remove(frameToReplace).toString());
                physicalFrameList.add(frameToReplace, memoryReference);
                //memoryReference.isLoaded(true);
            }
        } else {
            victimFrames.add(" ");
            pageFaults.add(false);
        }
    }

    //Finds the oldest reference Memory in the physical frame
    public MemoryReference getVictimFrame() {
        int lastUsed = physicalFrameList.get(0).getIndexUsed();
        int frameToReplace = 0;
        for (int i = 0; i < physicalFrameList.size(); i++) {
            if (physicalFrameList.get(i).getIndexUsed() < lastUsed) {
                lastUsed = physicalFrameList.get(i).getIndexUsed();
                frameToReplace = i;
            }
        }
        System.out.println(physicalFrameList.get(frameToReplace));
        return physicalFrameList.get(frameToReplace);
    }
}
