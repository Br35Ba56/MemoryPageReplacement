package memorysim;

import java.util.List;

public class PhysicalFrames {

    private final static int MAX_SIZE = 4;

    private List<PhysicalFrame> physicalFrameList;

    public PhysicalFrames(List<PhysicalFrame> physicalFrameList) {
        this.physicalFrameList = physicalFrameList;
    }

    public PhysicalFrame getFrame(int index) {
        return physicalFrameList.get(index);
    }

    public void setFrame(int index, MemoryReference memoryReference) {
        physicalFrameList.get(index).setMemoryReference(memoryReference);

    }
}
