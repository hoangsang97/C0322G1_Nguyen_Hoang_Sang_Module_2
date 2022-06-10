package _quan_ly_ho_so_hoc_sinh.views;

import _quan_ly_ho_so_hoc_sinh.service.impl.ExperienceServiceImpl;

public class Main {
    public static void main(String[] args) {
        ExperienceServiceImpl experienceService = new ExperienceServiceImpl();
//        experienceService.addNew();
        experienceService.view();
    }
}
