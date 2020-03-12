import javax.swing.*;
import java.util.Objects;

public class Piglet extends Creature {

    private double scareIndex = 1;
    private double speed = 6;
    private int StepsCount = 0;
    private double health;
    protected int ScareCount = 0;
    private double viewPiglet = 0;

    public double getScareIndex() {
        scareIndex = StepsCount * 0.5;
        return (scareIndex);
    }

    public void setScareIndex(double i) {
        scareIndex += i;

    }

    @Override
    public void stepX() {
        step = Math.random() * speed;
        if (pointX + step >= size + xForrest) endX = xForrest - size;
        if (pointX + step <= xForrest - size) endX = size + xForrest;
        if (endX == xForrest - size) step *= -1;
        pointX += step;
        if (speed == 20) speed = 6;

    }

    @Override
    public void stepY() {
        step = Math.random() * speed;
        if (pointY + step >= yForrest + size) endY = yForrest - size;
        if (pointY + step <= yForrest - size) endY = size + yForrest;
        if (endY == yForrest - size) step *= -1;
        pointY += step;
        if (speed == 20) speed = 6;
    }

    @Override
    public void go() {
        this.stepX();
        this.stepY();
        StepsCount += 1;
        speed -= 1;
        if (speed <= 0) {
            speed = 6;
        }
        if (speed == 2)
            System.out.println(this.Say(this.getName() + " остановился как вкопанный и начал идти медленнее"));
    }


    public void setHealth(double healthPooh) {
        health = healthPooh;
    }

    public double getHealth() {
        if (health <= 0) health = 0;
        return (health);
    }

    public void scare(String name, double x, double y, double PigletView, double damage) {
        if ((x >= (this.getX() - PigletView)) && (x <= (this.getX() + PigletView)) && (y >= (this.getY() - PigletView)) && (y <= (this.getY() + PigletView))) {
            this.setHealth(this.getHealth() - damage);
            this.speed = 20;

            if (this.getHealth() > 0)
                System.out.println(this.Say(this.getName() + " встретился с " + name));
            else System.out.println(this.Say(this.getName() + " уже не в силах осознать встречу с " + name));

            if (this.getHealth() > 0) {
                if (this.getScareIndex() * damage < 30)
                    System.out.println(this.Say(this.getName() + " завизжал от страха"));

                else if ((this.getScareIndex() * damage >= 30) && (this.getScareIndex() * damage < 60))
                    System.out.println(this.Say(this.getName() + " ужасно хотел, чтобы его милый Дедушка Посторонним В. был бы сейчас тут, а не где-то в неизвестном месте... "));

                else System.out.println(this.Say("Хрупкий " + this.getName() + " потерял сознание"));
            }
        }
        System.out.println("");

    }

    public void EmotionalState() {
        if ((this.getHealth() <= 0) && (ScareCount < 1)) {
            ScareCount += 1;
            System.out.println("Здоровье " + this.getName() + " состовляет " + this.getHealth());
            System.out.println(this.getName() + " сошёл с ума");
        }
    }
    public void setView(double view){
        viewPiglet = view;
    }
    public double getView()
    {
        return(viewPiglet);
    }

    @Override
    public String toString() {
        return "Piglet{" +
                "scareIndex=" + scareIndex +
                ", speed=" + speed +
                ", StepsCount=" + StepsCount +
                ", health=" + health +
                ", ScareCount=" + ScareCount +
                ", viewPiglet=" + viewPiglet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Piglet piglet = (Piglet) o;
        return Double.compare(piglet.scareIndex, scareIndex) == 0 &&
                Double.compare(piglet.speed, speed) == 0 &&
                StepsCount == piglet.StepsCount &&
                Double.compare(piglet.health, health) == 0 &&
                ScareCount == piglet.ScareCount &&
                Double.compare(piglet.viewPiglet, viewPiglet) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), scareIndex, speed, StepsCount, health, ScareCount, viewPiglet);
    }
}
