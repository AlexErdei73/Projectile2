import java.text.DecimalFormat;

public class Simulation {
    private double drag;
    private double v0;
    private double angleInDegrees;
    private double angle;
    private double t;
    private double range;
    private Plot plot;
    private DecimalFormat decimal;
    Simulation() {
        this.plot = new Plot("Trajectory Of Projectile With Air Resistance", 0, 10, 1, 0, 10, 1);
        this.plot.setPointSize(1);
        this.decimal = new DecimalFormat("0.0000");
    }

    public void launch(double drag, double v0, double angleInDegrees) {
        this.drag = drag;
        this.v0 = v0;
        this.angleInDegrees = angleInDegrees;
        this.angle = angleInDegrees / 180 * Math.PI;
        double ax, ay, axmid, aymid, vx, vy, vxmid, vymid, x, y, xmid, ymid, g, gx, gy, dt, t;
        vx = this.v0 * Math.cos(this.angle);
        vy = this.v0 * Math.sin(this.angle);
        x = 0;
        y = 0;
        g = 9.8;
        gx = 0;
        gy = -g;
        dt = 0.01;
        t = 0;
        while (y >= 0) {
            ax = this.aComponent(gx, vx, this.v(vx, vy));
            ay = this.aComponent(gy, vy, this.v(vx, vy));
            vxmid = vx + ax * 0.5 * dt;
            vymid = vy + ay * 0.5 * dt;
            xmid = x + vx * 0.5 * dt;
            ymid = y + vy * 0.5 * dt;
            axmid = this.aComponent(gx, vxmid, this.v(vxmid, vymid));
            aymid = this.aComponent(gy, vymid, this.v(vxmid, vymid));
            x += vxmid * dt;
            y += vymid * dt;
            vx += axmid * dt;
            vy += aymid * dt;
            t += dt;
            this.plot.addPoint(x, y);
        }
        this.correctFinalResult(x, y, vx, vy, t);
        this.output();
    }

    private double aComponent(double gComponent, double vComponent, double v) {
        return gComponent - this.drag * v * vComponent;
    }

    private double v(double vx, double vy) {
        return Math.pow((vx * vx + vy * vy), 0.5);
    }

    private void correctFinalResult(double x, double y, double vx, double vy, double t) {
        double delta_t = y / vy;
        this.t = t - delta_t;
        this.range = x - vx * delta_t;
    }

    private void output() {
        System.out.println("Speed = " + this.v0 + " m/s");
        System.out.println("Angle = " + this.angleInDegrees + " degrees");
        System.out.println("Drag = " + this.drag + " 1/m");
        System.out.println("Flight time = " + this.decimal.format(this.t) + " s");
        System.out.println("Range = " + this.decimal.format(this.range) + " m");
    }
}
