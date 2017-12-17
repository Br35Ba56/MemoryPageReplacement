package memorysim;

import java.util.ArrayList;
import java.util.List;

public class LFUPageReplace extends MemoryAlgorithm {
    private ReferenceString referenceString;
    List<MemoryReference> physicalFrameList;
    private int indexOfReferenceString;
    //Need to know ahead of time if memory will be used.

    public LFUPageReplace() {
        physicalFrameList = new ArrayList<>();
        referenceString = new ReferenceString();
        victimFrames = new ArrayList<>();
        pageFaults = new ArrayList<>();
        for (MemoryReference memoryReference : referenceString.getReferenceList()) {
            System.out.print(memoryReference + " ");
        }
    }

    public LFUPageReplace(ReferenceString referenceString) {
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
            System.out.println("\nPhysical Frames: " +physicalFrameList.toString()
                    + "\nVictim Frames" + victimFrames.toString()
                    + "\nPage Faults: " + pageFaults.toString() + " \n");
        }
    }

    @Override
    public void getMemoryReference(MemoryReference memoryReference) {
        memoryReference.incrementReferenceCounter();
        if (!physicalFrameList.contains(memoryReference)) {
            pageFaults.add(true);
            if (physicalFrameList.size() < 4) {
                physicalFrameList.add(memoryReference);
                victimFrames.add(" ");
            } else {
                int frameIndexToReplace = physicalFrameList.indexOf(getVictimFrame());
                victimFrames.add(physicalFrameList.remove(frameIndexToReplace).toString());
                physicalFrameList.add(frameIndexToReplace, memoryReference);
            }

        } else {
            victimFrames.add(" ");
            pageFaults.add(false);
        }
    }

    public MemoryReference getVictimFrame() {

            int leastUsed = physicalFrameList.get(0).getReferenceCounter();
            int frameToReplace = 0;
            for (int i = 0; i < physicalFrameList.size(); i++) {
                if (physicalFrameList.get(i).getReferenceCounter() < leastUsed) {
                    leastUsed = physicalFrameList.get(i).getReferenceCounter();
                    frameToReplace = i;
                }
            }
            System.out.println(physicalFrameList.get(frameToReplace));
            return physicalFrameList.get(frameToReplace);

    }
}
