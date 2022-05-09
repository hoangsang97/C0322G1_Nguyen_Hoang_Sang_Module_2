package ss04_lop_doi_tuong_trong_java.bai_tap;

public class BuildTheFanClass {
    public static void main(String[] args) {
        Fan fan1 =new Fan(3,true,"green",10);
        Fan fan2 =new Fan(2,false,"black",5);
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }

    public static class Fan {
        final double SLOW = 1;
        final double MEDIUM = 2;
        final double FAST = 3;
        int speed = (int) SLOW;
        boolean on = false;
        double radius = 5;
        String color = "blue";

        public double getSLOW() {
            return SLOW;
        }

        public double getMEDIUM() {
            return MEDIUM;
        }

        public double getFAST() {
            return FAST;
        }

        public int getSpeed() {
           return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public boolean isOn() {
            return on;
        }

        public void setOn(boolean on) {
            this.on = on;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Fan(int speed, boolean on, String color, double radius) {
            this.speed = speed;
            this.radius = radius;
            this.color = color;
            this.on = on;
        }

        @Override
        public String toString() {
            String state = "";
            if (this.isOn()) {
                state += ("Fan is on\n");
                state += ("Speed: " + this.speed + "\n");
            } else {
                state += ("Fan is off");
            }
            state += ("Color: " + this.color + "\n");
            state += ("Radius: " + this.radius + "\n");
            return state;
        }
    }
}
