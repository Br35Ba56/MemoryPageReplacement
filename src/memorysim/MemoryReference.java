package memorysim;

import java.util.Objects;

public class MemoryReference {
    private String name;
    private int indexUsed;
    private int referenceCounter;
    private boolean isUsed = false;

    public MemoryReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemoryReference that = (MemoryReference) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public int getIndexUsed() {

        return indexUsed;
    }

    public void setIndexUsed(int indexUsed) {
        this.indexUsed = indexUsed;
        System.out.println(this + " index Used: " + indexUsed);
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public int getReferenceCounter() {
        return referenceCounter;
    }

    public void incrementReferenceCounter() {
        referenceCounter += 1;
    }
}
