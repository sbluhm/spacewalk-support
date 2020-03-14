package tests.spec;

public class DummyWithoutInit extends DummyClass {
    
    public boolean equals(Object other) {
        ++requests;
        return other instanceof DummyWithoutInit; // all Dummys are equal
    }
}
