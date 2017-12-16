package memorysim;

import java.util.ArrayList;
import java.util.List;

public class OPTPageReplace extends MemoryAlgorithm {

    private ReferenceString referenceString;
    List<MemoryReference> physicalFrameList;
    private int indexOfReferenceString;
    //Need to know ahead of time if memory will be used.

    public OPTPageReplace() {
        physicalFrameList = new ArrayList<>();
        referenceString = new ReferenceString();
        victimFrames = new ArrayList<>();
        pageFaults = new ArrayList<>();
        for (MemoryReference memoryReference : referenceString.getReferenceList()) {
            System.out.print(memoryReference + " ");
        }
    }

    public OPTPageReplace(ReferenceString referenceString) {
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
        if (!physicalFrameList.contains(memoryReference)) {
            pageFaults.add(true);
            if (physicalFrameList.size() < 4) {
                physicalFrameList.add(memoryReference);
                victimFrames.add(" ");
            } else {
                int frameIndexToReplace = physicalFrameList.indexOf(getVictimFrame(indexOfReferenceString));
                victimFrames.add(physicalFrameList.remove(frameIndexToReplace).toString());
                physicalFrameList.add(frameIndexToReplace, memoryReference);
            }

        } else {
            victimFrames.add(" ");
            pageFaults.add(false);
        }
    }

    public void setFrames(List<MemoryReference> memList) {
        this.physicalFrameList = memList;
    }

    public MemoryReference getVictimFrame(int index) {
        List<MemoryReference> refList = referenceString.getReferenceList();
        for (int i = 0; i < physicalFrameList.size(); i++) {
            for (int j = index; j < refList.size(); j++) {
                //Get the next index where the memory reference is used in the reference string
                if (physicalFrameList.get(i).equals(refList.get(j))) {
                    physicalFrameList.get(i).setIndexUsed(j);
                    physicalFrameList.get(i).setUsed(true);
                    break;
                }
            }

        }
        int latestUsedRef = 0;
        int frameToReplaceIndex = 0;//If none of the mem ref are used for the rest of the string, 0 is replaced by default.
        for (int i = 0; i < physicalFrameList.size(); i++) {
            if (physicalFrameList.get(i).isUsed() == false) {
                return physicalFrameList.get(i);
            }
            if (physicalFrameList.get(i).getIndexUsed() > latestUsedRef) {
                latestUsedRef = physicalFrameList.get(i).getIndexUsed();
                frameToReplaceIndex = i;
            }
        }
        return physicalFrameList.get(frameToReplaceIndex);
    }
}
