package memorysim;

import java.util.List;

public class PhysicalFrames {

    private final static int MAX_SIZE = 4;

    private List<PhysicalFrame> physicalFrameList;

    public PhysicalFrames(List<PhysicalFrame> physicalFrameList) {
        this.physicalFrameList = physicalFrameList;
    }

    public PhysicalFrame getFrame(int index) throws Exception {
        if (index >= MAX_SIZE) throw new Exception("Index >= MAX_SIZE");
        return physicalFrameList.get(index);
    }

    public void setFrame(int index, MemoryReference memoryReference) throws Exception {
        if (index >= MAX_SIZE) throw new Exception("Index >= MAX_SIZE");
        physicalFrameList.get(index).setMemoryReference(memoryReference);

    }
}
