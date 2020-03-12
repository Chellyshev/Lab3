public class MapInfo {

    public void Info(VinniePooh pooh,Piglet piglet,Monster springtrap, Monster maxpower, FairyForest DarkForest)
    {
        System.out.print("Начальные координаты " + pooh.getName() + "a");
        pooh.getXY();

        System.out.print("Начальные координаты " + piglet.getName());
        piglet.getXY();


        System.out.print("Начальные координаты " + springtrap.getName() + "а");
        springtrap.getXY();

        System.out.print("Начальные координаты " + maxpower.getName() +"а");
        maxpower.getXY();

        pooh.setForrestPoint(DarkForest.getX(), DarkForest.getY());
        springtrap.setForrestPoint(DarkForest.getX(), DarkForest.getY());
        maxpower.setForrestPoint(DarkForest.getX(), DarkForest.getY());
        piglet.setForrestPoint(DarkForest.getX(), DarkForest.getY());

    }

    @Override
    public String toString() {
        return "MapInfo{}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
