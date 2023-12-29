class Game extends Online {
    private static int objectCount = 0;
    private String genre;
    private float rating;
    private float downloads;


    public Game(String name, String company, float mass,boolean isOnline, String genre, float rating, float downloads) {
        super(name, company, mass, isOnline);
        this.genre = genre;
        this.rating = rating;
        this.downloads = downloads;
        objectCount++;
    }
    public String getGenre() {
        return genre;
    }

    public float getRating() {
        return rating;
    }
    public float getDownloads() {
        return downloads;
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }
    @Override
    public void Fame() {
        System.out.println("Игры - популярный тип приложений");
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Жанр: " + genre);
        System.out.println("Рейтинг: " + rating);
        System.out.println("Скачиваний в млн.: " + downloads);
    }
    public void displayInfo(int x) {
        super.displayInfo();
        System.out.println("Жанр данной игры: " + genre);
        System.out.println("Рейтинг данной игры в млн.:  " + rating);
        System.out.println("Количество скачиваний игры:  " + downloads);
    }
}