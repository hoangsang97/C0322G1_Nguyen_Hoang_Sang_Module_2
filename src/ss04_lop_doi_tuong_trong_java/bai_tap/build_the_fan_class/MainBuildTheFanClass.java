package ss04_lop_doi_tuong_trong_java.bai_tap.build_the_fan_class;

public class MainBuildTheFanClass {
    public static void main(String[] args) {
        BuildTheFanClass.Fan fan1 =new BuildTheFanClass.Fan(3,true,"green",10);
        BuildTheFanClass.Fan fan2 =new BuildTheFanClass.Fan(2,false,"black",5);
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
