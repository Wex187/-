class Weather extends Online {
    private static int objectCount = 0;
    private float accuracy;
    private String shapeIcone;
    private String colorIcone;


    public Weather(String name, String company, float mass, boolean isOnline, float accuracy, String shapeIcone, String colorIcone) {
        super(name, company, mass, isOnline);
        this.accuracy = accuracy;
        this.shapeIcone = shapeIcone;
        this.colorIcone = colorIcone;
        objectCount++;
    }

    public float getAccuracy() {
        return accuracy;
    }
    public String getShapeIcone() {
        return shapeIcone;
    }

    public String getColorIcone() {
        return colorIcone;
    }
    public static int getObjectCount() {
        return objectCount;
    }
    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }
    public void setShapeIcone(String shapeIcone) {
        this.shapeIcone = shapeIcone;
    }
    public void setColorIcone(String colorIcone) {
        this.colorIcone = colorIcone;
    }
    @Override
    public void Fame() {
        System.out.println("Погода - средний по популярности тип приложений");
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Точность: " + accuracy);
        System.out.println("Форма иконки: " + shapeIcone);
        System.out.println("Цвет иконки: " + colorIcone);
    }

    public void displayInfo(int x) {
        super.displayInfo();
        System.out.println("У данного прогноза погоды точность " + accuracy);
        System.out.println("У данного прогноза погоды форма иконки " + shapeIcone);
        System.out.println("У данного прогноза погоды цвет иконки " + colorIcone);
    }
}