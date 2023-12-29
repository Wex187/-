class SocialNetwork extends Online {
    private int accessLevels;
    private String type;
    private boolean availableInRussia;
    private static int objectCount = 0;

    public SocialNetwork(String name, String company, float mass, boolean isOnline, int accessLevels, String type, boolean availableInRussia) {
        super(name, company, mass, isOnline);
        this.accessLevels = accessLevels;
        this.type = type;
        this.availableInRussia = availableInRussia;
        objectCount++;
    }

    public int getAccessLevels() {
        return accessLevels;
    }
    public String getType() {
        return type;
    }
    public boolean getisAvailableInRussia() {
        return availableInRussia;
    }
    public static int getObjectCount() {
        return objectCount;
    }
    public void setAccessLevels(int accessLevels) {
        this.accessLevels = accessLevels;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setAvailableInRussia(boolean availableInRussia) {
        this.availableInRussia = availableInRussia;
    }
    @Override
    public void Fame(){
        System.out.println("Социальные сети - крайне популярный тип приложений");
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Количество уровней доступа: " + accessLevels);
        System.out.println("Тип: " + type);
        System.out.println("Доступно в России: " + (availableInRussia ? "Да" : "Нет"));
    }

    public void displayInfo(int x) {
        super.displayInfo();
        System.out.println("У данной социальной сети - " + accessLevels + " уровней доступа");
        System.out.println("Эта Социальная сеть имеет тип: " + type);
        System.out.println("Данная социальная сеть " + (availableInRussia ? "доступна" : "не доступна") + " в России");
    }
}