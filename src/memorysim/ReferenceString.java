package memorysim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReferenceString {
    private static final int MAX = 7;
    private static final int MAX_REFERENCE_LIST_SIZE = 10;
    private List<MemoryReference> referenceList;

    public ReferenceString() {
        referenceList = new ArrayList<>();
        for (int i = 0; i < MAX_REFERENCE_LIST_SIZE; i++) {
            int frameNumber = (int) (Math.random() * (MAX + 1));
            referenceList.add(new MemoryReference(String.valueOf(frameNumber)));
        }
    }

    public List<MemoryReference> getReferenceList(){
        return Collections.unmodifiableList(referenceList);
    }
}
