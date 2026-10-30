package net.yteron.island.animal;

public enum EStats {
    WOLF  ("Волк",50,   30,  3, 8),
    SNAKE ("Удав",15,   30,  1, 3),
    FOX   ("Лиса",8,30,  2, 2),
    BEAR  ("Медведь",  500,  5,2, 80),
    EAGLE ("Орел",6,20,  3,1),
    HORSE ("Лошадь", 400,  20,  4, 60),
    DEER  ("Олень",300,  20,4, 50),
    RABBIT("Кролик", 2,150,2, 0.45),
    MOUSE ("Мышь",0.05, 500, 1, 0.01),
    GOAT  ("Коза",60,140,3, 10),
    SHEEP ("Овца",70,140,3, 15),
    BOAR("Кабан",400,50, 2, 50),
    BUFFALO("Буйвол",700,10,  3, 100),
    DUCK("Утка",1,200,4, 0.15),
    CATERPILLAR("Гусеница", 0.01, 1000,0, 0);

    public final String name;
    public final double weight;
    public final int maxPerCell;
    public final int speed;
    public final double foodNeed;

    EStats(String name, double weight, int maxPerCell, int speed, double foodNeed) {
        this.name = name;
        this.weight = weight;
        this.maxPerCell = maxPerCell;
        this.speed = speed;
        this.foodNeed = foodNeed;
    }
}
