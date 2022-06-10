package exercise.test;

public class SinhVien extends HocVien{
    public static void main(String[] args) {
        HocVien hv1 = new HocVien();    // line1
        HocVien hv2 = new SinhVien();    // line2
        SinhVien hv3 = new SinhVien();   // line3
//        SinhVien hv4 = new HocVien();    // line4

//        SinhVien hv5 = (SinhVien) hv4;   // line5
        HocVien hv6 = (HocVien) hv3;     // line6
        HocVien hv7 = hv3;                         // line7
    }

}
