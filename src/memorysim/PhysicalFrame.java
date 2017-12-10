package memorysim;

import java.util.Objects;

public class PhysicalFrame {

    private MemoryReference memoryReference;

    public PhysicalFrame() {

    }

    public PhysicalFrame(MemoryReference memoryReference) {
        this.memoryReference = memoryReference;
    }

    public MemoryReference getMemoryReference() {
        if (memoryReference == null) {
            return null;
        }
        return memoryReference;
    }

    public void setMemoryReference(MemoryReference memoryReference){
        this.memoryReference = memoryReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalFrame that = (PhysicalFrame) o;
        return Objects.equals(memoryReference, that.memoryReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memoryReference);
    }
}

