import java.util.Arrays;
import java.util.Objects;

public class Walk {

    boolean meet = false;
    double[] Distance;
    double[] coordinates;
    double damage = 0;
    int[] ScareCount;
    String name;

    {
        Distance = new double[4];
        coordinates = new double[4];
        ScareCount = new int[2];
    }


    public void walkInForest(VinniePooh Pooh, Piglet Piglet, Monster SpringTrap, Monster MaxPower) throws InterruptedException {
        while ((Pooh.getHealth() > 0) || (Piglet.getHealth() >0))
        {
            Thread.sleep(800);
            Pooh.go();
            Pooh.getXY(Pooh.getName());

            Piglet.go();
            Piglet.getXY(Piglet.getName());


            SpringTrap.go();
            SpringTrap.getXY(SpringTrap.getName());

            MaxPower.go();
            MaxPower.getXY(MaxPower.getName());

            Distance[0] = SpringTrap.findDistance(Pooh.getX(), Pooh.getY());
            Distance[1] = MaxPower.findDistance(Pooh.getX(), Pooh.getY());
            Distance[2] = SpringTrap.findDistance(Piglet.getX(), Piglet.getY());
            Distance[3] = MaxPower.findDistance(Piglet.getX(), Piglet.getY());

            if (Distance[0] < Distance[1]) {
                coordinates[0] = SpringTrap.getX();
                coordinates[1]= SpringTrap.getY();
                damage = SpringTrap.getScare();
                name=SpringTrap.getName(); }
            else {
                coordinates[0] = MaxPower.getX();
                coordinates[1]= MaxPower.getY();
                name= MaxPower.getName();
                damage= MaxPower.getScare(); }

            if (Distance[2] < Distance[3]) {
                coordinates[2] = SpringTrap.getX();
                coordinates[3]= SpringTrap.getY();
                damage = SpringTrap.getScare();
                name=SpringTrap.getName(); }
            else {
                coordinates[2] = MaxPower.getX();
                coordinates[3]= MaxPower.getY();
                name= MaxPower.getName();
                damage= MaxPower.getScare(); }

            Pooh.scare(name,coordinates[0],coordinates[1],Pooh.getView(),damage);
            Piglet.scare(name,coordinates[2],coordinates[3],Piglet.getView(), damage);
            Pooh.EmotionalState();
            Piglet.EmotionalState();

        }




    }

    @Override
    public String toString() {
        return "Walk{" +
                "meet=" + meet +
                ", Distance=" + Arrays.toString(Distance) +
                ", coordinates=" + Arrays.toString(coordinates) +
                ", damage=" + damage +
                ", ScareCount=" + Arrays.toString(ScareCount) +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Walk walk = (Walk) o;
        return meet == walk.meet &&
                Double.compare(walk.damage, damage) == 0 &&
                Arrays.equals(Distance, walk.Distance) &&
                Arrays.equals(coordinates, walk.coordinates) &&
                Arrays.equals(ScareCount, walk.ScareCount) &&
                Objects.equals(name, walk.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(meet, damage, name);
        result = 31 * result + Arrays.hashCode(Distance);
        result = 31 * result + Arrays.hashCode(coordinates);
        result = 31 * result + Arrays.hashCode(ScareCount);
        return result;
    }
}
