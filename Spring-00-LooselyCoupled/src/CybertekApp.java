import service.FullTimeMentor;
import service.MentorAccount;
import service.PartTimeMentor;

public class CybertekApp {
    public static void main(String[] args) {

        FullTimeMentor fullTime = new FullTimeMentor();
        MentorAccount mentor = new MentorAccount(fullTime);

        mentor.manageAccount();

        PartTimeMentor partTime = new PartTimeMentor();
        MentorAccount mentor2 = new MentorAccount(partTime);
        mentor2.manageAccount();

        MentorAccount mentor3 = new MentorAccount(new FullTimeMentor());
        mentor3.manageAccount();
        MentorAccount mentor4 = new MentorAccount(new PartTimeMentor());
        mentor4.manageAccount();

    }
}
