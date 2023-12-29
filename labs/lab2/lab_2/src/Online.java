class Online extends Apps {
    private boolean isOnline;
    public Online(String name, String company, float mass, boolean isOnline) {
        super(name, company, mass);
        this.isOnline = isOnline;
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Тип приложения: " + (isOnline ? "Онлайн" : "Офлайн"));
    }
    @Override
    public void Fame(){

    }
}
