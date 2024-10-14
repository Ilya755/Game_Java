import java.awt.*;
import java.util.LinkedList;

public class Weapon implements Attack{
    public LinkedList<Bullet> bullets;
    Image image_bullet;

    public Weapon(Image image) {
        this.bullets = new LinkedList<>();
        this.image_bullet = image;
    }

    @Override
    public void toAttack(HealthPoint enemy) {

    }
    public void toShoot(double x, double y, double angle, Direction direction) {
        bullets.addLast(new Bullet(x, y, 30, angle, 30, direction, image_bullet));
    }
    public void draw(Graphics g) {
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw(g);
        }
    }
    public void moveBullets() {
        LinkedList<Bullet> new_bullets = new LinkedList<>();
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).move();
            if (bullets.get(i).x <= 2000 && bullets.get(i).x >= 0 &&
                    bullets.get(i).y <= 2000 && bullets.get(i).y >= 0) {
                new_bullets.add(bullets.get(i));
            }
        }
        bullets = new_bullets;
    }
    public LinkedList<Bullet> getBullets() {
        return bullets;
    }

    public void removeBullet(Bullet bullet) {
        bullets.remove(bullet);
    }
}