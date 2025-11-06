public enum StopId {
    STOP1("Stop 1 - Mərkəzi Bank"),
    STOP2("Stop 2 - Hökümət Evi"),
    STOP3("Stop 3 - İçərişəhər"),
    STOP4("Stop 4 - Bayıl");

    private final String label;

    StopId(String stop) {
        this.label = stop;
    }

    public String getLabel() {
        return label;
    }
}
