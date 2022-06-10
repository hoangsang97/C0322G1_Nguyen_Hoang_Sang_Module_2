package _quan_ly_ho_so_hoc_sinh.service.impl;

import _quan_ly_ho_so_hoc_sinh.exception.NotFoundEmployeeException;
import _quan_ly_ho_so_hoc_sinh.models.Certificated;
import _quan_ly_ho_so_hoc_sinh.models.Experience;
import _quan_ly_ho_so_hoc_sinh.service.ExperienceService;
import _quan_ly_ho_so_hoc_sinh.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExperienceServiceImpl implements ExperienceService {
    public static Scanner scanner = new Scanner(System.in);

    public static List<Experience> experienceList = new ArrayList<>();

    public static List<Certificated> certificatedList = new ArrayList<>();

    private static final String REGEX_BIRTHDAY = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    @Override
    public void view() {
        experienceList.clear();

        ReadAndWrite.readExperience("src/_quan_ly_ho_so_hoc_sinh/data/experience.csv", experienceList, certificatedList);

        for (Experience item: experienceList) {
            System.out.println(item);
        }
    }

    @Override
    public void addNew() {
        experienceList.clear();
        certificatedList.clear();
        ReadAndWrite.readExperience("src/_quan_ly_ho_so_hoc_sinh/data/experience.csv", experienceList, certificatedList);

        int candidateID = 0;

        if (experienceList.isEmpty()) {
            candidateID = 1;
        } else {
            for (Experience item: experienceList) {
                candidateID = item.getCandidateID() + 1;
            }
        }

        System.out.println("Nhập Họ và tên: ");
        String fullName = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh (dd/MM/yyyy): ");
        String birthDay = scanner.nextLine();
        System.out.println("Nhập số điện thoại: ");
        int phone = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();

        System.out.println("Nhập kiểu ứng viên: ");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        String candidateType = null;
        boolean checkCandidateType;
        do {
            int inputCheckType = Integer.parseInt(scanner.nextLine());
            if (inputCheckType == 1) {
                candidateType = "Experience";
                checkCandidateType = false;
            } else if (inputCheckType == 2) {
                candidateType = "Fresher";
                checkCandidateType = false;
            } else {
                System.out.println("Không có option này, xin vui long nhập lại!");
                checkCandidateType = true;
            }
        } while (checkCandidateType);

        int candidateCount = experienceList.size();

        System.out.println("Nhập số năm kinh nghiệm: ");
        String expInYear = scanner.nextLine();
        System.out.println("Nhập kỹ năng chuyên môn: ");
        String proSkill = scanner.nextLine();

        System.out.println("nhập số bằng cấp bạn đang có: ");
        int countCertificated = Integer.parseInt(scanner.nextLine());
        Certificated certificated = null;
        for (int i = 0; i < countCertificated; i++) {
            int certificatedID = 1;
            System.out.println("Nhập tên bằng cấp: ");
            String certificateName = scanner.nextLine();
            System.out.println("Nhập level bằng cấp: ");
            String certificateRank = scanner.nextLine();
            System.out.println("Nhập ngày nhận bằng cấp: ");
            String certificatedDate = scanner.nextLine();

            certificated = new Certificated(certificatedID, certificateName, certificateRank, certificatedDate);
            certificatedList.add(certificated);

            ReadAndWrite.writeCertificated("src/_quan_ly_ho_so_hoc_sinh/data/certificated.csv", certificatedList);
        }

        Experience experience = new Experience(candidateID, fullName, birthDay, phone, email, candidateType, candidateCount, expInYear, proSkill, certificated);
        experienceList.add(experience);

        System.out.println("thêm mới thành công!");
        ReadAndWrite.writeExperience("src/_quan_ly_ho_so_hoc_sinh/data/experience.csv", experienceList);
    }

    @Override
    public void delete() {
        experienceList.clear();

        ReadAndWrite.readExperience("src/_quan_ly_ho_so_hoc_sinh/data/experience.csv", experienceList, certificatedList);

        for (Experience item: experienceList) {
            System.out.println(item);
        }

        System.out.println("nhập id muốn xóa: ");

        int CandidateID = Integer.parseInt(scanner.nextLine());

        int count = 0;
        for (int i = 0; i < experienceList.size(); i++) {
            if (CandidateID == experienceList.get(i).getCandidateID()) {
                System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                System.out.println("1. có");
                System.out.println("2. không");

                int inputChoose = Integer.parseInt(scanner.nextLine());

                switch (inputChoose) {
                    case 1:
                        experienceList.remove(i);
                        System.out.println("đã xóa thành công");
                        count++;
                        break;
                    case 2:
                        count++;
                        break;
                }
            }
        }

        try {
            if (count == 0) {
                throw new NotFoundEmployeeException("Id không tồn tại");
            }
        } catch (NotFoundEmployeeException e){
            System.out.println(e.getMessage());
        }

        ReadAndWrite.writeExperience("src/_quan_ly_ho_so_hoc_sinh/data/experience.csv", experienceList);
    }

    @Override
    public void search() {
    }
}
