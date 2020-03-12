import java.util.Objects;

public class FairyForest {
    final int min = 0; // Минимальное число для диапазона
    final int max = 80; // Максимальное число для диапазона
    protected double ForestX = rnd(min,max);
    protected double ForestY = rnd(min,max);
    protected double size = 40;

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    public void getXY(String name)
    {
        System.out.println("Центр леса "+name + " находиться в координате " + ForestX + " " + ForestY);
    }
    public double getX()
    {
        return(ForestX);
    }
    public double getY()
    {
        return(ForestY);
    }

    @Override
    public String toString() {
        return "FairyForest{" +
                "min=" + min +
                ", max=" + max +
                ", ForestX=" + ForestX +
                ", ForestY=" + ForestY +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FairyForest that = (FairyForest) o;
        return min == that.min &&
                max == that.max &&
                Double.compare(that.ForestX, ForestX) == 0 &&
                Double.compare(that.ForestY, ForestY) == 0 &&
                Double.compare(that.size, size) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max, ForestX, ForestY, size);
    }
}

