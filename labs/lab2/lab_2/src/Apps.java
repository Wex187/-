abstract class Apps {
    private String name;
    private String company;
    private String mass;
    private static int cou = 0;

    public Apps(String name, String company, float mass) {
        this.name = name;
        this.company = company;
        this.mass = String.valueOf(mass);
        cou++;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getMass() {return mass;}
    public static int getCou() {
        return cou;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setMass(String mass) {this.mass = mass;}

    public void displayInfo() {
        System.out.println("Название: " + name);
        System.out.println("Компaния: " + company);
        System.out.println("Вес в гб: " + mass);
    }
    public abstract void Fame();
}