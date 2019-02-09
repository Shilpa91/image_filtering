public class student {
    int roll_no;
    String name;
    String course;
    double[] quizscore = new double[15];

    void student(int roll_no, String name, String course, double[] quizscore) {

        this.roll_no = roll_no;
        this.name = name;
        this.course = course;
        this.quizscore = quizscore;

    }

    public static void main(String[] args) {

        // student dummy = new student();
        // dummy.student(1,"Ayushi","PT", new double[]{1, 2, 3, 4, 5, 3, 2, 1, 4, 5, 6, 7, 8, 9, 4});
        // System.out.println(java.util.Arrays.toString(dummy.quizscore));
        student[] arr = new student[20]; // int a = 10;
        for (int stdnum=0;stdnum<arr.length;stdnum++){
            arr[stdnum]=new student();
        }
        arr[0].student(1,"Ayushi","PT", new double[]{1, 2, 3, 4, 5, 3, 2, 1, 4, 5, 6, 7, 8, 9, 4});
        arr[1].student(2,"Nisha","FT", new double[]{3, 5, 7, 4, 2, 5, 2, 3, 5, 9, 3, 5, 4, 6, 7});
        arr[2].student(3,"Mohan","PT", new double[]{3, 4, 8, 7, 5, 9, 2, 4, 6, 8, 5, 6, 7, 8, 9});
        arr[3].student(4,"Kim","PT", new double[]{3, 2, 3, 6, 5, 3, 9, 7, 7, 5, 6, 7, 3, 4, 8});
        arr[4].student(5,"Aparna","FT", new double[]{7, 5, 8, 9, 3, 6, 7, 8, 3, 2, 6, 5, 2, 3, 7});
        arr[5].student(6,"Ram","FT", new double[]{5, 6, 9, 5, 2, 8, 5, 4, 8, 8, 7, 6, 2, 3, 9});
        arr[6].student(7,"Shyam","PT", new double[]{4, 5, 4, 7, 3, 8, 9, 4, 5, 3, 6, 9, 8, 3, 4});
        arr[7].student(8,"Tom","FT", new double[]{7, 8, 3, 4, 3, 3, 1, 8, 1, 9, 7, 6, 5, 8, 3});
        arr[8].student(9,"Tim","FT", new double[]{1, 4, 5, 7, 2, 4, 5, 1, 5, 3, 6, 2, 4, 6, 9});
        arr[9].student(10,"Neel","PT", new double[]{8, 5, 4, 7, 8, 8, 9, 8, 5, 3, 8, 5, 4, 8, 5});
        arr[10].student(11,"Sid","FT", new double[]{9, 5, 4, 7, 3, 8, 9, 4, 5, 3, 6, 8, 2, 4, 3});
        arr[11].student(12,"Disha","FT", new double[]{4, 5, 4, 7, 3, 8, 9, 4, 5, 3, 7, 5, 8, 6, 3});
        arr[12].student(13,"Ankit","PT", new double[]{4, 5, 3, 5, 3, 2, 2, 4, 5, 3, 3, 6, 8, 7, 2});
        arr[13].student(14,"Nancy","PT", new double[]{4, 5, 6, 2, 3, 8, 9, 4, 5, 3, 7, 4, 8, 5, 6});
        arr[14].student(15,"Shilpa","PT", new double[]{1, 4, 5, 6, 6, 7, 4, 2, 5, 2, 6, 7, 2, 3, 4});
        arr[15].student(16,"Mariya","FT", new double[]{4, 7, 9, 4, 3, 2, 7, 9, 4, 6, 6, 2, 3, 7, 5});
        arr[16].student(17,"Saumya","FT", new double[]{1, 5, 6, 8, 3, 5, 7, 9, 4, 2, 5, 4, 3, 2, 7});
        arr[17].student(18,"Jack","PT", new double[]{4, 5, 4, 7, 3, 8, 9, 4, 5, 3, 1, 4, 5, 6, 8});
        arr[18].student(19,"Rose","FT", new double[]{4, 5, 4, 7, 3, 8, 9, 4, 5, 3, 5, 4, 3, 6, 2});
        arr[19].student(20,"Yuhu","FT", new double[]{1, 5, 7, 9, 4, 5, 7, 6, 5, 4, 1, 2, 4, 5, 6});
        Session ssn = new Session();
        ssn.Session(arr);

        ssn.avgquizscore();
        ssn.sortscore();
        ssn.ptstudentnames();
        ssn.ftstudentscores();


//
//        for (int i=0; i<arr.length; i++){
//            System.out.println("Student at"+i+":"+arr[i].roll_no +" "+ arr[i].name + " " + arr[i].course);
//
//            //calculate average score
//
//            ptstudent pt = new ptstudent();
//            System.out.println("Average of quiz score is : "+ pt.avgquizscore());
//        }


    }
}

class ptstudent extends student {


}

class ftstudent extends student {

    int ExamScore;

}

class Session{

    public student[] AllStudents = new student[20];

    public void Session(student[] AllStudents){
        this.AllStudents = AllStudents;
    }

    public void avgquizscore(){
        double sumval=0.0;
        for (int stdnum=0; stdnum<AllStudents.length; stdnum++) // Loop over all students
        {
            for (int quiznum=0; quiznum<AllStudents[0].quizscore.length; quiznum++) // Loop over all quizzes
            {
                sumval = sumval + AllStudents[stdnum].quizscore[quiznum]; // stdnum = 0->19, quiznum = 0->15 ()
            }
        }
        System.out.println(sumval/(AllStudents.length*AllStudents[0].quizscore.length));
    }

    public void sortscore(){

        for (int stdnum=0; stdnum<AllStudents.length; stdnum++) // Loop over all students

        {
            double[] newarr = AllStudents[stdnum].quizscore;
            java.util.Arrays.sort(newarr);
            System.out.println("Student " + stdnum + " quizscores sorted: " + java.util.Arrays.toString(newarr));

        }

    }

    public void ptstudentnames(){

        for (int stdnum=0; stdnum<AllStudents.length; stdnum++) // Loop over all students

        {
            if(AllStudents[stdnum].course.equals("PT")){
                System.out.println(AllStudents[stdnum].name);
            }

        }

    }

    public void ftstudentscores(){

        for (int stdnum=0; stdnum<AllStudents.length; stdnum++) // Loop over all students

        {
            if(AllStudents[stdnum].course.equals("FT")){
                System.out.println(java.util.Arrays.toString(AllStudents[stdnum].quizscore));
            }

        }

    }

}


