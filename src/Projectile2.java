public class Projectile2 {
    public static void main(String[] args) {
        Simulation projectile = new Simulation();
        projectile.launch(0, 9.8995, 45);
        projectile.launch(0.05, 9.8995, 45);
        projectile.launch(0.1, 9.8995, 45);
        projectile.launch(0.2, 9.8995, 45);
    }
}