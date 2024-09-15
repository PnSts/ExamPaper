/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PanDim
 */
public class ExamCenter {
    private ExamPaper[] examPapers;
    private Teacher[] teachers;

    public ExamCenter(ExamPaper[] examPapers, Teacher[] teachers) {
        this.examPapers = examPapers;
        this.teachers = teachers;
    }

    public void displayMarks() {
        for (int i = 0; i < examPapers.length; i++) {
            //Σε κάθε γραμμή εμφανίζεται ο κωδικός του γραπτού μαζί με τον βαθμό του
            //που υπολογίζεται από τη μέθοδο calculateMark
            System.out.println("Γραπτό: " + examPapers[i].getPaperID() + ", Βαθμός: " + examPapers[i].calculateMark() );
        }
    }

    public void displayTeacherAverages() {
	//δήλωση βοηθητικών μεταβλητών (άθροισμα βαθμών βαθμολογητή, μετρητής 
        //γραπτών που βαθμολόγησε) 
        int teacher_bath_syn, count;  
        
        for (int i = 0; i < teachers.length; i++) {
            //μηδενισμός βοηθητικών μεταβλητών για κάθε βαθμολογητή
            teacher_bath_syn = count = 0; 
            
            for (int j = 0; j < examPapers.length; j++) {
                //εύρεση για κάθε βαθμολογητή τις βαθμολογίες που έβαλε σε κάθε γραπτό
                
                if (examPapers[j].getTeacherMark(teachers[i]) != -1){ 
                    //αθροίζει τις βαθμολογίες που έχει βάλει
                    teacher_bath_syn += examPapers[j].getTeacherMark(teachers[i]); 
                    //μετρητής γραπτών που βαθμολόγησε
                    count++;
                }
            }
            //Σε κάθε γραμμή εμφανίζεται το όνομα του βαθμολογητή μαζί με τον 
            //μέσο όρο των βαθμών που έβαλε αυτός στα γραπτά του κέντρου
            System.out.println("Βαθμολογητής: " + teachers[i].getName() + ", Μέση βαθμολογία: " + teacher_bath_syn / count );
        }
    } 
    
}
