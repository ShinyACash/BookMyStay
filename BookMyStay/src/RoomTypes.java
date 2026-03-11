/**
 * Specialized room implementations using Inheritance.
 */

class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 100.0, 1);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 180.0, 2);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Luxury Suite", 500.0, 4);
    }
}