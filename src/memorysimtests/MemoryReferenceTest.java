package memorysimtests;

import static org.junit.Assert.*;

import memorysim.MemoryReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MemoryReferenceTest {
    MemoryReference memoryReference;
    @Before
    public void setUp() throws Exception {
        memoryReference = new MemoryReference("1");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMemoryReferenceName(){
        assertEquals("1", memoryReference.getName());
    }
}