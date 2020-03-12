import java.util.Objects;

public class Monster extends Creature
{
    protected double distance1=0;
    private double scareindex;

    public  void setScare(int ScareMonster)
    {
        scareindex = ScareMonster;

    }
    public double getScare()
    {
        return(scareindex);
    }

    public double findDistance(double X, double Y)
    {
        distance1=Math.pow((X - this.getX()),2) + Math.pow((Y - this.getY()),2);
        return (distance1);
    }

    @Override
    public String toString() {
        return "Monster{" +
                "distance1=" + distance1 +
                ", scareindex=" + scareindex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monster monster = (Monster) o;
        return Double.compare(monster.distance1, distance1) == 0 &&
                Double.compare(monster.scareindex, scareindex) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), distance1, scareindex);
    }


}

