public enum Week {
    
    MONDAY(1, "Bazar Ertəsi", false),
    TUESDAY(2, "Çərşənbə Axşamı", false),
    WEDNESDAY(3, "Çərşənbə", false),
    THURSDAY(4, "Cümə Axşamı", false),
    FRIDAY(5, "Cümə", false),
    SATURDAY(6, "Şənbə", true),
    SUNDAY(7, "Bazar", true);
    
    private final int idx;
    private final String translation_AZE;
    private final boolean isEndOfWeek;
    
    Week (int idx, String translationAze, boolean isEndOfWeek) {
        this.idx = idx;
        this.translation_AZE = translationAze;
        this.isEndOfWeek = isEndOfWeek;
    }
    
    public static Week getDayByIndex (int idx) {
        Week[] week = Week.values();
        
        for (Week day : week) {
            if (day.getIdx() == idx) {
                return day;
            }
        }
        System.out.println("Wrong day!");
        return null;
    }
    
    public int getIdx () {
        return idx;
    }
    
    public String getTranslation_AZE () {
        return translation_AZE;
    }
    
    public boolean isEndOfWeek () {
        return isEndOfWeek;
    }
}
