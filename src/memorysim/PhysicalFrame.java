package memorysim;

public class PhysicalFrame {

    private MemoryReference memoryReference;

    public PhysicalFrame(MemoryReference memoryReference) {
        this.memoryReference = memoryReference;
    }

    public MemoryReference getMemoryReference() {
        return memoryReference;
    }

    public void setMemoryReference(MemoryReference memoryReference){
        this.memoryReference = memoryReference;
    }



}

