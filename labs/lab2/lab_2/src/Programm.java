public class Programm {
    public static void main(String[] args) {
        SocialNetwork socialnetwork = new SocialNetwork("Instagram", "Mark II", 1.2f, true, 3, "Для знакомств", false);
        Game game = new Game("Wither 3", "CD Project", 89.78f,  false, "Ролевая", 9.8f, 75.6f);
        Weather weather = new Weather("Яндекс Погода", "Яндекс",  0.4f, true, 0.92f, "Квадрат", "Жёлтый");
        Weather weather2 = new Weather("Яндекс Погода", "Яндекс",  0.4f, true, 0.92f, "Квадрат", "Жёлтый");
        socialnetwork.displayInfo();
        System.out.println();
        game.displayInfo(1);
        System.out.println();
        weather.displayInfo();
        System.out.println();
        System.out.println("Создано объектов (Социальная сеть): " + SocialNetwork.getObjectCount());
        System.out.println("Создано объектов (Игра): " + Game.getObjectCount());
        System.out.println("Создано объектов (Погода): " + Weather.getObjectCount());
        game.setRating(9.8f);
        System.out.println(game.getRating());
        socialnetwork.Fame();
        game.Fame();
        weather.Fame();
        System.out.println("Создано объектов (Всего): " + Apps.getCou());
    }
}