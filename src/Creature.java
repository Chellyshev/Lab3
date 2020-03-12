import java.util.Objects;

abstract public class Creature implements Move,Say{

    protected double pointX = 0;
    protected double pointY = 0;
    protected double step = 0;
    protected int size = 40;
    protected double endX = size;
    protected double endY = size;
    private int notinforest = 0;
    final int min = 0; // Минимальное число для диапазона
    final int max = 100; // Максимальное число для диапазона
    protected double xForrest;
    protected double yForrest;
    protected String CreatureName;
    //protected final String ANSI_BLUE = "\u001B[34m";
    //protected final String ANSI_RESET = "\u001B[0m";

    public void setName(String name)
    {
        CreatureName = name;
    }

    public String getName()
    {
        return (CreatureName);
    }

    @Override
    public String Say(String speech)
    {
        return(speech);

    }

    public void setForrestPoint(double x, double y)
    {
        xForrest = x;
        yForrest = y;
    }

    public void setRandomXY()
    {
        pointX = rnd(min,max);
        pointY = rnd(min,max);
    }

    public void setXY(double x, double y) {
        pointX = x;
        pointY = y;
    }
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    @Override
    public void stepX() {
        step = Math.random()  * 4 ;
        if (pointX + step  >= size + xForrest) endX = xForrest - size;
        if (pointX + step <= xForrest - size) endX = size + xForrest;
        if (endX == xForrest - size) step *= -1;
        pointX += step;

    }
    @Override
    public void stepY() {
        step = Math.random()  * 4 ;
        if (pointY + step >= yForrest + size) endY = yForrest - size;
        if (pointY + step <= yForrest - size) endY = size + yForrest;
        if (endY == yForrest - size) step *= -1;
        pointY += step;
    }

    public double getX() {
        return (pointX);
    }

    public double getY() {
        return (pointY);
    }

    public void go() {
        this.stepX();
        this.stepY();
    }
    public void getXY(String name)
    {
        System.out.println(name +  " переместился на " + pointX + " " + pointY );
        if ((pointX < xForrest - size) || (pointY < yForrest - size) || (pointX > xForrest + size) || (pointY > yForrest + size))
        {
            notinforest += 1;
            if (notinforest == 1) System.out.println(name + " вышел из леса");
            else System.out.println(name + " всё еще не в лесу. По прежнему не в лесу");
        }
        else notinforest = 0;
    }
    public void getXY()
    {
        System.out.println(" " + pointX + " " + pointY);

    }

    @Override
    public String toString() {
        return "Creature{" +
                "pointX=" + pointX +
                ", pointY=" + pointY +
                ", step=" + step +
                ", size=" + size +
                ", endX=" + endX +
                ", endY=" + endY +
                ", notinforest=" + notinforest +
                ", min=" + min +
                ", max=" + max +
                ", xForrest=" + xForrest +
                ", yForrest=" + yForrest +
                ", CreatureName='" + CreatureName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return Double.compare(creature.pointX, pointX) == 0 &&
                Double.compare(creature.pointY, pointY) == 0 &&
                Double.compare(creature.step, step) == 0 &&
                size == creature.size &&
                Double.compare(creature.endX, endX) == 0 &&
                Double.compare(creature.endY, endY) == 0 &&
                notinforest == creature.notinforest &&
                min == creature.min &&
                max == creature.max &&
                Double.compare(creature.xForrest, xForrest) == 0 &&
                Double.compare(creature.yForrest, yForrest) == 0 &&
                Objects.equals(CreatureName, creature.CreatureName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(pointX, pointY, step, size, endX, endY, notinforest, min, max, xForrest, yForrest, CreatureName);
    }
}
